package com.uday.android.spacexorg.network.networkapicall;

import com.uday.android.spacexorg.network.networkservice.SpaceXNetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkApiCall {

    private static final String SPACEX_BASE_URL="https://api.spacexdata.com/v3/";

    private static Retrofit retrofit;
    private static SpaceXNetworkService spaceXNetworkService;

    public static SpaceXNetworkService getSpaceXInstance(){

        if (spaceXNetworkService != null){
            return spaceXNetworkService;
        }

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(SPACEX_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }

        return spaceXNetworkService = retrofit.create(SpaceXNetworkService.class);
    }

}
