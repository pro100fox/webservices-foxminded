package com.ivanmix.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        String result = calculator(request);
        response.setContentType("application/json");
        response.getWriter().append("get: " + result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String result = calculator(request);
        response.setContentType("application/json");
        response.getWriter().append("post: " + result);
    }

    private String calculator(HttpServletRequest request){
        int numberOne;
        int numberTwo;

        try {
            numberOne = Integer.parseInt(request.getParameter("number_one"));
            numberTwo = Integer.parseInt(request.getParameter("number_two"));
        } catch (NumberFormatException e){
            numberOne = 2;
            numberTwo = 3;
        }

        String operator = request.getParameter("operator");
        if(operator==null){
            operator = "+";
        }
        int resultValue;
        if(operator.equals("-")){
            resultValue =  numberOne - numberTwo;
        } else if(operator.equals("*")){
            resultValue =  numberOne * numberTwo;
        } else if(operator.equals("/")){
            resultValue =  numberOne / numberTwo;
        } else{
            resultValue =  numberOne + numberTwo;
            operator = "+";
        }
        String result = "{\"numberOne\":"+numberOne+",\"numberTwo\":"+numberTwo+",\"operator\":"+operator+",\"result\":"+resultValue+"}";
        return result;
    }

}