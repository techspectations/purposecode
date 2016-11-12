package com.purposecodes.hackathon.api;

/**
 * Created by Vaikesh on 29-06-2016.
 */
public class ApiFailureEvent {

    public String type;
    public int position;

    public ApiFailureEvent(String type, int position) {
        this.type = type;
        this.position = position;
    }
}
