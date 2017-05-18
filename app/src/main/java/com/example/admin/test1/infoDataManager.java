package com.example.admin.test1;

/**
 * Created by user on 2017/4/13.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class infoDataManager {             //用户数据管理类
    //一些宏定义和声明
    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";


    private static final String TABLE_NAME1 = "users";
    public static final String ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";


    private static final String TABLE_NAME2 = "OrderInfo";
    public static final String OrderId = "OrderId";
    public static final String UserId = "UserId";
    public static final String OrderTime = "OrderTime";
    public static final String EatingTime = "EatingTime";
    public static final String OrderRestanurant = "OrderRestanurant";
    public static final String Minnumber = "Minnumber";
    public static final String Maxnumber = "Maxnumber";
    public static final String OrderAddress = "OrderAddress";
    public static final String OrderStyle = "OrderStyle";
    public static final String OrderCity = "OrderCity";
    public static final String OrderTelephone = "OrderTelephone";
    public static final String OrderNumber = "OrderNumber";
    public static final String OrderStituation = "OrderStituation";


    //    public static final String SILENT = "silent";
//    public static final String VIBRATE = "vibrate";
    private static final int DB_VERSION = 2;
    private Context mContext = null;

    //创建用户book表
    private static final String DB_CREATE1 = "CREATE TABLE " + TABLE_NAME1 + " ("
            + ID + " integer primary key," + USER_NAME + " varchar,"
            + USER_PWD + " varchar" + ");";
    //创建饭约信息表
    private static final String DB_CREATE2 = "CREATE TABLE " + TABLE_NAME2 + " ("
            + OrderId + " integer primary key," + UserId + " integer,"
            + OrderTime + " datetime"+ EatingTime + " datetime"+ OrderRestanurant + " varchar"
            + Minnumber + " integer"+ Maxnumber + " integer"+ OrderCity + " varchar"
            + OrderAddress + " varchar"+ OrderStyle + " varchar"+ OrderTelephone + " integer"
            + OrderNumber + " integer"+ OrderStituation + " integer"+ ");";

    private SQLiteDatabase mSQLiteDatabase = null;
    private DataBaseManagementHelper mDatabaseHelper = null;

    //DataBaseManagementHelper继承自SQLiteOpenHelper
    private static class DataBaseManagementHelper extends SQLiteOpenHelper {

        DataBaseManagementHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(TAG,"db.getVersion()="+db.getVersion());
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1 + ";");
            db.execSQL(DB_CREATE1);
            Log.i(TAG, "db.execSQL(DB_CREATE)");
            Log.e(TAG, DB_CREATE1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(TAG, "DataBaseManagementHelper onUpgrade");
            onCreate(db);
        }
    }

    public infoDataManager(Context context) {
        mContext = context;
        Log.i(TAG, "UserDataManager construction!");
    }
    //打开数据库
    public void openDataBase() throws SQLException {
        mDatabaseHelper = new DataBaseManagementHelper(mContext);
        mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }
    //关闭数据库
    public void closeDataBase() throws SQLException {
        mDatabaseHelper.close();
    }
    //添加新的饭约信息，即发布饭约

    public void insertUserData(infoData infoData) {
        int order_id=infoData.getOrderId();
        int user_id=infoData.getUserId();
        String order_time=infoData.getOrderTime();
        String eating_time=infoData.getEatingTime();
        String order_restanurant=infoData.getOrderRestanurant();
        int min_number=infoData.getMinNumber();
        int max_number=infoData.getMaxNumber();
        String order_address=infoData.getOrderAddress();
        String order_style=infoData.getOrderStyle();
        String order_city=infoData.getOrderCity();
        int order_telephone=infoData.getOrderTelephone();
        int order_Number=infoData.getOrderNumber();
        int order_situation=infoData.getOrderStituation();

        ContentValues values = new ContentValues();
        values.put(OrderId, order_id);
        values.put(UserId, user_id);
        values.put(OrderTime, order_time);
        values.put(EatingTime, eating_time);
        values.put(OrderRestanurant, order_restanurant);
        values.put(Minnumber, min_number);
        values.put(Maxnumber, max_number);
        values.put(OrderAddress, order_address);
        values.put(OrderStyle, order_style);
        values.put(OrderCity, order_city);
        values.put(OrderTelephone, order_telephone);
        values.put(OrderNumber, order_Number);
        values.put(OrderStituation, order_situation);

    }
    //添加新用户，即注册
   /*
    public long insertUserData(UserData userData) {
        String userName=userData.getUserName();
        String userPwd=userData.getUserPwd();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        return mSQLiteDatabase.insert(TABLE_NAME1, ID, values);
    }
    //更新用户信息，如修改密码
    public boolean updateUserData(UserData userData) {
//int id = userData.getUserId();
        String userName = userData.getUserName();
        String userPwd = userData.getUserPwd();
        ContentValues values = new ContentValues();
//values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        String where = USER_NAME + "=" + "=\"" + userName + "\"";
        return mSQLiteDatabase.update(TABLE_NAME1, values, where, null) > 0;
//return mSQLiteDatabase.update(TABLE_NAME, values, ID + "=" + id, null) > 0;
    }
*/
    //
    public Cursor fetchUserData(int id) throws SQLException {
        Cursor mCursor = mSQLiteDatabase.query(false, TABLE_NAME1, null, ID
                + "=" + id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    //
    public Cursor fetchAllUserDatas() {
        return mSQLiteDatabase.query(TABLE_NAME1, null, null, null, null, null,
                null);
    }
    //根据id删除用户
    public boolean deleteUserData(int id) {
        return mSQLiteDatabase.delete(TABLE_NAME1, ID + "=" + id, null) > 0;
    }
    //根据用户名注销
    public boolean deleteUserDatabyname(String name) {
        return mSQLiteDatabase.delete(TABLE_NAME1, USER_NAME + "=" + name, null) > 0;
    }
    //删除所有用户
    public boolean deleteAllUserDatas() {
        return mSQLiteDatabase.delete(TABLE_NAME1, null, null) > 0;
    }

    //
    public String getStringByColumnName(String columnName, int id) {
        Cursor mCursor = fetchUserData(id);
        int columnIndex = mCursor.getColumnIndex(columnName);
        String columnValue = mCursor.getString(columnIndex);
        mCursor.close();
        return columnValue;
    }
    //
    public boolean updateUserDataById(String columnName, int id,
                                      String columnValue) {
        ContentValues values = new ContentValues();
        values.put(columnName, columnValue);
        return mSQLiteDatabase.update(TABLE_NAME1, values, ID + "=" + id, null) > 0;
    }
    //根据用户名找用户，可以判断注册时用户名是否已经存在
    public int findUserByName(String userName){
        Log.i(TAG,"findUserByName , userName="+userName);
        int result=0;
        Cursor mCursor=mSQLiteDatabase.query(TABLE_NAME1, null, USER_NAME+"="+userName, null, null, null, null);
        if(mCursor!=null){
            result=mCursor.getCount();
            mCursor.close();
            Log.i(TAG,"findUserByName , result="+result);
        }
        return result;
    }
    //根据用户名和密码找用户，用于登录
    public int findUserByNameAndPwd(String userName,String pwd){
        Log.i(TAG,"findUserByNameAndPwd");
        int result=0;
        Cursor mCursor=mSQLiteDatabase.query(TABLE_NAME1, null, USER_NAME+"="+userName+" and "+USER_PWD+"="+pwd,
                null, null, null, null);
        if(mCursor!=null){
            result=mCursor.getCount();
            mCursor.close();
            Log.i(TAG,"findUserByNameAndPwd , result="+result);
        }
        return result;
    }
}
