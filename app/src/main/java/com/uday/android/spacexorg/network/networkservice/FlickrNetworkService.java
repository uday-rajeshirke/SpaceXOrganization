package com.uday.android.spacexorg.network.networkservice;

import com.uday.android.spacexorg.network.model.photos.Flickr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlickrNetworkService {

    @GET("rest/?method=flickr.people.getPublicPhotos&api_key=e64b80896647ef3a3266f732f940a94a&user_id=130608600@N05&format=json&nojsoncallback=1&page=1")
    Call<Flickr> getAllFlickrPhotos();
}
