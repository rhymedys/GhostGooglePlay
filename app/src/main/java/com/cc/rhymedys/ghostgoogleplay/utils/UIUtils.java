package com.cc.rhymedys.ghostgoogleplay.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.widget.Toast;

import com.cc.rhymedys.ghostgoogleplay.global.GooglePlayApplication;

/**
 * Created by Rhymedys on 2016/10/7.
 */

public class UIUtils {
    /**
     * 弹出Toast对象
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
    ////////////////////////

    public static Context getContext() {
        return GooglePlayApplication.getContext();
    }

    public static int getMainThreadId() {
        return GooglePlayApplication.getMainThreadID();
    }

    public static Handler getHandler() {
        return GooglePlayApplication.getHandler();
    }

    //获取应用内的资源
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    /**
     * 像素
     * 获得尺寸
     *
     * @param id
     * @return
     */
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }


    ///dip与pix之间的转换
    public static int dip2pix(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density * 0.5f);
    }

    public static float pix2dip(float pix) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return pix / density;
    }

    //加载布局
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    //判断是否运行在主线程
    public static boolean isRunOnUIThread() {
        boolean i = true;
        if (getMainThreadId() != Process.myTid()) {
            i = false;
        }
        return i;
    }

    /**
     * 运行在主线程的方法
     *
     * @param r
     */
    public static void runOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }
    }


    /**
     * 根据颜色返回按钮状态
     *
     * @param id
     * @return
     */
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }
}
