package com.fjy.sharelib.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.fjy.sharelib.core.ShareCore;
import com.fjy.sharelib.model.AbsShare;

/**
 * Created by fujia on 2017/8/5.
 */

public class WeiboShare extends AbsShare {
    private static final String TAG = "WeiboShare";
    Bitmap thumbBipmap;

    @Override
    public AbsShare configImageSource(Bitmap thumbBipmap) {
        this.thumbBipmap = thumbBipmap;
        return this;
    }

    @Override
    public void doShare(Activity activity) {
        if (dataSource != null) {
            if (thumbBipmap != null) {
                ShareCore.shareWebTextToWeibo(activity, dataSource, thumbBipmap);
            } else {
                Log.e(TAG, "doShare: thumbBitmap is invalid");
            }
        } else {
            Log.e(TAG, "doShare: dataSource is invalid");
        }

    }
}
