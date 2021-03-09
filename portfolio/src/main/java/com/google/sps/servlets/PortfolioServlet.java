package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class PortfolioServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse 
    response) throws IOException{
           
           //Array that contains hard-coded strings 
           String facts[] = {"I am from Bulawayo in Zimbabwe!", " I am the last born child of 13 children!", 
           " My name is the name of a camera!" };

           Gson gson = new Gson();
           String jsonResponse = gson.toJson(facts);

           response.setContentType("application/json;");
           response.getWriter().print(jsonResponse);
    }
    
}