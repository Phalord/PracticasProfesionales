package com.standardeleven.project.dataaccess.idao;

public interface IAccountDAO {

    boolean logIn(String username, String password);
    String getAccountType(String username);

}
