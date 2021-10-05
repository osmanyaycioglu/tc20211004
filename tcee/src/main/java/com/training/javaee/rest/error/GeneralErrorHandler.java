package com.training.javaee.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralErrorHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exceptionParam) {
        ErrorObj errorObjLoc = new ErrorObj().setMessage("Unknown error : " + exceptionParam.getMessage())
                                             .setCause(1500);

        return Response.status(500)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(errorObjLoc)
                       .build();
    }

}
