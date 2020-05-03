package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Activity;
import java.util.List;

public interface IActivityDAO {
    List<Activity> getAllActivities();
    Activity getActivityByID(int idActivity);
    boolean addActivity(Activity activity);
    boolean deleteActivity(Activity activity);
}
