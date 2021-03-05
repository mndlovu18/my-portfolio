package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class PortfolioServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse 
    response) throws IOException{
           /*response.setContentType("text/html;");
           response.getWriter().print("Scroll down to learn more!");*/
           
           //Array that contains hard-coded strings 
           String facts[] = {"I am from Bulawayo in Zimbabwe!"," I am the last born child of 13 children!",
           " My name is the name of a camera!" };
           
           String jsonResponse = convertToJsonUsingGson(facts);

           response.setContentType("application/json;");
           response.getWriter().print(jsonResponse);
    }

    private String convertToJsonUsingGson(String[] stringArray) {
    Gson gson = new Gson();
    String json = gson.toJson(stringArray);
    return json;
  }
    
}