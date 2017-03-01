package com.ivanmix.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json/book")
public class JSONService {

    //http://localhost:8080/json/book/get
    @GET
    @Path("/get")
    @Produces("application/json")
    public Book getBookInJSON() {

        Book book = new Book();
        book.setId(10);
        book.setTitle("test");
        book.setAuthor("my");

        return book;
    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createBookInJSON(Book book) {
        String result = "Book created : " + book;
        return Response.status(201).entity(result).build();
    }
}