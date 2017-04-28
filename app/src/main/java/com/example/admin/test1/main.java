package com.example.admin.test1;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bj on 2017/4/11.
 */

public class main extends Activity {
    private ListView goodsinfoListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btn5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btn6 = (ImageButton) findViewById(R.id.imageButton6);

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
              skip();
            }
        });
        // 获得ListView句柄

        goodsinfoListView = (ListView)findViewById(R.id.goodsinfoListView);

        final listViewAdapter mgs = new listViewAdapter(getListData(),R.layout.item_item,this);

        goodsinfoListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,

                                    long arg3) {

//int position =Integer.parseInt(arg1.getTag().toString());

                mgs.getView(arg2, arg1, goodsinfoListView);

            }

        });

        goodsinfoListView.setAdapter(mgs);

    }

/*
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
        */
    /**
     75      * 用于回调的抽象类
     76      * @author Ivan Xu
     77      * 2014-11-26
     78      */



       /*ListView数据*/

    private List<Good> getListData() {

        List<Good> list = new ArrayList<Good>();



        Good good = new Good("1111111","果冻","XXX区域代理商");

        list.add(good);



        Good good1 = new Good("2222222","营养快线","XXX区域代理商");

        list.add(good1);


        Good good2 = new Good("333333","豆干","XXX区域代理商");

        list.add(good2);

        return list;

    }

    public class listViewAdapter extends BaseAdapter {

        private List<Good> goods;//ListView显示的数据

        private int resource;//显示列表项的Layout

        private LayoutInflater inflater;//界面生成器

        private Context context;


        public  listViewAdapter(List<Good> goods,int resource,Context context){

            this.goods = goods;

            this.resource = resource;

            this.context = context;

            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override

        public int getCount() {

            return goods.size();

        }

        @Override

        public Object getItem(int arg0) {

            return goods.get(arg0);

        }


        @Override

        public long getItemId(int arg0) {

            return arg0;

        }



        @Override

        public View getView(int arg0, View arg1, ViewGroup arg2) {

            if(arg1 == null){

                arg1 = inflater.inflate(resource, null);

            }

            final Good good = goods.get(arg0);

            TextView goodBarcode =(TextView) arg1.findViewById(R.id.goodBarcode);

//设置ListView中的Item中的TextView

            goodBarcode.setText(good.getGoodBarcode());

//为TextView设置监听器

            goodBarcode.setOnClickListener(new View.OnClickListener(){


                @Override

                public void onClick(View arg0) {

                   skip();
                }

            });

            TextView goodName =(TextView) arg1.findViewById(R.id.goodName);



            goodName.setOnClickListener(new View.OnClickListener(){


                @Override

                public void onClick(View arg0) {

                    skip();

                }

            });

            TextView goodProvider =(TextView) arg1.findViewById(R.id.goodProvider);



            goodProvider.setOnClickListener(new View.OnClickListener(){


                @Override

                public void onClick(View arg0) {

                    skip();

                }

            });

            return arg1;

        }



    }

    public void skip(){
        Intent intent=new Intent(main.this, info.class);
        startActivity(intent);
    }

}
