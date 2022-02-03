package org.acme;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class ExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status == Status.NOT_FOUND.getStatusCode();
    }

    @Override
    public RuntimeException toThrowable(Response response) {
        return new RuntimeException("FROM MAPPER");
    }

}
