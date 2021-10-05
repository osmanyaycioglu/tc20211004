package com.training.javaee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        String parameterLoc = reqParam.getParameter("name");
        System.out.println("I got GET request");
        respParam.getWriter()
                 .println("Hello world from servlet");
        respParam.setHeader("Content-Type",
                            "text/plain");
        respParam.setHeader("myheader",
                            "osman");
    }

}
