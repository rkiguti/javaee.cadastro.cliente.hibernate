/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devblog.servlet;

import br.com.devblog.dao.ClienteDAO;
import br.com.devblog.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kiguti
 */
@WebServlet(name = "AlterarClienteServlet", urlPatterns = {"/alterar"})
public class AlterarClienteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = null;
        
        int id = Integer.parseInt(request.getParameter("id"));
            
        ClienteDAO dao = new ClienteDAO();
            
        c = dao.obter(id);
        
        request.setAttribute("cliente", c);
        request.getRequestDispatcher("WEB-INF/alterarCliente.jsp").forward(request, response);
    }

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
        c.setNome(request.getParameter("nome"));
        c.setTelefone(request.getParameter("telefone"));
            
        ClienteDAO dao = new ClienteDAO();
        dao.alterar(c);
        
        response.sendRedirect(request.getContextPath() + "/");
    }

}
