package com.uday.android.spacexorg.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.network.model.photos.Photo;
import com.uday.android.spacexorg.ui.activity.GalleryActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryPagerAdapter extends PagerAdapter {

    private List<Photo> mPhotoList;
    private int mAdapterType;
    @BindView(R.id.lyt_gallery_foreground)
    LinearLayout mLytGalleryForeground;
    @BindView(R.id.img_gallery_foreground)
    ImageView mImgForeground;

    public GalleryPagerAdapter(int adapterType) {
        this.mAdapterType = adapterType;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.gallery_item_foreground, null);
        try {

            ButterKnife.bind(this, view);
            mLytGalleryForeground.setTag(position);

            switch (mAdapterType) {
                case GalleryActivity.ADAPTER_TYPE_FOREGROUND:
                    mLytGalleryForeground.setBackgroundResource(R.drawable.shadow);
                    break;
                case GalleryActivity.ADAPTER_TYPE_BOTTOM:
                    mLytGalleryForeground.setBackgroundResource(0);
                    break;
            }

            Picasso.get().load(mPhotoList.get(position).getPhotoURL()).into(mImgForeground);
            container.addView(view);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mPhotoList == null ? 0 : mPhotoList.size();
    }

    public void setPhotoList(List<Photo> photoList) {
        this.mPhotoList = photoList;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

}