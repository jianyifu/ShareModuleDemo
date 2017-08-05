package com.fjy.sharelib;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.fjy.sharelib.fun.MomentsShare;
import com.fjy.sharelib.fun.QQShare;
import com.fjy.sharelib.fun.QZoneShare;
import com.fjy.sharelib.fun.WechatShare;
import com.fjy.sharelib.fun.WeiboShare;
import com.fjy.sharelib.core.ShareUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by cjz on 2017/7/4.
 */

public class DialogActivity extends AppCompatActivity {

    private String shareImg;
    File thumbFile;
    ShareItem shareItem;

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

        if (intent != null && intent.hasExtra(ShareUtil.KEY_SHARE_BUNDLE)) {
            shareItem = (ShareItem) intent.getSerializableExtra(ShareUtil.KEY_SHARE_BUNDLE);
            if (shareItem != null) {
                //only get imgurl for preload
                shareImg = shareItem.getImgUrl();
            }

            new GetImageCacheAsyncTask(this).execute(shareImg);
        }

    }

    public void shareQq(View view) {
        new QQShare(shareItem).doShare(this);
        finish();
    }
    public void shareQzone(View view) {
        new QZoneShare(shareItem).doShare(this);
        finish();
    }

    public void shareWc(View view) {
        new WechatShare(shareItem, getThumbData()).doShare(this);
        finish();
    }

    public void shareCircle(View view) {
        new MomentsShare(shareItem, getThumbData()).doShare(this);
        finish();
    }

    public void shareMb(View view) {
        new WeiboShare(shareItem, getThumbBipmap()).doShare(this);
        finish();
    }



    public void shareCancel(View view) {
        finish();
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private Bitmap getThumbBipmap() {
        Bitmap thumbBmp;
        if (thumbFile != null && thumbFile.exists()) {
            Bitmap bmp = BitmapFactory.decodeFile(thumbFile.getPath());
            thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();

        } else {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();
        }
        return thumbBmp;
    }

    private byte[] getThumbData() {
        byte[] thumbByte;
        if (thumbFile != null && thumbFile.exists()) {
            Bitmap bmp = BitmapFactory.decodeFile(thumbFile.getPath());
            Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();
            thumbByte = bmpToByteArray(thumbBmp, true);
        } else {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();
            thumbByte = bmpToByteArray(thumbBmp, true);
        }
        if (thumbByte != null && thumbByte.length > 0) {
            return thumbByte;
        }
        return null;
    }

}
