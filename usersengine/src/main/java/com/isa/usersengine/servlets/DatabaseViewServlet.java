package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UserDBDao;
import com.isa.usersengine.domain.Status;
import com.isa.usersengine.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("view-users")
public class DatabaseViewServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("database-view.jsp");

        List<User> userList = userDBDao.getUsersFromDataBase();
        List<User> activeUsers = userList.stream().filter(x->!x.getStatus().equals(Status.D)).collect(Collectors.toList());

        req.setAttribute("users", activeUsers);
        requestDispatcher.forward(req, resp);

    }
}
