package com.uday.android.spacexorg.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.CompanyEntity;
import com.uday.android.spacexorg.ui.viewmodel.AboutCompanyViewModel;

import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AboutCompanyFragment extends Fragment {

    private AboutCompanyViewModel mViewModel;
    private CompanyEntity mCompanyEntity;
    private Unbinder mUnBinder;
    private DrawerLayout mDrawer;

    @BindView(R.id.toolbar_about_company)
    Toolbar mToolbar;
    @BindView(R.id.txt_company_foundation_details)
    TextView mTxtCompanyFoundation;
    @BindView(R.id.txt_company_headquarters_address)
    TextView mTxtCompanyHeadquartersAddress;
    @BindView(R.id.txt_company_summary)
    TextView mTxtCompanySummary;
    @BindView(R.id.txt_company_ceo)
    TextView mTxtCompanyCEO;
    @BindView(R.id.txt_company_cto)
    TextView mTxtCompanyCTO;
    @BindView(R.id.txt_company_cto_propulsion)
    TextView mTxtCompanyCTOPropulsion;
    @BindView(R.id.txt_company_coo)
    TextView mTxtCompanyCOO;
    @BindView(R.id.txt_company_valuation)
    TextView mTxtCompanyValuation;
    @BindView(R.id.txt_company_test_sites)
    TextView mTxtCompanyTestSites;
    @BindView(R.id.txt_company_launch_sites)
    TextView mTxtCompanyLaunchSites;
    @BindView(R.id.txt_company_employees)
    TextView mTxtCompanyEmployees;
    @BindView(R.id.txt_company_vehicles)
    TextView mTxtCompanyVehicles;
    @BindView(R.id.lyt_company_no_connection)
    FrameLayout mLayoutNoConnection;
    @BindView(R.id.txt_company_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_company)
    ProgressBar mProgressBar;

    public static AboutCompanyFragment newInstance() {
        return new AboutCompanyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_company, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutCompanyViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {
        mViewModel.getCompanyData().observe(this,companyEntity -> {

            if (companyEntity != null) {
                mProgressBar.setVisibility(View.GONE);
                mLayoutNoConnection.setVisibility(View.GONE);
                mCompanyEntity = companyEntity;
                updateUI();
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mLayoutNoConnection.setVisibility(View.VISIBLE);
                mViewModel.insertCompanyData();
            }

        });
    }

    private void updateUI() {
        if(mCompanyEntity != null){
            String founderString = mCompanyEntity.getFounder() + getString(R.string.text_comma) + mCompanyEntity.getFounded();
            String companyValuation = String.format(Locale.getDefault(),getString(R.string.valuation_formart),  mCompanyEntity.getValuation()/ 1000000.0);
            String companyTestSites = mCompanyEntity.getTestSites().toString();
            String companyLaunchSites = mCompanyEntity.getLaunchSites().toString();
            String companyEmployees = mCompanyEntity.getEmployees().toString();
            String companyVehicles = mCompanyEntity.getVehicles().toString();

            mTxtCompanyFoundation.setText(founderString);
            mTxtCompanyHeadquartersAddress.setText(mCompanyEntity.getHeadquartersAddress());
            mTxtCompanySummary.setText(mCompanyEntity.getSummary());
            mTxtCompanyCEO.setText(mCompanyEntity.getCeo());
            mTxtCompanyCTO.setText(mCompanyEntity.getCto());
            mTxtCompanyCTOPropulsion.setText(mCompanyEntity.getCtoPropulsion());
            mTxtCompanyCOO.setText(mCompanyEntity.getCoo());
            mTxtCompanyValuation.setText(companyValuation);
            mTxtCompanyTestSites.setText(companyTestSites);
            mTxtCompanyLaunchSites.setText(companyLaunchSites);
            mTxtCompanyEmployees.setText(companyEmployees);
            mTxtCompanyVehicles.setText(companyVehicles);

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
        if(getActivity()!=null) {
            mDrawer = getActivity().findViewById(R.id.drawer_layout);
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    getActivity(), mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawer.addDrawerListener(toggle);
            toggle.syncState();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }

}
