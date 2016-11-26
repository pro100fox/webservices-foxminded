package com.ivanmix.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlets extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numberOne = Integer.parseInt(request.getParameter("number_one"));
        int numberTwo = Integer.parseInt(request.getParameter("number_two"));
        String operator = request.getParameter("operator");
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
        response.setContentType("application/json");
        response.getWriter().append(result);
    }
}