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


@WebServlet("check-user")
public class CheckUserServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("check-user.jsp");

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String userId = req.getParameter("id");

        User user = userDBDao.getUserFromDataBaseById(Integer.parseInt(userId));
        if(user != null){
            Stats stats = user.getStats();
            int increaseStats = stats.getNumberOfCalls() + 1;
            stats.setNumberOfCalls(increaseStats);
            user.setStats(stats);

            userDBDao.updateUserInDataBase(Integer.parseInt(userId), user);
        }
        String message = "Nie ma takiego użytkownika, wprowadź poprawny numer ID";

        req.setAttribute("message", message);
        req.setAttribute("user", user);

        RequestDispatcher rq = req.getRequestDispatcher("check-user.jsp");
        rq.forward(req, resp);

    }
}
