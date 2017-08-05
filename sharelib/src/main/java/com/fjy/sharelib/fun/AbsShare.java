package com.fjy.sharelib.fun;

import android.app.Activity;

import com.fjy.sharelib.ShareItem;

/**
 * Created by fujia on 2017/8/5.
 */

public abstract class AbsShare {
    protected ShareItem shareItem;

    public AbsShare(ShareItem shareItem) {
        this.shareItem = shareItem;
    }

    abstract void doShare(Activity activity);
}
