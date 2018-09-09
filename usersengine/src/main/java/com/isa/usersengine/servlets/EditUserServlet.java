package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UserDBDao;
import com.isa.usersengine.dao.UserDBDaoBean;
import com.isa.usersengine.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("edit-user")
public class EditUserServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    private static String idValue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-user.jsp");
        idValue = req.getParameter("idValue");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));

        userDBDao.updateUserInDataBase(Integer.parseInt(idValue), user);

        resp.sendRedirect("view-users");

    }
}
