

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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by alyssaburke on 10/8/15.
 */

public class DashboardActivity extends FragmentActivity {

    private static final String TAG = "DashboardActivity: ";

    CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        Button startgameButton = (Button) findViewById(R.id.startgame_button);
        Button logoutButton = (Button) findViewById(R.id.logout_button);
        setContentView(R.layout.activity_dashboard);
        Log.d(TAG, "Content View is set");

    }

    //logout when click logout button
    public void customLogOut (View view)
    {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void startGame (View view)
    {
        Log.d(TAG, "sartGame is hit");
        Intent intent = new Intent(DashboardActivity.this, GameActivity.class);
        startActivity(intent);
    }

}
