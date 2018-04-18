package com.houli.recycleviewdemo;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    /**
     * Created by stone on 2018/3/13.
     */
    private static Toast toast;

    public static void showToast(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

}
