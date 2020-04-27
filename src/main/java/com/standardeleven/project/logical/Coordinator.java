package com.standardeleven.project.logical;

public class Coordinator {
    private String coordinatorFullName;
    private String coordinatorNumberPersonal;

    public Coordinator(){}
    
    public Coordinator(String coordinatorNumberPersonal, String coordinatorFullName) {
        this.setCoordinatorFullName(coordinatorFullName);
        this.setCoordinatorNumberPersonal(coordinatorNumberPersonal);
    }

    public String getCoordinatorFullName() {
        return coordinatorFullName;
    }

    public String getCoordinatorNumberPersonal() {
        return coordinatorNumberPersonal;
    }

    public void setCoordinatorFullName(String coordinatorFullName) {
        this.coordinatorFullName = coordinatorFullName;
    }

    public void setCoordinatorNumberPersonal(String coordinatorNumberPersonal) {
        this.coordinatorNumberPersonal = coordinatorNumberPersonal;
    }

    @Override
    public String toString() {
        return "Coordinator{" + "coordinatorFullName=" + coordinatorFullName + ", coordinatorNumberPersonal=" + coordinatorNumberPersonal + '}';
    }
}
