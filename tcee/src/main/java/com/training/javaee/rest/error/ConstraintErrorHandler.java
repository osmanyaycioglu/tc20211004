package com.training.javaee.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintErrorHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exceptionParam) {
        ErrorObj errorObjLoc = new ErrorObj().setMessage("Validation error")
                                             .setCause(1001);

        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            errorObjLoc.add(new ErrorObj().setMessage(constraintViolationLoc.getMessage())
                                          .setCause(1002));
        }
        return Response.status(400)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(errorObjLoc)
                       .build();
    }

}
