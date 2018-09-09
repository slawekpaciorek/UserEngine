package com.isa.usersengine;

import com.isa.usersengine.dao.UserDBDao;
import com.isa.usersengine.dao.UserDBDaoBean;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.Gender;
import com.isa.usersengine.domain.User;

public class Main {
    public static void main(String[] args) {

        User user = new User();

        user.setName("Slawek");
        user.setSurname("Paciorek");
        user.setLogin("slawekpaciorek");
        user.setPassword("password");
        user.setAge(33);
        user.setGender(Gender.MAN);

        UserDBDaoBean userDBDaoBean = new UserDBDaoBean();

        userDBDaoBean.putUserToDataBase(user);
    }
}