package com.fingerspellingtutor.fingerspellingtutor;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


//import butterknife.Bind;
//import butterknife.ButterKnife;

/**
 * Created by aburke on 11/10/15.
 */
public class LoginActivity extends FragmentActivity {

    private static final String TAG = "LoginActivity: ";

    CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "OnCreate hit");

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        Log.d(TAG, "super.OnCreate is hit");

        setContentView(R.layout.activity_login_fb);
        Log.d(TAG, "setContentView for login is hit");

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        Log.d(TAG, "loginButton is declared");

        callbackManager = CallbackManager.Factory.create();

        Log.d(TAG, "callbackManager is decalred");

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code

            }

            @Override
            public void onError(FacebookException error) {
                // App code

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "OnActivityResults is hit");

        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);

    }

}