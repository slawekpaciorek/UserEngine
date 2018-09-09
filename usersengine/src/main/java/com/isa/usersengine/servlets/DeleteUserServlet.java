package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UserDBDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("delete-user")
public class DeleteUserServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idValue = req.getParameter("idValue");

        userDBDao.removeUserFromDataBaseById(Integer.parseInt(idValue));

        resp.sendRedirect("view-users");

    }
}
