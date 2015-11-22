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

//import butterknife.Bind;
//import butterknife.ButterKnife;



/**
 * Created by alyssaburke on 10/8/15.
 */

public class TestActivity extends FragmentActivity {

    private static final String TAG = "TestActivity: ";

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

        accessToken = AccessToken.getCurrentAccessToken();
        isUserLoggedIn();
        Log.d(TAG, "isUserLoggedIn() is called");
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

            setContentView(R.layout.activity_dashboard);


        } else {

            Log.d(TAG, "accessToken is null");

            LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
            setContentView(R.layout.activity_login_fb);

            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            // App code
                        }

                        @Override
                        public void onCancel() {
                            // App code
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                        }

                    });


            Log.d(TAG, "change activity to Login");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        Button startgameButton = (Button) findViewById(R.id.startgame_button);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        setContentView(R.layout.activity_dashboard);
    }


}

