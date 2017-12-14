package com.foodproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.foodproject.R;
import com.foodproject.accessibility.TypeFaceUtil;


public class StartupActivity extends AppCompatActivity {
    Button loginActivity, registrationActivity;
    LinearLayout skipFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypeFaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Regular.ttf");

        loginActivity = (Button) findViewById(R.id.button_login);
        registrationActivity = (Button) findViewById(R.id.button_sign_up);
        skipFooter = (LinearLayout) findViewById(R.id.skipFooter);
        skipFooter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                StartupActivity.this.finish();
                Intent intent=new Intent(StartupActivity.this,ChooseLocality.class);
                startActivity(intent);

            }
        });

        loginActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent loginActivity = new Intent(StartupActivity.this, LoginActivity.class);
//                loginActivity.putExtra("which_activity", "StartupActivity");
//                startActivity(loginActivity);
//                overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
            }
        });

        registrationActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent registrationIntent = new Intent(StartupActivity.this, RegistrationActivity.class);
//                startActivity(registrationIntent);
//                overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
            }
        });
    }

}

