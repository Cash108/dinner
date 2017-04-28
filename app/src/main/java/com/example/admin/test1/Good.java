package com.example.admin.test1;

/**
 * Created by admin on 2017/4/29.
 */

public class Good {

    private String goodBarcode;

    private String goodName;

    private String goodProvider;

    public String getGoodBarcode() {

        return goodBarcode;

    }



    public void setGoodBarcode(String goodBarcode) {

        this.goodBarcode = goodBarcode;

    }



    public String getGoodName() {

        return goodName;

    }



    public void setGoodName(String goodName) {

        this.goodName = goodName;

    }



    public String getGoodProvider() {

        return goodProvider;

    }



    public void setGoodProvider(String goodProvider) {

        this.goodProvider = goodProvider;

    }



    public Good(String goodBarcode, String goodName, String goodProvider) {

        this.goodBarcode = goodBarcode;

        this.goodName = goodName;

        this.goodProvider = goodProvider;

    }

}