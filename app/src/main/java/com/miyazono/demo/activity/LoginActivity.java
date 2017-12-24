package com.miyazono.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miyazono.demo.R;
import com.miyazono.demo.service.LoginService;
import com.miyazono.demo.service.RegisterService;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnlogin;
    private Button btnregister;
//    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    etUsername = (EditText) findViewById(R.id.etUsername);
    etPassword = (EditText) findViewById(R.id.etPassword);
    btnlogin = (Button)findViewById(R.id.clicklogin);
    btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String username = etUsername.getText().toString().trim();
            final String password = etPassword.getText().toString().trim();
            new Thread(){
                public void run(){
//                    final String index = IndexService.IndexByPost();
                    final String result = LoginService.LoginByPost(username,password);
                    if(result != null){
                        //ui线程更改界面
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,result,0).show();
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                    }else{
                        //请求失败，弹出toast
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"请求失败......",0).show();
                            }
                        });
                    }
                }
            }.start();
//            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(intent);
        }
    });

        btnregister = (Button)findViewById(R.id.clickregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString().trim();
                final String password = etPassword.getText().toString().trim();
//                final UserBean user = new UserBean();
//                user.setUserName(username);
//                user.setPassword(password);
//                RegisterService.RegisterByPost(user);

                new Thread(){
                    public void run(){
                        final String result = RegisterService.RegisterByPost(username,password);
                        if(result != null){
                            //ui线程更改界面
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this,result,0).show();
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }else{
                            //请求失败，弹出toast
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this,"请求失败......",0).show();
                                }
                            });
                        }
                    }
                }.start();
                //            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                //            startActivity(intent);
            }
        });


    }

//    public void clicklogin(View view){
//        final String username = etUsername.getText().toString().trim();
//        final String password = etPassword.getText().toString().trim();
//         new Thread(){
//            public void run(){
//                final String result = LoginService.loginByPost(username,password);
//                if(result != null){
//                    //ui线程更改界面
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(LoginActivity.this,result,0).show();
//                        }
//                    });
//                }else{
//                    //请求失败，弹出toast
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(LoginActivity.this,"请求失败......",0).show();
//                        }
//                    });
//                }
//            }
//        }.start();
//    }

}
