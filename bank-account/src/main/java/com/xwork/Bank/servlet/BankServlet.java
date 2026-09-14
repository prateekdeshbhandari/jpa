package com.xwork.Bank.servlet;

import com.xwork.Bank.Service.DebitAccountService;
import com.xwork.Bank.Service.impl.DebitAccountServiceImpl;
import com.xwork.Bank.dto.DebitAccountDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/bank",loadOnStartup = 1)
public class BankServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DebitAccountDTO dto=new DebitAccountDTO();
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setBankName(req.getParameter("bankName"));
        dto.setAccountHolderName(req.getParameter("accountHolderName"));
        dto.setAccountNumber(req.getParameter("accountNumber"));
        dto.setBalance(Double.parseDouble(req.getParameter("balance")));



        DebitAccountService service=new DebitAccountServiceImpl();

       Boolean saved = service.validateAndSave(dto);
        if(saved){
            req.setAttribute("message","succsefully");
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        }else{
            req.setAttribute("message","failed to save");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }




    }
}
