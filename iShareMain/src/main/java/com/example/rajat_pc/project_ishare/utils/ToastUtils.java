package com.example.rajat_pc.project_ishare.utils;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;



public class ToastUtils
{

    private static Toast toast = null;

    /** show toast, keep only one instance*/
    private static Handler handler = new Handler(Looper.getMainLooper());

    public static void showTextToast(Context context, String msg)
    {
        /*
         * if (toast == null) { toast = Toast.makeText(NetAPP.getContext(), msg,
         * Toast.LENGTH_SHORT); toast.setGravity(Gravity.BOTTOM, 0, 150); } else
         * { toast.setText(msg); } toast.show();
         */
        showMessage(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final Context act, final String msg, final int len)
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (toast != null)
                        {
                            // toast.cancel();
                            toast.setText(msg);
                            // toast.setDuration(len);
                        }
                        else
                        {
                            toast = Toast.makeText(act, msg, len);
                            toast.setGravity(Gravity.BOTTOM, 0, 100);
                        }
                        toast.show();
                    }
                });
            }
        }).start();
    }

}
