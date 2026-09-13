package org.example.servlet;

import org.example.dto.DocterDTO;
import org.example.service.DocterService;
import org.example.service.impl.DocterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/registerDoctor",loadOnStartup = 1)
public class DocterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DocterDTO docterDTO = new DocterDTO();
        docterDTO.setId(Integer.parseInt(req.getParameter("id")));
        docterDTO.setName(req.getParameter("name"));
        docterDTO.setSpecialization(req.getParameter("specialization"));
        docterDTO.setHospitalName(req.getParameter("hospitalName"));
        docterDTO.setPhoneNumber(req.getParameter("phoneNumber"));


        DocterService docterService = new DocterServiceImpl();
       boolean saved = docterService.validateAndSave(docterDTO);

       if(saved) {
           RequestDispatcher dispatcher=req.getRequestDispatcher("Rejestar.jsp");
req.setAttribute("message", "Docter saved successfully");
           dispatcher.forward(req, resp);
       } else {
           RequestDispatcher dispatcher=req.getRequestDispatcher("Rejestar.jsp");
           req.setAttribute("errorMessage", "Docter not saved");
           dispatcher.forward(req, resp);
       }

    }
}


