package com.purposecodes.hackathon.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public interface ApiInterface {

    /*@Headers({
            "Authorization: bcb2470a-325b-503a-9832-7365b1f25386",
    })*/
    @GET("api/editions/en/search")
    @Headers("Authorization: bcb2470a-325b-503a-9832-7365b1f25386")
    Call<SearchModel> search(@QueryMap HashMap<String, String> options);
}
