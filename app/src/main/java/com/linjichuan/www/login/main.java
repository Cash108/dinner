package com.linjichuan.www.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by 1 on 2017/4/11.
 */

public class main extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn2=(ImageButton) findViewById(R.id.imageButton2);
        ImageButton btn3=(ImageButton) findViewById(R.id.imageButton3);
        ImageButton btn4=(ImageButton) findViewById(R.id.imageButton4);
        ImageButton btn5=(ImageButton) findViewById(R.id.imageButton5);
        ImageButton btn6=(ImageButton) findViewById(R.id.imageButton6);


        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent3=new Intent(main.this,main.class);
                startActivity(intent3);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent3=new Intent(main.this,news.class);
                startActivity(intent3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent4=new Intent(main.this,releasedate.class);
                startActivity(intent4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent5=new Intent(main.this,searchinput.class);
                startActivity(intent5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent6=new Intent(main.this,personinformation.class);
                startActivity(intent6);
            }
        });

    }
}
