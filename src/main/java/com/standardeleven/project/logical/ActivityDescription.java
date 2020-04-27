package com.standardeleven.project.logical;

import java.io.File;
import java.util.Date;

public class ActivityDescription {
    private String activityTitle;
    private String activityDescription;
    private String professorNumberPersonal;
    private int activityID;
    private Date activityDeliveryDate;
    private File activityPresentationFormat;

    public ActivityDescription(){}

    public ActivityDescription(String activityTitle, String activityDescription, int activityID, String professorNumberPersonal, Date activityDeliveryDate, File activityPresentationFormat) {
        this.setActivityTitle(activityTitle);
        this.setActivityDescription(activityDescription);
        this.setActivityID(activityID);
        this.setProfessorNumberPersonal(professorNumberPersonal);
        this.setActivityDeliveryDate(activityDeliveryDate);
        this.setActivityPresentationFormat(activityPresentationFormat);
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setProfessorNumberPersonal(String professorNumberPersonal) {
        this.professorNumberPersonal = professorNumberPersonal;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setActivityDeliveryDate(Date activityDeliveryDate) {
        this.activityDeliveryDate = activityDeliveryDate;
    }

    public void setActivityPresentationFormat(File activityPresentationFormat) {
        this.activityPresentationFormat = activityPresentationFormat;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public String getProfessorNumberPersonal() {
        return professorNumberPersonal;
    }

    public int getActivityID() {
        return activityID;
    }

    public Date getActivityDeliveryDate() {
        return activityDeliveryDate;
    }

    public File getActivityPresentationFormat() {
        return activityPresentationFormat;
    }

    @Override
    public String toString() {
        return "ActivityDescription{" + "activityTitle=" + activityTitle + ", activityDescription=" + activityDescription + ", professorNumberPersonal=" + professorNumberPersonal + ", activityID=" + activityID + ", activityDeliveryDate=" + activityDeliveryDate + ", activityPresentationFormat=" + activityPresentationFormat + '}';
    }
}
