package com.standardeleven.project.logical;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {
    private int activityID;
    private int projectID;
    private int estimatedCompletionHours;
    private int actualCompletionHours;
    private String activityTitle;
    private String studentEnrollment;
    private String activityDescription;
    private Date activityDeliveryDate;
    private boolean activityStatus;

    public Activity(){
        setActivityID(0);
        setProjectID(0);
        setEstimatedCompletionHours(0);
        setActualCompletionHours(0);
        setActivityTitle("activityTitle");
        setStudentEnrollment("studentEnrollment");
        setActivityDescription("ActivityDescription");
        setActivityDeliveryDate(null);
        setActivityStatus(false);
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setEstimatedCompletionHours(int estimatedCompletionHours) {
        this.estimatedCompletionHours = estimatedCompletionHours;
    }

    public void setActualCompletionHours(int actualCompletionHours) {
        this.actualCompletionHours = actualCompletionHours;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setActivityDeliveryDate(Date activityDeliveryDate) {
        this.activityDeliveryDate = activityDeliveryDate;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getEstimatedCompletionHours() {
        return estimatedCompletionHours;
    }

    public int getActualCompletionHours() {
        return actualCompletionHours;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public int getActivityID() {
        return activityID;
    }

    public Date getActivityDeliveryDate() {
        return activityDeliveryDate;
    }

    public boolean getActivityStatus() {
        return activityStatus;
    }

    @Override
    public String toString() {
        return String.format(" %d | %s | %d | %d | %d | %s | %s | %s", getActivityID(), getActivityTitle(),
                getProjectID(), getEstimatedCompletionHours(), getActualCompletionHours(), getStudentEnrollment(),
                getActivityDescription(), getDateFormat());
    }

    private String getDateFormat() {
        String result = "No done, yet";
        if (getActivityDeliveryDate() != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
            return dateFormat.format(getActivityDeliveryDate());
        }
        return result;
    }
}
