package com.fjy.sharelib.share;

import android.app.Activity;
import android.util.Log;

import com.fjy.sharelib.core.ShareCore;
import com.fjy.sharelib.model.AbsShare;

/**
 * Created by fujia on 2017/8/5.
 */

public class WechatShare extends AbsShare {
    private static final String TAG = "WechatShare";
    private byte[] thumbByte;
    private boolean isMoments;

    @Override
    public WechatShare configImageSource(byte[] thumbByte) {
        this.thumbByte = thumbByte;
        return this;
    }

    /**
     * To decide if it need share to moments or not
     * @param isMoments
     * @return
     */
    public WechatShare isShareToMoments(boolean isMoments) {
        this.isMoments = isMoments;
        return this;
    }
    @Override
    public void doShare(Activity activity) {
        if (dataSource != null) {
            if (thumbByte != null && thumbByte.length > 0) {
                if(isMoments){
                    ShareCore.shareImageTextToWCTimeline(activity, dataSource, thumbByte);
                }else{
                    ShareCore.shareImageTextToWC(activity, dataSource,thumbByte);
                }
            }else{
                Log.e(TAG, "doShare: "+"thumbByte is invalid");
            }
        }else{
            Log.e(TAG, "doShare: dataSource is invalid");
        }
    }
}
