package com.fjy.sharelib.share;

import android.app.Activity;
import android.util.Log;

import com.fjy.sharelib.core.ShareCore;
import com.fjy.sharelib.model.AbsShare;

/**
 * Created by fujia on 2017/8/5.
 */

public class QQShare extends AbsShare {
    private static final String TAG = "QQShare";
    private boolean isQQ;

    /**
     * To decide if it need to share to QQ or Qzone
     * @param isQQ
     * @return
     */
    public QQShare isQQorQzone(boolean isQQ) {
        this.isQQ = isQQ;
        return this;
    }
    @Override
    public void doShare(Activity activity) {
        if (dataSource != null) {
            if(isQQ){
                ShareCore.shareImageTextToQQ(activity, dataSource);
            }else{
                ShareCore.shareImageTextToQZone(activity, dataSource);
            }

        } else {
            Log.e(TAG, "doShare: dataSource is invalid");
        }

    }
}
