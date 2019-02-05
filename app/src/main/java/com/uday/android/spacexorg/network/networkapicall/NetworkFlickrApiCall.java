package com.uday.android.spacexorg.network.networkapicall;

import com.uday.android.spacexorg.network.networkservice.FlickrNetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkFlickrApiCall {

    private static final String FLICKR_BASE_URL = "https://api.flickr.com/services/";

    private static Retrofit retrofit;
    private static FlickrNetworkService flickrNetworkService;

    public static FlickrNetworkService getFlickrInstance() {

        if (flickrNetworkService != null){
            return flickrNetworkService;
        }

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(FLICKR_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }

        return flickrNetworkService = retrofit.create(FlickrNetworkService.class);
    }

}
