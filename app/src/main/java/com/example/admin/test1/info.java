package com.example.admin.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class info extends Activity {

    String OrderTime = "2017.4.10";
    String OrderRestanurant = "家园餐厅";
    String OrderStyle = "川菜";
    String OrderCity = "北京";
    String OrderArea = "海淀区";
    String OrderAddress = "上园村3号";
    String MaxNumber = "18";
    String OrderTelephone = "18811113542";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        TextView textView = (TextView) findViewById(R.id.text1);
        textView.setText("  时间：" + OrderTime);

        TextView textView1 = (TextView) findViewById(R.id.text2);
        textView1.setText("  餐厅：" + OrderRestanurant);

        TextView textView2 = (TextView) findViewById(R.id.text3);
        textView2.setText("  菜系：" + OrderStyle);

        TextView textView3 = (TextView) findViewById(R.id.text4);
        textView3.setText("  城市：" + OrderCity);

        TextView textView4 = (TextView) findViewById(R.id.text5);
        textView4.setText("  地区：" + OrderArea);

        TextView textView5 = (TextView) findViewById(R.id.text6);
        textView5.setText("  地址：" + OrderAddress);

        TextView textView6 = (TextView) findViewById(R.id.text7);
        textView6.setText("  人数上限：" + MaxNumber);

        TextView textView7 = (TextView) findViewById(R.id.text8);
        textView7.setText("  发起人电话：" + OrderTelephone);

        Button btn=(Button) findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent=new Intent(info.this,main.class);
                startActivity(intent);
            }
        });

    }
}
