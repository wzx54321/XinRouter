package com.xin.router;


import com.xin.router.annotations.RouterUtils;
import com.xin.router.reflectasm.MethodAccess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 路由分发者
 */
class RouterDispatcher {


    public static Object call(RouterRequest routerRequest) {
        try {
            // 1. 通过host找到对应的类

            Class target = Class.forName(RouterUtils.getBridgeClassAllName(routerRequest.getHost()));
            Method targetMethod = target.getMethod("invoke", String.class, HashMap.class);
            Object results= targetMethod.invoke(target.newInstance(),routerRequest.getPath(), routerRequest.getParameters());
          /*  MethodAccess access =  MethodAccess.get(target.getClass());
            Object results = access.invoke(target.newInstance(),
                    "invoke", routerRequest.getPath(), routerRequest.getParameters());*/
            return results;
            // 4. 调用，处理返回值
        } catch  (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return null;
    }




}
