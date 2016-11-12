package com.purposecodes.hackathon.api;

import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vaikesh on 29-06-2016.
 */
public class ApiCallBack<T> implements Callback<T> {

    private Bus bus;
    private String type;
    private int position;

    private static final int TOTAL_RETRIES = 3;
    private Call<T> call;
    private int retryCount = 0;

    public ApiCallBack(Bus bus, String type, int position) {
        this.bus = bus;
        this.type = type;
        this.position = position;
    }

    public void setRequestCall(Call<T> call) {
        this.call = call;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response){
        bus.post(new ApiSuccessEvent<>(response, type,position));
    }

    @Override
    public void onFailure(Call<T> call,Throwable t){
        if(t!=null){
            t.printStackTrace();
        }

        /*if (call != null && retryCount++ < TOTAL_RETRIES) {
            Log.e("Retrofit", "Retrying... (" + retryCount + " out of " + TOTAL_RETRIES + ")");
            retry();
        }
        else {
            bus.post(new ApiFailureEvent(type, position));
        }*/
    }

    /*private void retry() {
        try {
            call.clone().enqueue(this);
        }
        catch (Exception e) {
            bus.post(new ApiFailureEvent(type, position));
        }
    }*/
}
