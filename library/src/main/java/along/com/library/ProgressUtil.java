package along.com.library;


import along.com.library.view.DialogLoad;

/**
 * Description: 进度条显示消失工具类
 */
public class ProgressUtil {
    public static void showProgressDialog(DialogLoad progressDialog) {
        if (null != progressDialog && !progressDialog.isShowing())
            progressDialog.show();
    }

    public static void dismissProgressDialog(DialogLoad progressDialog) {
        if (null != progressDialog && progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
