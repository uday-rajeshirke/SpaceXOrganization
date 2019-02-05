package com.uday.android.spacexorg.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uday.android.spacexorg.ui.utils.CarouselEffectTransformer;
import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.network.model.photos.Photo;
import com.uday.android.spacexorg.ui.adapter.GalleryPagerAdapter;
import com.uday.android.spacexorg.ui.viewmodel.GalleryViewModel;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GalleryActivity extends MainActivity {

    public static final int ADAPTER_TYPE_FOREGROUND = 1;
    public static final int ADAPTER_TYPE_BOTTOM = 2;

    private GalleryViewModel mViewModel;
    private GalleryPagerAdapter mGalleryAdapterForeground, mGalleryAdapterBackground;
    private List<Photo> mPhotos;
    private Unbinder mUnBinder;
    private InternetAvailabilityChecker mInternetAvailabilityChecker;
    private InternetConnectivity mInternetConnectivity;
    private Boolean isInternet;

    @BindView(R.id.lyt_main_gallery)
    LinearLayout mMainLayout;
    @BindView(R.id.view_pager_gallery_foreground)
    ViewPager mViewPagerForeground;
    @BindView(R.id.view_pager_gallery_background)
    ViewPager mViewPagerBackground;
    @BindView(R.id.toolbar_gallery)
    Toolbar toolbar;
    @BindView(R.id.txt_gallery_image_title)
    TextView mTxtImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_gallery,mFrameLayoutContentHolder);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mUnBinder = ButterKnife.bind(this);

        mViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        mInternetAvailabilityChecker = InternetAvailabilityChecker.getInstance();
        mInternetConnectivity = new InternetConnectivity();
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mViewPagerForeground.setClipChildren(false);
        mViewPagerForeground.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        mViewPagerForeground.setOffscreenPageLimit(3);
        mViewPagerForeground.setPageTransformer(false, new CarouselEffectTransformer(this));
        setupViewPager();

    }

    private void observeLiveData() {
        if(isInternet) {
            mViewModel.getAllPhotos().observe(this,photoList -> {
                if(photoList != null && photoList.size() > 0) {
                    mPhotos = photoList;
                    mGalleryAdapterForeground.setPhotoList(photoList);
                    mGalleryAdapterBackground.setPhotoList(photoList);
                }
            });

        } else {
            showNoInternetDialog();
        }
    }

    private class InternetConnectivity implements InternetConnectivityListener {
        @Override
        public void onInternetConnectivityChanged(boolean isConnected) {
            isInternet = isConnected;
            if(!isConnected) {
                showNoInternetDialog();
            } else {
                observeLiveData();
            }
        }
    }

    private void showNoInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.text_no_internet_connection));
        builder.setPositiveButton(R.string.snackbar_action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(isInternet)
                    onResume();
                else
                    showNoInternetDialog();
            }
        });
        builder.show();
    }

    private void setupViewPager() {

        mGalleryAdapterForeground = new GalleryPagerAdapter(ADAPTER_TYPE_FOREGROUND);
        mViewPagerForeground.setAdapter(mGalleryAdapterForeground);

        mGalleryAdapterBackground = new GalleryPagerAdapter(ADAPTER_TYPE_BOTTOM);
        mViewPagerBackground.setAdapter(mGalleryAdapterBackground);

        mViewPagerForeground.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;

            @Override
            public void onPageSelected(int position) {
                index = position;
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = mViewPagerBackground.getWidth();
                mViewPagerBackground.scrollTo((int) (width * position + width * positionOffset), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mViewPagerBackground.setCurrentItem(index);
                    mTxtImageTitle.setText(mPhotos.get(index).getTitle());
                }

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mInternetConnectivity!=null)
            mInternetAvailabilityChecker
                    .removeInternetConnectivityChangeListener(mInternetConnectivity);

        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }

}
