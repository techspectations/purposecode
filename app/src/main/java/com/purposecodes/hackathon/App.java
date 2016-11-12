package com.purposecodes.hackathon;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.purposecodes.hackathon.api.ApiCallBack;
import com.purposecodes.hackathon.api.ApiClient;
import com.purposecodes.hackathon.api.BusProvider;
import com.purposecodes.hackathon.api.SearchModel;
import com.squareup.otto.Bus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class App extends Application {

    private static App INSTANCE;

    // A handler to ApiClient class
    private ApiClient mApiClient;

    // A handler to Bus provider
    private Bus mBus;

    @Nullable
    private ClarifaiClient client;

    @NonNull
    public static App get() {
        final App instance = INSTANCE;
        if (instance == null) {
            throw new IllegalStateException("App has not been created yet!");
        }
        return instance;
    }

    @Override
    public void onCreate() {
        INSTANCE = this;

        mApiClient = ApiClient.getClient();
        mBus = BusProvider.getInstance();

        client = new ClarifaiBuilder(getString(R.string.clarifai_id), getString(R.string.clarifai_secret))
                // Optionally customize HTTP client via a custom OkHttp instance
                .client(new OkHttpClient.Builder()
                        .readTimeout(30, TimeUnit.SECONDS) // Increase timeout for poor mobile networks

                        // Log all incoming and outgoing data
                        // NOTE: You will not want to use the BODY log-level in production, as it will leak your API request details
                        // to the (publicly-viewable) Android log
                        .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                            @Override public void log(String logString) {
                                Timber.e(logString);
                            }
                        }).setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
                )
                .buildSync(); // use build() instead to get a Future<ClarifaiClient>, if you don't want to block this thread
        super.onCreate();

        // Initialize our logging
        Timber.plant(new Timber.DebugTree());
    }

    @NonNull
    public ClarifaiClient clarifaiClient() {
        final ClarifaiClient client = this.client;
        if (client == null) {
            throw new IllegalStateException("Cannot use Clarifai client before initialized");
        }
        return client;
    }

    public void getSearchArticles(HashMap<String, String> options) {

        ApiCallBack<SearchModel> callBack = new ApiCallBack<>(mBus, "searchResult", 0);
        mApiClient.search(options, callBack);
    }
}
