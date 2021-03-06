/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devblog.servlet;

import br.com.devblog.dao.ClienteDAO;
import br.com.devblog.model.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kiguti
 */
@WebServlet(name = "ExcluirClienteServlet", urlPatterns = {"/excluir"})
public class ExcluirClienteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(request.getParameter("id")));
            
        ClienteDAO dao = new ClienteDAO();
        dao.excluir(c);
        
        response.sendRedirect(request.getContextPath() + "/");
    }

}
