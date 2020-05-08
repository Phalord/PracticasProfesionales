package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Activity;
import java.util.List;

public interface IActivityDAO {
    List<Activity> getAllActivities();
    List<Activity> getAllActivitiesByReportID(int reportID);
    Activity getActivityByID(int activityID);
    boolean addActivity(Activity activity);
    boolean deleteActivity(Activity activity);
}
