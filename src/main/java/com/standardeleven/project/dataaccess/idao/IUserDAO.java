package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.User;
import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserByEnrollment(String userName);
    void addUser(String enrollment, String password);
    void saveUser(User user);
    void deleteUser(User user);
}
