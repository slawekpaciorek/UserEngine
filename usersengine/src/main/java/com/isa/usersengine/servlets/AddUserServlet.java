package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UserDBDao;
import com.isa.usersengine.dao.UsersRepositoryDao;
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

@WebServlet("add-user")
public class AddUserServlet extends HttpServlet {

    @Inject
    UserDBDao userDBDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-user.jsp");

        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<String> usersLogins = userDBDao.getUsersFromDataBase().stream().map(x->x.getLogin()).collect(Collectors.toList());


        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        User user = new User();

        user.setAge(Integer.parseInt(age));
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);

        if(!usersLogins.contains(login))
            userDBDao.putUserToDataBase(user);
        else{
            String message = "This login is aleready registered";
            req.setAttribute("message", message);
        }


        RequestDispatcher rq = req.getRequestDispatcher("add-user.jsp");
        rq.forward(req, resp);
    }
}
