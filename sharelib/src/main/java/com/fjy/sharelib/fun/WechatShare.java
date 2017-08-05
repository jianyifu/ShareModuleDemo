package com.fjy.sharelib.fun;

import android.app.Activity;
import android.util.Log;

import com.fjy.sharelib.ShareItem;
import com.fjy.sharelib.core.ShareUtil;

/**
 * Created by fujia on 2017/8/5.
 */

public class WechatShare extends AbsShare {
    private static final String TAG = "WechatShare";
    byte[] thumbByte;

    public WechatShare(ShareItem shareItem, byte[] thumbByte) {
        super(shareItem);
        this.thumbByte = thumbByte;
    }

    @Override
    public void doShare(Activity activity) {
        if (shareItem != null) {
            if (thumbByte != null && thumbByte.length > 0) {
                ShareUtil.shareImageTextToWC(activity,shareItem,thumbByte);
            }else{
                Log.e(TAG, "doShare: "+"thumbByte is invalid");
            }
        }else{
            Log.e(TAG, "doShare: shareItem is invalid");
        }
    }
}
