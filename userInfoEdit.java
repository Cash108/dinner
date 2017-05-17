package com.example.a1.dinnerlogin.userInfo;

/**
 * Created by zhanglan on 2017/5/9.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.a1.dinnerlogin.R;
import com.example.a1.dinnerlogin.login.login;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
/**
 * Created by user on 2017/4/19.
 */

/*个人中心功能实现类*/


public class userInfoEdit extends FragmentActivity {

    public static Fragment[] mFragments;

    private ImageView mImageView;
    //拍照时的图片存储路径
    private static final String iconPath = Environment.getExternalStorageDirectory()+"/Image";//图片的存储目录

    private final static int DISPLAY_DIA = 3;

    private Button genderBtn;
    private Button nameBtn;
    private Button addressBtn;
    private Button schoolBtn;
    private Button exitBtn;

    public TextView mName;
    private TextView mGender;
    private TextView mArea;
    private TextView mSchool;
    private Button mOrder;



    Handler handler = new Handler(){
        public void handleMessage(Message msg){

            Bundle b = msg.getData();/*获得msg中的数据*/

          //  if (b.getString("flag").equals("true")){/*若flag为true则登陆成功*/
                Toast.makeText(userInfoEdit.this,"获取用户信息成功！",Toast.LENGTH_SHORT).show();
          // }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
     //  setFragmentIndicator(0);

        /*绑定布局文件中的部件*/
        mImageView = (ImageView)findViewById(R.id.diaplayUserImage);
        mName = (TextView)findViewById(R.id.user_edit_name);
        mGender = (TextView) findViewById(R.id.user_edit_gender);
        mArea = (TextView) findViewById(R.id.user_edit_address);
        mSchool = (TextView) findViewById(R.id.user_edit_school);

        nameBtn = (Button)findViewById(R.id.user_name_edit_btn);
        genderBtn = (Button)findViewById(R.id.user_gender_edit_btn);
        schoolBtn = (Button)findViewById(R.id.user_school_edit_btn);
        addressBtn = (Button)findViewById(R.id.user_address_edit_btn);
        exitBtn = (Button)findViewById(R.id.returnback);
        mOrder=(Button)findViewById(R.id.user_orders_btn);

        getInfo();//发送userid到服务端获取用户信息并显示到ui上

        //弹出框选择
        mImageView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              showDialog(DISPLAY_DIA);
                                          }
                                      }
        );
        nameBtn.setOnClickListener(mListener);  //
        genderBtn.setOnClickListener(mListener);
        addressBtn.setOnClickListener(mListener);
        schoolBtn.setOnClickListener(mListener);
        exitBtn.setOnClickListener(mListener);

        exitBtn.setOnClickListener(mListener);
        mOrder.setOnClickListener(mListener);

    }


    //弹出框选择相册或者相机
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        if(id==3){
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            AlertDialog.Builder setTitle2 = builder2.setTitle("请选择上传方式");
            builder2.setPositiveButton("相册", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("image/*");
                    startActivityForResult(intent, 0);
                }

            });
            builder2.setNegativeButton("相机", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivityForResult(intent, 1);
                }

            });
            dialog = builder2.create();

        }
        return dialog;
    }


    /*不同按钮按下的监听器的选择*/
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_user_to_name_edit = new Intent(userInfoEdit.this,userNameEdit.class);
            Intent intent_user_to_gender_edit = new Intent(userInfoEdit.this,userGenderEdit.class);
            Intent intent_user_to_address_edit = new Intent(userInfoEdit.this,userAddressEdit.class);
            Intent intent_user_to_school_edit = new Intent(userInfoEdit.this,userSchoolEdit.class);
            //Intent intent_user_to_orderlist = new Intent(userInfoEdit.this,userOrderList.class);

            switch (v.getId()){
                case R.id.user_name_edit_btn:    /*修改用户名*/
                    startActivity(intent_user_to_name_edit);
                    finish();
                    break;
                case R.id.user_gender_edit_btn:    /*修改性别按钮*/
                    startActivity(intent_user_to_gender_edit);
                    finish();
                    break;
                case R.id.user_address_edit_btn:/*修改地区页面*/
                    startActivity(intent_user_to_address_edit);
                    finish();
                    break;
                case R.id.user_school_edit_btn:/*修改学校*/
                    startActivity(intent_user_to_school_edit);
                    finish();
                    break;
                case R.id.user_orders_btn:    /*点击进入“我的订单”列表*/
                    //startActivity(intent_user_to_orderlist);
                    finish();
                    break;
                case R.id.returnback:
                    Intent intent_to_login = new Intent(userInfoEdit.this,login.class);
                    startActivity(intent_to_login);
                    finish();
                    break;
            }}    };


    public String createPhotoName(){
        //以系统的当前时间给图片命名
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = format.format(date)+".jpg";
        return fileName;
    }

    /**
     * 把拍的照片保存到SD卡
     */
    public void saveToSDCard(Bitmap bitmap) {
        //先要判断SD卡是否存在并且挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(iconPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(createPhotoName());
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);//把图片数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                if(outputStream!=null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            Toast.makeText(this,"SD卡不存在",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取选择的图片
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null){
            return;//当data为空的时候，不做任何处理
        }
        Bitmap bitmap = null;
        if(requestCode==0){
            //获取从相册界面返回的缩略图
            bitmap = data.getParcelableExtra("data");
            if(bitmap==null){//如果返回的图片不够大，就不会执行缩略图的代码，因此需要判断是否为null,如果是小图，直接显示原图即可
                try {
                    //通过URI得到输入流
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    //通过输入流得到bitmap对象
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }else if(requestCode==1){
            bitmap = (Bitmap) data.getExtras().get("data");
            saveToSDCard(bitmap);
        }
        //将选择的图片设置到控件上
        mImageView.setImageBitmap(bitmap);
    }
    /**
     * 初始化fragment
     */
/*    private void setFragmentIndicator(int whichIsDefault) {
        //实例化 Fragment 集合
        mFragments = new Fragment[5];
        mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.activity_homepage);
        mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_category);
        mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_down);
        mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_user);
        mFragments[4] = getSupportFragmentManager().findFragmentById(R.id.fragment_setting);
        //显示默认的Fragment
        getSupportFragmentManager().beginTransaction().hide(mFragments[0])
                .hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[whichIsDefault]).commit();
        //绑定自定义的菜单栏组件
        ViewIndicator mIndicator = (ViewIndicator) findViewById(R.id.indicator);
        ViewIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                //显示指定的Fragment
                getSupportFragmentManager().beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[which]).commit();
            }
        });
    }*/

    public void getInfo(){


        System.out.println("the userid i got is :"+login.u.getUserid());
        //接收到userid然后发送到客户端获取用户info
        InfoThread myThread = new InfoThread(login.u.getUserid());
        new Thread(myThread).start();
    }







    private void updateUI(final String n,final String g,final String a,final String s){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mName.setText(n);
                mGender.setText(g);
                mArea.setText(a);
                mSchool.setText(s);
            }
        });
    }



    class InfoThread implements Runnable{
        private String userid;


        public InfoThread(String userid){
            this.userid = userid;
        }
        @Override
        public void run(){
            String url=getString(R.string.server_ip) + "ShowUserInfo";
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = null;
            httpPost = new HttpPost(url);

            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("user_id",userid));

            UrlEncodedFormEntity uefEntity;

            try {
                //把数据封装到实体，发送到服务端
                uefEntity=new UrlEncodedFormEntity(formparams,"UTF-8");
                httpPost.setEntity(uefEntity);

                //获得回应
                HttpResponse response ;
                response = httpClient.execute(httpPost);/*response为服务端传来的数据*/
                if (response.getStatusLine().getStatusCode()==200){/*返回码为200则连接成功*/
                    HttpEntity entity = response.getEntity();/*获得服务端传来的实体*/
                    if (entity!=null){
                        String json = EntityUtils.toString(entity,"UTF-8");
                        JSONObject jsonData = new JSONObject(json);/*解码json数据包*/
                        Bundle b = new Bundle();/*用于类之间传递数据的对象*/

                    //    b.putString("flag",jsonData.getString("flag"));/*获取json数据包中flag的值并放入b中*/
                        if(jsonData.getString("nickname")!=null){
                            b.putString("nickname",jsonData.getString("nickname"));
                        }if (jsonData.getString("gender")!=null){
                        b.putString("gender",jsonData.getString("gender"));}
                        if (jsonData.getString("area")!=null){
                            b.putString("area",jsonData.getString("area"));
                        }if (jsonData.getString("school")!=null){
                            b.putString("school",jsonData.getString("school"));
                        }


                        updateUI(jsonData.getString("nickname"),jsonData.getString("gender"),jsonData.getString("area"),jsonData.getString("school"));

                        Message msg = new Message();
                        msg.setData(b);/*向消息中放入b对象，这样可以发送到别的类*/
                        userInfoEdit.this.handler.sendMessage(msg);/*发送消息到register类*/
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }



}
