package com.mibanco.ts.crearclientecdtdgital.utils;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @Override
    public Response toResponse(ApplicationException exception) {
        LOG.error(exception.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(exception.getStatus());
        errorMessage.setMessage(exception.getMessage());
        return Response
                .serverError()
                .status(exception.getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
