package org.example.servlet;

import org.example.dto.TvsMotorsDto;
import org.example.service.TvsService;
import org.example.service.impl.TvsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/TVS",loadOnStartup = 1)
public class TvsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create DTO
        TvsMotorsDto dto = new TvsMotorsDto();

        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setModelName(req.getParameter("modelName"));
        dto.setBrand(req.getParameter("brand"));
        dto.setCategory(req.getParameter("category"));
        dto.setPrice(Double.parseDouble(req.getParameter("price")));

        // Service
        TvsService service = new TvsServiceImpl();

        boolean isSaved = service.validateAndSave(dto);

        System.out.println("Is saved: " + isSaved);

        if (isSaved) {

            // Encode values before storing in cookies
            String modelName = URLEncoder.encode(
                    dto.getModelName(),
                    StandardCharsets.UTF_8
            );

            String brand = URLEncoder.encode(
                    dto.getBrand(),
                    StandardCharsets.UTF_8
            );

            String category = URLEncoder.encode(
                    dto.getCategory(),
                    StandardCharsets.UTF_8
            );

            // Create cookies
            Cookie id = new Cookie(
                    "id",
                    String.valueOf(dto.getId())
            );

            Cookie modelNameCookie = new Cookie(
                    "modelName",
                    modelName
            );

            Cookie brandCookie = new Cookie(
                    "brand",
                    brand
            );

            Cookie categoryCookie = new Cookie(
                    "category",
                    category
            );

            Cookie price = new Cookie(
                    "price",
                    String.valueOf(dto.getPrice())
            );

            // Cookie age = 1 day
            int maxAge = 60 * 60 * 24;

            id.setMaxAge(maxAge);
            modelNameCookie.setMaxAge(maxAge);
            brandCookie.setMaxAge(maxAge);
            categoryCookie.setMaxAge(maxAge);
            price.setMaxAge(maxAge);

            // Send cookies to browser
            resp.addCookie(id);
            resp.addCookie(modelNameCookie);
            resp.addCookie(brandCookie);
            resp.addCookie(categoryCookie);
            resp.addCookie(price);

            // Store success message
            req.getSession().setAttribute(
                    "message",
                    "Motorcycle registered successfully!"
            );

            // Redirect to read servlet
            resp.sendRedirect("tvss");
            req.getRequestDispatcher("Rejest.jsp")
                    .forward(req, resp);
        } else {

            req.setAttribute(
                    "errorMessage",
                    "Failed to register motorcycle. Please try again."
            );

            req.getRequestDispatcher("Rejest.jsp")
                    .forward(req, resp);
        }
    }
}