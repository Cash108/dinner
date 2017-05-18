package com.linjichuan.www.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {/*继承activity类*/
        super.onCreate(savedInstanceState);        /*调用父类方法*/
        setContentView(R.layout.activity_login); /*加载布局文件*/
        Button btn=(Button) findViewById(R.id.LoginBtn);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent=new Intent(Login.this,main.class);
                startActivity(intent);
            }
        });



    }
}
