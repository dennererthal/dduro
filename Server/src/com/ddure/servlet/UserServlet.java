/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.servlet;

import com.ddure.db.dao.UserDAO;
import com.ddure.data.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author herykgasparini
 */
public class UserServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter out;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html;charset=UTF-8");

        request = req;
        response = resp;
        out = resp.getWriter();

        switch (request.getParameter("action")) {
            case "login":
                userAuthentication();
                break;
            case "logout":
                userInvalidate();
                break;
            case "insertUser":
                insertUser();
                break;
            case "alterUser":
                alterUser();
                break;
            default:
                break;
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void userAuthentication() {

        User user = new UserDAO().getAuthentication(request.getParameter("cpf"), request.getParameter("password"));

        if (user != null) {
            HttpSession session = request.getSession();

            session.setAttribute("userLogged", user);
            encaminharPagina("occurrenceList.jsp");

        } else {
            request.setAttribute("wrongLogin", "error");
            encaminharPagina("login.jsp");
        }
    }

    private void userInvalidate() {
        HttpSession session = request.getSession();
        session.invalidate();

        try {
            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            System.out.println("Erro desconectar: " + e);
        }
    }

    private void insertUser() {

        User u = new User();

        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setName(request.getParameter("name"));
        u.setEmail(request.getParameter("email").toLowerCase());
        u.setPassword(request.getParameter("password"));
        u.setCpf(request.getParameter("cpf"));
        u.setStatus(Integer.parseInt(request.getParameter("status")));

        if (new UserDAO().insertUser(u)) {

            request.setAttribute("success", "userList.jsp");
            encaminharPagina("userList.jsp");

        } else {
            request.setAttribute("error", "userForm.jsp");
            encaminharPagina("userForm.jsp");
        }
    }

    private void alterUser() {
       

        User u = new UserDAO().getUserById(Integer.parseInt(request.getParameter("id")));

        if (u != null) {
            request.setAttribute("user", u);
            encaminharPagina("userForm.jsp");
        }
    }

    // metodo generico que sempre sera chamado para encaminhar as paginas
    private void encaminharPagina(String pagina) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro de encaminhamento = " + e);
        }
    }

}
