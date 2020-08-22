package com.nuoen.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.nuoen.myapp.R;

import com.nuoen.myapp.util.StringUtils;

public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount=findViewById(R.id.et_account);
        etPwd=findViewById(R.id.et_pwd);
        btnLogin=findViewById(R.id.big_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=etAccount.getText().toString().trim();
                String pwd=etPwd.getText().toString().trim();
                login(account,pwd);
            }
        });

    }
    private void login(String account,String pwd){
        if(StringUtils.isEmpty(account)){
            //Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(pwd)){
           //Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            showToast("请输入密码");
            return;
        }

    }
}
