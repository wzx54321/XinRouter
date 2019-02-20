package com.xin.router;

/**
 * 统一入口
 */
public class XinRouter {

    private XinRouter() {
    }

    static class lazyHolder {
        static XinRouter xinRouter = new XinRouter();
    }


    public static XinRouter getInstance() {
        return lazyHolder.xinRouter;
    }


    public RouterRequest to(String host) {
        return new RouterRequest(host);
    }






}
