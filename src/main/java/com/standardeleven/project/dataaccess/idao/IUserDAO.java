package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.User;
import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserByEnrollment(String userName);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
