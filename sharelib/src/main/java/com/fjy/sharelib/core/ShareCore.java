package com.fjy.sharelib.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.fjy.sharelib.model.DataSource;
import com.fjy.sharelib.ui.DialogActivity;

/**
 * Created by fujia on 2017/8/5.
 */

public class ShareCore {
    private static final String TAG = "ShareCore";
    public static final String KEY_SHARE_BUNDLE = "key_share_bundle";
    public static final String KEY_SHARE_URL_QQ = "key_share_url_qq";
    public static final String KEY_SHARE_URL_QZONE = "key_share_url_qzone";
    public static final String KEY_SHARE_URL_WECHAT = "key_share_url_wechat";
    public static final String KEY_SHARE_URL_WEIBO = "key_share_url_weibo";

    public static void showShareDialog(Context context, DataSource item) {
        if (context != null && item != null) {
            Intent intent = new Intent(context, DialogActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_SHARE_BUNDLE,item);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    /**
     * share to QQ or Qzone
     * @param activity
     * @param dataSource
     * @param shareType
     */
//    private static void shareQorZ(Activity activity, DataSource dataSource, IShareManager.ShareType shareType) {
////        ShareData shareData = gameInfo.getShareData();
//        ShareManagerFactory factory = ShareManagerFactory.getInstance(activity);
//        AppidObject appidObject = new AppidObject();
//        appidObject.appid = Constants.QQ_CLIENT_ID;
//        final IShareManager shareManager = factory.createShareManager(appidObject, ShareManagerFactory.ProviderType.QQ);
//        boolean installed = shareManager.isInstalled();
//        if(!installed){
//            Toast.makeText(GameBoxApp.getApp(),GameBoxApp.getApp().getString(R.string.qq_not_installed),Toast.LENGTH_SHORT).show();
//            return;
//        }
//        QQShareObject qqShareObject = new QQShareObject();
//        qqShareObject.activity = activity;
//        qqShareObject.shareType = shareType;
//        qqShareObject.title = bundle.getString(KEY_SHARE_TITLE);
//        qqShareObject.summary = bundle.getString(KEY_SHARE_SUBTITLE);
//        String shareUrl =  bundle.getString(KEY_SHARE_URL);
//        if(IShareManager.ShareType.SHARE_TO_QQ_TYPE_IMAGE_TEXT == shareType){
//            String qq_url = bundle.getString(KEY_SHARE_URL_QQ);
//            if(!TextUtils.isEmpty(qq_url)){
//                shareUrl = qq_url;
//            }
//        }else if(IShareManager.ShareType.SHARE_TO_QZONE_TYPE_IMAGE_TEXT == shareType){
//            String qzone_url = bundle.getString(KEY_SHARE_URL_QZONE);
//            if(!TextUtils.isEmpty(qzone_url)){
//                shareUrl = qzone_url;
//            }
//        }
//        qqShareObject.targetUrl =shareUrl;
//        qqShareObject.imageUrl = bundle.getString(KEY_SHARE_IMG);
//        shareManager.share(qqShareObject, new IResponseUIListener() {
//            @Override
//            public void onSuccess(JSONObject jsonObject) {
//
//                shareManager.destroy();
//            }
//
//            @Override
//            public void onFail(int i, String s) {
//                shareManager.destroy();
//
//            }
//        });
//    }

    /**
     * 图文分享到qq好友
     *
     * @param activity
     */
    public static void shareImageTextToQQ(Activity activity, DataSource item) {
        //TODO revoke
//        shareQorZ(activity, item, IShareManager.ShareType.SHARE_TO_QQ_TYPE_IMAGE_TEXT);
    }

    /**
     * 图文分享到qq空间
     *
     * @param activity
     */
    public static void shareImageTextToQZone(Activity activity, DataSource item) {
//        shareQorZ(activity, item, IShareManager.ShareType.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
    }

    private static void shareWorT(Activity activity, DataSource item, byte[] thumbByte, boolean weatherTimeline) {
//        ShareManagerFactory factory = ShareManagerFactory.getInstance(activity);
//        AppidObject appidObject = new AppidObject();
//        appidObject.appid = Constants.WEIXIN_CLIENT_ID;
//        final IShareManager shareManager = factory.createShareManager(appidObject, ShareManagerFactory.ProviderType.WECHAT);
//        boolean installed = shareManager.isInstalled();
//        if(!installed){
//            Toast.makeText(activity.getApplicationContext(),activity.getApplication().getString(R.string.wechat_not_installed),Toast.LENGTH_SHORT).show();
//            return;
//        }
//        WeChatShareObject wcShareObject = new WeChatShareObject();
//        wcShareObject.shareType = IShareManager.ShareType.SHARE_TO_WECHAT_TYPE_WEBPAGE;
//        wcShareObject.title = bundle.getString(KEY_SHARE_TITLE);
//        wcShareObject.scene = weatherTimeline;
//        wcShareObject.description =  bundle.getString(KEY_SHARE_SUBTITLE);
//        String shareUrl = bundle.getString(KEY_SHARE_URL);
//        String wechat_url = bundle.getString(KEY_SHARE_URL_WECHAT);
//        if(!TextUtils.isEmpty(wechat_url)){
//            shareUrl = wechat_url;
//        }
//        wcShareObject.webpageUrl = shareUrl;
//        wcShareObject.thumbByte = thumbByte;
//        CLog.e("thumb len:" + thumbByte.length);
//        shareManager.share(wcShareObject, new IResponseUIListener() {
//            @Override
//            public void onSuccess(JSONObject jsonObject) {
//
//                shareManager.destroy();
//            }
//
//            @Override
//            public void onFail(int i, String s) {
//                shareManager.destroy();
//
//            }
//        });
    }

    /**
     * 图文分享到微信好友
     *
     * @param activity
     */
    public static void shareImageTextToWC(Activity activity, DataSource item, byte[] thumbByte) {
        shareWorT(activity, item, thumbByte, false);
    }

    /**
     * 图文分享到微信朋友圈
     *
     * @param activity
     */
    public static void shareImageTextToWCTimeline(Activity activity, DataSource item, byte[] thumbByte) {
        shareWorT(activity, item, thumbByte, true);
    }

    public static void shareWebTextToWeibo(Activity activity, DataSource item, Bitmap thumbBitmap) {
//        AppidObject object = new AppidObject();
//        object.appid = Constants.WEIBO_CLIENT_ID;
//        object.redirectUrl = PassportConstant.REDIRECT_URL_FOR_WEIBO;
//        object.scope = PassportConstant.SCOPE_FOR_WEIBO;
//        final IShareManager shareManager = ShareManagerFactory.getInstance(activity).createShareManager(object, ShareManagerFactory.ProviderType.WEIBO);
////        boolean installed = shareManager.isInstalled();
////        if(!installed){
////            Toast.makeText(GameBoxApp.getApp(),GameBoxApp.getApp().getString(R.string.weibo_not_installed),Toast.LENGTH_SHORT).show();
////            return;
////        }
//        WeiboShareObject weiboShareObject = new WeiboShareObject();
//        weiboShareObject.shareType = IShareManager.ShareType.SHARE_TO_WEIBO_TYPE_WEBPAGE;
//        weiboShareObject.activity = activity;
//        weiboShareObject.text = bundle.getString(KEY_SHARE_TITLE);
//        weiboShareObject.title = bundle.getString(KEY_SHARE_SUBTITLE);//网页的title，对应content，通用模板
//        weiboShareObject.description = bundle.getString(KEY_SHARE_SUBTITLE);
//        String shareUrl =  bundle.getString(KEY_SHARE_URL);
//        String weibo_url = bundle.getString(KEY_SHARE_URL_WEIBO);
//        if(!TextUtils.isEmpty(weibo_url)){
//            shareUrl = weibo_url;
//        }
//        weiboShareObject.webpageUrl = shareUrl;
//        weiboShareObject.imageBmp = thumbBitmap;
//        weiboShareObject.thumbBmp = thumbBitmap;
//
//        shareManager.share(weiboShareObject, new IResponseUIListener() {
//            @Override
//            public void onSuccess(JSONObject result) {
//                CLog.d(TAG, "onSuccess() called with: result = [" + result + "]");
//                Toast.makeText(GameBoxApp.getApp(),"微博分享成功",Toast.LENGTH_SHORT).show();
//                shareManager.destroy();
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
////                Toast.makeText(GameBoxApp.getApp(),"微博分享失败",Toast.LENGTH_SHORT).show();
//                CLog.d(TAG, "onFail() called with: errCode = [" + errCode + "], errMsg = [" + errMsg + "]");
//                shareManager.destroy();
//            }
//        });
    }
}
