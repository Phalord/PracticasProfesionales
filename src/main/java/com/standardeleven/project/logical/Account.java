package com.standardeleven.project.logical;

abstract class Account {
    private String accountType;
    protected String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getAccountType() {
        return accountType;
    }

}
