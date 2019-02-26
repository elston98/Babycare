package com.wilson.elston.babycare;

import android.net.Uri;

public class Product_details {
    private String Product_Name;
    private String Image_url;
    private String App_Url;
    private String Product_Price;


    public Product_details(String product_name,String image_url,String app_Url,String product_Price){
        Product_Name=product_name;
        Image_url=image_url;
        App_Url=app_Url;
        Product_Price=product_Price;



    }
    public Product_details()
    {

    }



    public String getProduct_Price() {
        return Product_Price;
    }



    public void setProduct_Price(String product_Price) {
        Product_Price = product_Price;
    }

    public String getApp_Url() {
        return App_Url;
    }

    public void setApp_Url(String app_Url) {
        App_Url = app_Url;
    }

    public void setImage_url(String image_url) {
        Image_url = image_url;
    }

    public String getImage_url() {
        return Image_url;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }
}
