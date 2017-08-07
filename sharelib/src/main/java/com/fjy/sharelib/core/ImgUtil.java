package com.fjy.sharelib.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fjy.sharelib.R;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by fujianyi on 2017/8/7.
 */

public class ImgUtil {

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

    public static  Bitmap getThumbBipmap(File thumbFile, Context context) {
        Bitmap thumbBmp;
        if (thumbFile != null && thumbFile.exists()) {
            Bitmap bmp = BitmapFactory.decodeFile(thumbFile.getPath());
            thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();

        } else {
            Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
            thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();
        }
        return thumbBmp;
    }

    public static  byte[] getThumbBytes(File thumbFile, Context context) {
        byte[] thumbByte;
        if (thumbFile != null && thumbFile.exists()) {
            Bitmap bmp = BitmapFactory.decodeFile(thumbFile.getPath());
            Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            bmp.recycle();
            thumbByte = bmpToByteArray(thumbBmp, true);
        } else {
            Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
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
