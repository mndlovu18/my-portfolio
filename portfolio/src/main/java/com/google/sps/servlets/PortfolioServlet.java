package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class PortfolioServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse 
    response) throws IOException{
           response.getWriter().print("Hello world!");
    }
}