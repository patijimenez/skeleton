package mx.com.mschool.shiro;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SerializableSavedRequest implements Serializable {
    private ServletRequest request;

    public SerializableSavedRequest(ServletRequest request) {
        setRequest(request);
    }

    public void setRequest(ServletRequest request) {
        this.request = request;
    }

    public ServletRequest getRequest() {
        return request;
    }
}
