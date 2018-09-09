package com.isa.usersengine.dao;

import com.isa.usersengine.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDBDao {

    User getUserFromDataBaseById(int id);

    void putUserToDataBase(User user);

    void removeUserFromDataBaseById(int id);

    List<User> getUsersFromDataBase();

    void updateUserInDataBase(int id, User user);

}
