package com.training.rest.client;


public class RestClientExp extends Exception {

    private static final long serialVersionUID = -359077029038643900L;

    private ErrorObj          errorObj;


    public RestClientExp() {
    }


    public RestClientExp(final ErrorObj errorObjParam) {
        super();
        this.setErrorObj(errorObjParam);
    }


    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
