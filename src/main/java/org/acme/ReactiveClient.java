package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestResponse;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;

@RegisterRestClient(configKey = "api")
@RegisterProvider(ExceptionMapper.class)
public interface ReactiveClient {

    @GET
    @Path("/hello")
    public RestResponse<String> testApi();

    @ClientExceptionMapper(priority = Priorities.USER - 1)
    static RuntimeException toException(Response response) {
        if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
            return new NotFoundException("FROM CLIENT");
        }
        return null;
    }

}
