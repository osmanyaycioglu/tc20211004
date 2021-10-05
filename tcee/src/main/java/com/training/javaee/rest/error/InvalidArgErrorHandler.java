package com.training.javaee.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidArgErrorHandler implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(final IllegalArgumentException exceptionParam) {
        ErrorObj errorObjLoc = new ErrorObj().setMessage("Illegal arg error : " + exceptionParam.getMessage())
                                             .setCause(1011);

        return Response.status(400)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(errorObjLoc)
                       .build();
    }

}
