package com.purposecodes.hackathon.api;

import retrofit2.Response;

/**
 * Created by Vaikesh on 29-06-2016.
 */
public class ApiSuccessEvent<T> {

    public Response<T> response;
    public String type;
    public int position;

    public ApiSuccessEvent(Response<T> response, String type, int position) {
        this.response = response;
        this.type = type;
        this.position = position;
    }
}
