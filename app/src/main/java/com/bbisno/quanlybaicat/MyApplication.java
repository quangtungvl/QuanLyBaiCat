package com.bbisno.quanlybaicat;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by MyPC on 27/02/2016.
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        // other setup code
    }
}
