package org.example.servlet;

import org.example.dto.TvsMotorsDto;
import org.example.service.TvsService;
import org.example.service.impl.TvsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/TVS",loadOnStartup = 1)
public class TvsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TvsMotorsDto dto = new TvsMotorsDto();
        dto.setModelName(req.getParameter("modelName"));
        dto.setBrand(req.getParameter("brand"));
        dto.setCategory(req.getParameter("category"));
        dto.setPrice(Double.parseDouble(req.getParameter("price")));


        TvsService service=new TvsServiceImpl();
        boolean isSaved = service.validateAndSave(dto);
        System.out.println("Is saved: " + isSaved);


        if(isSaved){
            RequestDispatcher dispatcher=req.getRequestDispatcher("Rejest.jsp");
            req.setAttribute("message", "Motorcycle registered successfully!");
            dispatcher.forward(req, resp);
        }else{
           req.setAttribute("errorMessage", "Failed to register motorcycle. Please try again.");
           req.getRequestDispatcher("Rejest.jsp").forward(req, resp);
        }
    }
}
