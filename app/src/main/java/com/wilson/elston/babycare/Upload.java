package com.wilson.elston.babycare;

public class Upload {
    private String mImageUrl;
    public Upload()
    {

    }

    public Upload(String imageurl)
    {
        mImageUrl=imageurl;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
    public void setmImageUrl(String imageurl)
    {
        mImageUrl=imageurl;
    }
}
