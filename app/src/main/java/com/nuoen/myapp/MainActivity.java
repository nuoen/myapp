package com.nuoen.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nuoen.myapp.activity.LoginActivity;
import com.nuoen.myapp.activity.RegisterActivity;


public class MainActivity extends AppCompatActivity {
    private Button login_btn;
    private Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn=findViewById(R.id.btn_login);
        register_btn=findViewById(R.id.btn_register);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });

    }
}
