package com.gzucm.mnews.app.util;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created on 2018/6/24 0024 14:23.
 *
 * @author herozii
 */
public class DialogUtil {
    static ProgressDialog progressDialog;


    /*
     * 提示加载
     */
    public static void showProgressDialog(String title, String message, Context context) {
        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(context, title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }

        progressDialog.show();

    }

    /*
     * 隐藏提示加载
     */
    public static void hideProgressDialog() {

        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });


    }
}
