package org.example.demo1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/json")
    @GET
    @Produces("application/json")
    public String helloJson() {
        return "{message: Hello, World!}";
    }
}