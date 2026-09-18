package org.example.servlet;

import org.example.dto.TvsMotorsDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/tvss",loadOnStartup = 2)
public class readServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        TvsMotorsDto dto=new TvsMotorsDto();
        dto.setModelName(req.getParameter("modelName"));
        dto.setBrand(req.getParameter("brand"));
        dto.setCategory(req.getParameter("category"));
        dto.setPrice(Double.parseDouble(req.getParameter("price")));


        HttpSession session = req.getSession();


        session.setAttribute("modelName", dto.getModelName());
        session.setAttribute("brand", dto.getBrand());
        session.setAttribute("category", dto.getCategory());
        session.setAttribute("price", dto.getPrice());

        RequestDispatcher dispatcher1=req.getRequestDispatcher("read.jsp");
        dispatcher1.forward(req, resp);
    }

}
