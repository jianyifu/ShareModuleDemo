package com.fjy.sharelib.fun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.fjy.sharelib.ShareItem;
import com.fjy.sharelib.core.ShareUtil;

/**
 * Created by fujia on 2017/8/5.
 */

public class WeiboShare extends AbsShare {
    private static final String TAG = "WeiboShare";
    Bitmap thumbBipmap;

    public WeiboShare(ShareItem shareItem, Bitmap thumbBipmap) {
        super(shareItem);
        this.thumbBipmap = thumbBipmap;
    }

    @Override
    public void doShare(Activity activity) {
        if (shareItem != null) {
            if (thumbBipmap != null) {
                ShareUtil.shareWebTextToWeibo(activity, shareItem, thumbBipmap);
            } else {
                Log.e(TAG, "doShare: thumbBitmap is invalid");
            }
        } else {
            Log.e(TAG, "doShare: shareItem is invalid");
        }

    }
}
