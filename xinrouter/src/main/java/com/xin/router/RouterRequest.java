package com.xin.router;

import java.util.HashMap;

public class RouterRequest {

    private String host;
    private String path;
    private HashMap<String, Object> parameters;

    RouterRequest(String host) {
        this.host = host;
    }


   public Object call(String path, HashMap<String, Object> parameters) {
        this.path = path;
        this.parameters = parameters;
        return RouterDispatcher.call(this);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }
}
