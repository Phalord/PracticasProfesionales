package com.standardeleven.project.logical;

import java.util.List;

public class Report {
    private String educationalExperienceNRC;
    private String educationalExperiencePeriod;
    private int projectHoursCovered;
    private int projectReportNumber;
    private int reportID;
    private List<Activity> activitiesAccomplished;

    public Report() {
        setReportID(0);
        setEducationalExperienceNRC("educationalExperienceNRC");
        setEducationalExperiencePeriod("educationalExperiencePeriod");
        setProjectHoursCovered(0);
        setProjectReportNumber(0);
        setActivitiesAccomplished(null);
    }

    public void setEducationalExperienceNRC(String educationalExperienceNRC) {
        this.educationalExperienceNRC = educationalExperienceNRC;
    }

    public void setEducationalExperiencePeriod(String educationalExperiencePeriod) {
        this.educationalExperiencePeriod = educationalExperiencePeriod;
    }

    public void setProjectHoursCovered(int projectHoursCovered) {
        this.projectHoursCovered = projectHoursCovered;
    }

    public void setProjectReportNumber(int projectReportNumber) {
        this.projectReportNumber = projectReportNumber;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setActivitiesAccomplished(List<Activity> activitiesAccomplished) {
        this.activitiesAccomplished = activitiesAccomplished;
    }

    public String getEducationalExperienceNRC() {
        return educationalExperienceNRC;
    }

    public String getEducationalExperiencePeriod() {
        return educationalExperiencePeriod;
    }

    public int getProjectHoursCovered() {
        return projectHoursCovered;
    }

    public int getProjectReportNumber() {
        return projectReportNumber;
    }

    public int getReportID() {
        return reportID;
    }

    public List<Activity> getActivitiesAccomplished() {
        return activitiesAccomplished;
    }

    @Override
    public String toString() {
        return String.format(" %d | %s | %s | %d | %d | %d ", getReportID(),
                getEducationalExperienceNRC(), getEducationalExperiencePeriod(),
                getProjectHoursCovered(), getProjectReportNumber(),getActivitiesAccomplished().size());
    }
}
