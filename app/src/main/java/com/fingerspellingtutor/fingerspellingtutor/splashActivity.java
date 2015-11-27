package com.fingerspellingtutor.fingerspellingtutor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import android.os.Handler;




/**
 * Created by alyssaburke on 10/8/15.
 */

public class SplashActivity extends FragmentActivity {

    private static final String TAG = "SplashActivity: ";

    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    AccessToken accessToken;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        Log.d(TAG, "test log is working");

        setContentView(R.layout.activity_splash);

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

                Log.d(TAG, "Token is changed is hit");

            }
        };

        //Creates a "wait" so that the use sees the "loading screen" since it checks if a user is logged in or not very quickly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                accessToken = AccessToken.getCurrentAccessToken();
                isUserLoggedIn();
                Log.d(TAG, "isUserLoggedIn() is called");
                finish();
            }
        }, 1500);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
        Log.d(TAG, "onDestroy() is called");
    }

    private void isUserLoggedIn() {

        Log.d(TAG, "in isUserLoggedIn()");

        if (accessToken != null) {

            Log.d(TAG, "accessToken is NOT null");

            Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
            startActivity(intent);


        } else {

            Log.d(TAG, "accessToken is null");

            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);

            Log.d(TAG, "change activity to Login");
    }
    }

    }

