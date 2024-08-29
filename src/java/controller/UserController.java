/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuarios;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController","/Login","/Cadastro","/Home"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
       String paginaAtual = request.getServletPath();
        
        
        
        if(paginaAtual.equals("/Login")){
        
        request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
        
        
        }else
        
        if(paginaAtual.equals("/Cadastro")){
        
        request.getRequestDispatcher("/WEB-INF/jsp/Cadastro.jsp").forward(request, response);
         
    }
if(paginaAtual.equals("/Home")){
        
        request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
        
        
    }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaAtual = request.getServletPath();
         String nextPage = "";
    Usuarios user = new Usuarios();
    UsuariosDAO udao = new UsuariosDAO();
    
    if(paginaAtual.equals("/Login")){
    
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));
        
        user = udao.validarLogin(user);
        if(user.getId_usuario() > 0){
        response.sendRedirect("./Home");
        }else{
        response.sendRedirect("./Login");
        }
    }
    
     if(paginaAtual.equals("/Cadastro")){
     Usuarios novoUser = new Usuarios();
            
            novoUser.setNome(request.getParameter("nome"));
            novoUser.setEmail(request.getParameter("email"));
            novoUser.setSenha(request.getParameter("senha"));
           
            UsuariosDAO usuarios = new UsuariosDAO();
            usuarios.cadastrarUsuario(novoUser);
            
            response.sendRedirect("Login");
         
     }
    
    
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
