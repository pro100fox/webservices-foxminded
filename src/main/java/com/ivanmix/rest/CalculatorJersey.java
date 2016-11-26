package com.ivanmix.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/calculator")
public class CalculatorJersey {

    //http://localhost:8080/rest/calculator/10/10/+
    @GET
    @Path("/{one}/{two}/{operator}")
    public Response get(@PathParam("one") int one,@PathParam("two") int two,@PathParam("operator") String operator) {
        String output = calculator(one, two, operator);
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/")
    public Response post(@FormParam("one") int one, @FormParam("two") int two, @FormParam("operator") String operator) {
        String output = calculator(one, two, operator);
        return Response.status(200).entity(output).build();
    }


    private String calculator(int one, int two, String  operator){
        int resultValue;
        if(operator.equals("-")){
            resultValue =  one - two;
        } else if(operator.equals("*")){
            resultValue =  one * two;
        } else if(operator.equals("/")){
            resultValue =  one / two;
        } else{
            resultValue =  one + two;
            operator = "+";
        }
        return "{\"numberOne\":"+one+",\"numberTwo\":"+two+",\"operator\":"+operator+",\"result\":"+resultValue+"}";
    }

}