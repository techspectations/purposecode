package com.purposecodes.hackathon.api;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class ApiClient {

    private static final String BASE_URL = "https://developer.manoramaonline.com/";
    private static ApiClient mApiClient;
    private static Retrofit mRetrofit;

    public static ApiClient getClient(){
        if(mApiClient == null){
            mApiClient = new ApiClient();
        }
        return mApiClient;
    }

    private ApiClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void search(HashMap<String, String> options, Callback<SearchModel> callback){

        ApiInterface interfaces = mRetrofit.create(ApiInterface.class);
        Call<SearchModel> call = interfaces.search(options);
        call.enqueue(callback);
    }
}
