package com.xin.sub_module2;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.xin.router.annotations.XinRouterHost;
import com.xin.router.annotations.XinRouterPath;

@XinRouterHost(host = "MyProvider2/ssss")
public class MyProvider2 {


    @XinRouterPath(path = "asssssssss")
    public void showTost(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }


    @XinRouterPath(path = "sflsssssssss")
    public void showTost() {
        Log.d("-------------->路由调用","哈哈哈哈哈哈哈哈哈哈哈啊");
    }


}
