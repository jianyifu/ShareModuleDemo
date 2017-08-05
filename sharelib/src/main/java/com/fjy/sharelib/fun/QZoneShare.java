package com.fjy.sharelib.fun;

import android.app.Activity;
import android.util.Log;

import com.fjy.sharelib.ShareItem;
import com.fjy.sharelib.core.ShareUtil;

/**
 * Created by fujia on 2017/8/5.
 */

public class QZoneShare extends AbsShare {
    private static final String TAG = "QZoneShare";

    public QZoneShare(ShareItem shareItem) {
        super(shareItem);
    }

    @Override
    public void doShare(Activity activity) {
        if (shareItem != null) {
            ShareUtil.shareImageTextToQZone(activity, shareItem);
        } else {
            Log.e(TAG, "doShare: shareItem is invalid");
        }

    }
}
