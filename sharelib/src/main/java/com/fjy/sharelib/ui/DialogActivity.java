package com.fjy.sharelib.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.fjy.sharelib.R;
import com.fjy.sharelib.core.ImgUtil;
import com.fjy.sharelib.core.ShareCore;
import com.fjy.sharelib.share.QQShare;
import com.fjy.sharelib.share.WechatShare;
import com.fjy.sharelib.share.WeiboShare;
import com.fjy.sharelib.model.DataSource;

import java.io.File;

/**
 * Created by cjz on 2017/7/4.
 */

public class DialogActivity extends AppCompatActivity {

    private String shareImg;
    File thumbFile;
    DataSource dataSource;

    private class GetImageCacheAsyncTask extends AsyncTask<String, Void, File> {
        private final Context context;

        public GetImageCacheAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected File doInBackground(String... params) {
            String imgUrl = params[0];
            try {
                return Glide.with(context)
                        .load(imgUrl)
                        .downloadOnly(100, 100)
                        .get();
            } catch (Exception ex) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(File result) {
            if (result == null) {
                return;
            }
            thumbFile = result;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_dialog);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(ShareCore.KEY_SHARE_BUNDLE)) {
            dataSource = (DataSource) intent.getSerializableExtra(ShareCore.KEY_SHARE_BUNDLE);
            if (dataSource != null) {
                //only get imgurl for preload
                shareImg = dataSource.getImgUrl();
            }

            new GetImageCacheAsyncTask(this).execute(shareImg);
        }

    }

    public void shareQq(View view) {
        new QQShare().isQQorQzone(true).with(dataSource).doShare(this);
        finish();
    }
    public void shareQzone(View view) {
        new QQShare().isQQorQzone(false).with(dataSource).doShare(this);
        finish();
    }

    public void shareWc(View view) {
        new WechatShare().isShareToMoments(false).configImageSource(getThumbBytes()).with(dataSource).doShare(this);
        finish();
    }

    public void shareCircle(View view) {
        new WechatShare().isShareToMoments(true).configImageSource(getThumbBytes()).with(dataSource).doShare(this);
        finish();
    }

    public void shareMb(View view) {
        new WeiboShare().configImageSource(getThumbBitmap()).with(dataSource).doShare(this);
        finish();
    }



    public void shareCancel(View view) {
        finish();
    }

    private Bitmap getThumbBitmap(){
        return ImgUtil.getThumbBipmap(thumbFile,DialogActivity.this.getApplicationContext());
    }
    private byte[] getThumbBytes(){
        return ImgUtil.getThumbBytes(thumbFile,DialogActivity.this.getApplicationContext());
    }

}
