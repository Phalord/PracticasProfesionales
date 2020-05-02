package com.standardeleven.project.logical;

public class Coordinator extends User{
    private String coordinatorName;
    private String coordinatorFatherSurname;
    private String coordinatorMotherSurname;

    public Coordinator(){
        super();
        setCoordinatorName("coordinatorName");
        setCoordinatorFatherSurname("coordinatorFatherSurname");
        setCoordinatorMotherSurname("coordinatorMotherSurname");
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public void setCoordinatorFatherSurname(String coordinatorFatherSurname) {
        this.coordinatorFatherSurname = coordinatorFatherSurname;
    }

    public void setCoordinatorMotherSurname(String coordinatorMotherSurname) {
        this.coordinatorMotherSurname = coordinatorMotherSurname;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public String getCoordinatorFatherSurname() {
        return coordinatorFatherSurname;
    }

    public String getCoordinatorMotherSurname() {
        return coordinatorMotherSurname;
    }

    @Override
    public String toString() {
        return String.format(" %s | %s %s %s", super.getUserName(), getCoordinatorName(),
                getCoordinatorFatherSurname(), getCoordinatorMotherSurname());
    }
}
