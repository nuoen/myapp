package com.nuoen.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.nuoen.myapp.R;

import com.nuoen.myapp.util.StringUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.nuoen.myapp.util.AppConfig.BASE_URL;

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
        //第一步创建OkHttpClient
        OkHttpClient client =new OkHttpClient.Builder().build();
        Map m=new HashMap();
        m.put("mobile","demoData");
        m.put("password","demoData");
        JSONObject jsonObject=new JSONObject(m);
        String jsonStr=jsonObject.toString();
        RequestBody requestBodyJson=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonStr);
        //创建Request
        Request request= new Request.Builder()
                .url(BASE_URL+"/myapp/Login")
                .addHeader("contentType","application/json;charset=UTF-8")
                .post(requestBodyJson)
                .build();
        //第四步创建call回调对象
        final Call call=client.newCall(request);
        //第五步发出请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(result);
                    }
                });

            }
        });
    }
}
