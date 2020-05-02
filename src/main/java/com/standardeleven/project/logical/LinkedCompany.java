package com.standardeleven.project.logical;

public class LinkedCompany {
    private String companyName;
    private String companyAddress;
    private String companyCity;
    private String companyState;
    private String companySector;
    private String companyEmail;
    private int companyPhone;

    public LinkedCompany(){}

    public LinkedCompany(String companyName, String companyAddress, String companyCity, String companyState, String companySector, String companyEmail, int companyPhone) {
        setCompanyName(companyName);
        setCompanyAddress(companyAddress);
        setCompanyCity(companyCity);
        setCompanyState(companyState);
        setCompanySector(companySector);
        setCompanyEmail(companyEmail);
        setCompanyPhone(companyPhone);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public String getCompanyState() {
        return companyState;
    }

    public String getCompanySector() {
        return companySector;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public int getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setCompanyPhone(int companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Override
    public String toString() {
        return "LinkedCompany{" + "companyName=" + companyName + ", companyAddress=" + companyAddress + ", companyCity=" + companyCity + ", companyState=" + companyState + ", companySector=" + companySector + ", companyEmail=" + companyEmail + ", companyPhone=" + companyPhone + '}';
    }
}
