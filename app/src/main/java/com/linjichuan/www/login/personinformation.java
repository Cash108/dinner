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

public class personinformation extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_personinformation);

        Button btn7=(Button) findViewById(R.id.btnperson);

        btn7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent3=new Intent(personinformation.this,modify.class);
                startActivity(intent3);
            }
        });






    }
}
