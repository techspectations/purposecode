package com.purposecodes.hackathon.affective;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.CameraDetector;
import com.affectiva.android.affdex.sdk.detector.Detector;
import com.affectiva.android.affdex.sdk.detector.Face;

import java.util.List;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class AffectiveActivity extends AppCompatActivity implements Detector.FaceListener, Detector.ImageListener, CameraDetector.CameraEventListener,
        View.OnTouchListener, ActivityCompat.OnRequestPermissionsResultCallback, DrawingView.DrawingThreadEventListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onCameraSizeSelected(int i, int i1, Frame.ROTATE rotate) {

    }

    @Override
    public void onFaceDetectionStarted() {

    }

    @Override
    public void onFaceDetectionStopped() {

    }

    @Override
    public void onImageResults(List<Face> list, Frame frame, float v) {

    }

    @Override
    public void onBitmapGenerated(Bitmap bitmap) {

    }
}
