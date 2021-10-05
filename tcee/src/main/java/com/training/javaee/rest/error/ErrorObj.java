package com.training.javaee.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> errorObjs;
    private String         message;
    private int            cause;


    public ErrorObj add(final ErrorObj errorObjParam) {
        if (this.errorObjs == null) {
            this.errorObjs = new ArrayList<>();
        }
        this.errorObjs.add(errorObjParam);
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }

    public List<ErrorObj> getErrorObjs() {
        return this.errorObjs;
    }

    public ErrorObj setErrorObjs(final List<ErrorObj> errorObjsParam) {
        this.errorObjs = errorObjsParam;
        return this;
    }

}
