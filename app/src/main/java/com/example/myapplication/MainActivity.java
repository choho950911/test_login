package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.linecorp.linesdk.LoginDelegate;
import com.linecorp.linesdk.LoginListener;
import com.linecorp.linesdk.Scope;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.linecorp.linesdk.widget.LoginButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ct = getApplicationContext();
        testLine();
    }

    private LoginDelegate loginDelegate = LoginDelegate.Factory.create();
    Context ct;
    private void testLine(){
        LoginButton loginButton = findViewById(R.id.line_login_btn);

// if the button is inside a Fragment, this function should be called.
    //    loginButton.setFragment(ct);

        loginButton.setChannelId("1654296545");

// configure whether login process should be done by Line App, or inside WebView.
        loginButton.enableLineAppAuthentication(true);

// set up required scopes and nonce.
        loginButton.setAuthenticationParams(new LineAuthenticationParams.Builder()
                .scopes(Arrays.asList(Scope.PROFILE))
                // .nonce("<a randomly-generated string>") // nonce can be used to improve security
                .build()
        );
        loginButton.setLoginDelegate(loginDelegate);
        loginButton.addLoginListener(new LoginListener() {
            @Override
            public void onLoginSuccess(@NonNull LineLoginResult result) {

            }

            @Override
            public void onLoginFailure(@Nullable LineLoginResult result) {

            }
        });
    }
}
