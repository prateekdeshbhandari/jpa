package com.xworkz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register",loadOnStartup = 1)
public class RegistretionFormServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Name=request.getParameter("name");
        String Email=request.getParameter("email");
        String Password=request.getParameter("password");
        String Phone=request.getParameter("phone");

        System.out.println("Name: " + Name);
        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);
        System.out.println("Phone: " + Phone);

        request.setAttribute("name", Name);
        request.setAttribute("email", Email);
        request.setAttribute("password", Password);
        request.setAttribute("phone", Phone);

        RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request,response);

    }
}
