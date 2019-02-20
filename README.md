# XinRouter
[![](https://jitpack.io/v/wzx54321/xin-router.svg)](https://jitpack.io/#wzx54321/xin-router)  

android组件化轻量级路由调用,支持组件件方法调用。  
使用编译注解，绑定入口类和调用的方法。

### 引入项目：
  方法一：远程引入  

    
     implementation 'com.github.wzx54321:xin-router:1.0.1'
     // 定义入口方法的模块添加：
     annotationProcessor 'com.github.wzx54321:xinrouter_compiler:1.0.5'  
    


  方法二：源码引用:  
  
     
     implementation project(":xinrouter")
     // 使用绑定注解的Module引用
     annotationProcessor project(":xinrouter_compiler")  
     
     

### 调用方法：

1.组件中定义任意类，绑定XinRouterHost注解，提供组件调用的方法上绑定自定义注解XinRouterPath，定义自定义Host和自定义path，例如：
``````
@XinRouterHost(host = "自定义的host")
public class MyProvider2 {


    @XinRouterPath(path = "自定义路径")
    public void showTost(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }


}

``````  
2.组件使用如下调用，填写对应的host和path，以及参数，注意--》参数名称作为map的key,要对应好！！！ 如下：

`````
 HashMap<String, Object> map = new HashMap<>();
 map.put("activity"/*参数名要与定义的方法一致*/, MainActivity.this);
 map.put("message"/*参数名要与定义的方法一致*/ "hahahahahahhaha");
 XinRouter.getInstance().to("自定义对应的host").call("自定义对应的path", map/*对应的参数*/);
 
`````





