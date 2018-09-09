package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UserDBDao;
import com.isa.usersengine.domain.Stats;
import com.isa.usersengine.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("statistic")
public class StatisticViewServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("html/text;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("statistic-view.jsp");

        List<User> userList = userDBDao.getUsersFromDataBase();
        req.setAttribute("users", userList);
        requestDispatcher.forward(req, resp);

    }
}
