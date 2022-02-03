package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

@Path("/hello")
public class ReactiveGreetingResource {

    @RestClient
    ReactiveClient client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public RestResponse<Object> hello() {
        return ResponseBuilder.notFound().build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public RestResponse<String> test() {
        return client.testApi();
    }
}