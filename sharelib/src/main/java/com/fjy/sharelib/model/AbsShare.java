package com.fjy.sharelib.model;

import android.app.Activity;
import android.graphics.Bitmap;

/**
 * Created by fujia on 2017/8/5.
 */

public abstract class AbsShare {
    protected DataSource dataSource;

    public AbsShare with(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }
    public AbsShare configImageSource(Bitmap thumbBipmap){
        return  this;
    }
    public AbsShare configImageSource(byte[] thumbByte){
        return  this;
    }

    abstract public void doShare(Activity activity);
}
