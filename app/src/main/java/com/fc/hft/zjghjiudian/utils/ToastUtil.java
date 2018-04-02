package com.fc.hft.zjghjiudian.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Toast提示工具类
 *
 * @author whhft
 */
@SuppressLint("ShowToast")
public class ToastUtil {

    /**
     * 弹出Toast
     *
     * @param ctx 弹出Toast的上下文
     * @param msg 弹出Toast的内容
     */
    public static void showShort(Context ctx, CharSequence msg)
            throws NullPointerException {
        if (null == ctx) {
            throw new NullPointerException("The ctx is null!");
        }
        Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出Toast
     *
     * @param ctx 弹出Toast的上下文
     * @param msg 弹出Toast的内容
     */
    public static void showLong(Context ctx, CharSequence msg)
            throws NullPointerException {
        if (null == ctx) {
            throw new NullPointerException("The ctx is null!");
        }
        Toast.makeText(ctx,msg,Toast.LENGTH_LONG).show();
    }

    /**
     * 弹出Toast
     *
     * @param ctx 弹出Toast的上下文
     *            弹出Toast的内容的资源ID
     */
    public static void showShort(Context ctx, int resId)
            throws NullPointerException {
        if (null == ctx) {
            throw new NullPointerException("The ctx is null!");
        }
        Toast.makeText(ctx,ctx.getResources().getString(resId),Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出Toast
     *
     * @param ctx 弹出Toast的上下文
     *            弹出Toast的内容的资源ID
     */
    public static void showLong(Context ctx, int resId)
            throws NullPointerException {
        if (null == ctx) {
            throw new NullPointerException("The ctx is null!");
        }
        Toast.makeText(ctx,ctx.getResources().getString(resId),Toast.LENGTH_LONG).show();
    }
}
