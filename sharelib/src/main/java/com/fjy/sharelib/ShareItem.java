package com.fjy.sharelib;

import java.io.Serializable;

/**
 * Created by fujia on 2017/8/5.
 */

public interface  ShareItem extends Serializable {
    String getTitle();
    String getSubTitle();
    String getImgUrl();
    String getShareUrl();
}
