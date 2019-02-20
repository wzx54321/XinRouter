package com.xin.router;

import com.xin.router.annotations.RouterUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Sender {

    public static Object execute(String path, Object realTarget,
                                 HashMap<String, Object> methodName, HashMap<String, Object> parameter) throws NoSuchMethodException {

        //  2. 通过path找到对应的方法
        Method method = (Method) methodName.get(path);
        if (method == null) {
            throw new NoSuchMethodException("path：" + path + "没有找到对应的方法");
        }
        Object[] parameters = null;
        String[] parameter_keys;
        //  3. 匹配对应的参数

        if(parameter!=null){

            String parameterKeys = (String) methodName.get(RouterUtils.getParameterKey(path));
            if (!RouterUtils.isEmpty(parameterKeys)) {
                parameter_keys = parameterKeys.split(",");
                int len = parameter_keys.length;
                parameters = new Object[len];
                for (int i = 0; i < len; i++) {
                    parameters[i] =
                            parameter.get(parameter_keys[i]);
                }
            }
        }


        try {
            return method.invoke(realTarget, parameters);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
