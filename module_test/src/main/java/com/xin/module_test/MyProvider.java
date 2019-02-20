package com.xin.module_test;

import android.content.Context;
import com.xin.router.XinRouter;
import com.xin.router.annotations.XinRouterHost;
import com.xin.router.annotations.XinRouterPath;

import java.util.HashMap;

@XinRouterHost(host = "module_test.com")
public class MyProvider {

    @XinRouterPath(path = "getTest")
    public String getTest(Context a, String name) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("activity", a);
        map.put("message", "我是小明" + name);

        XinRouter.getInstance().to("MyProvider2/ssss")
                .call("asssssssss", map);
        XinRouter.getInstance().to("MyProvider2/ssss")
                .call("sflsssssssss", null);


        return "我是小明" + name;
    }
}
