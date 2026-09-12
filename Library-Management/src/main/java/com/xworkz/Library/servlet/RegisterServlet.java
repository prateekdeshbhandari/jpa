package com.xworkz.Library.servlet;

import com.xworkz.Library.dto.LibraryDTO;
import com.xworkz.Library.service.LibraryService;
import com.xworkz.Library.service.impl.LibraryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/register",loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    @Override
   public   void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LibraryDTO libraryDTO = new LibraryDTO();

        libraryDTO.setId(Integer.parseInt(req.getParameter("id")));
        libraryDTO.setBookName(req.getParameter("bookName"));
        libraryDTO.setAuthorName(req.getParameter("authorName"));
        libraryDTO.setCategory(req.getParameter("category"));
        libraryDTO.setPrice(Double.parseDouble(req.getParameter("price")));

        LibraryService libraryService = new LibraryServiceImpl();
        Boolean saved= libraryService.validateAndSave(libraryDTO);
        if(saved){
            RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
            req.setAttribute("message", "Book registered successfully!");
            dispatcher.forward(req,resp);
        }
else{
    RequestDispatcher dispatcher=req.getRequestDispatcher("/register.jsp");
    req.setAttribute("message", "Failed to register book!");
    dispatcher.forward(req,resp);
        }


    }
}
