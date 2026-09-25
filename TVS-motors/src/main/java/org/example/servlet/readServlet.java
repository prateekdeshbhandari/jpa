package org.example.servlet;

import org.example.dto.TvsMotorsDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(urlPatterns = "/tvss",loadOnStartup = 2)
public class readServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        String id = null;
        String modelName = null;
        String brand = null;
        String category = null;
        String price = null;

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("id".equals(cookie.getName())) {
                    id = cookie.getValue();
                }

                if ("modelName".equals(cookie.getName())) {
                    modelName = cookie.getValue();
                }

                if ("brand".equals(cookie.getName())) {
                    brand = cookie.getValue();
                }

                if ("category".equals(cookie.getName())) {
                    category = cookie.getValue();
                }

                if ("price".equals(cookie.getName())) {
                    price = cookie.getValue();
                }
            }
        }

        req.setAttribute("id", id);
        req.setAttribute("modelName", modelName);
        req.setAttribute("brand", brand);
        req.setAttribute("category", category);
        req.setAttribute("price", price);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("read.jsp");

        dispatcher.forward(req, resp);
    }
}


