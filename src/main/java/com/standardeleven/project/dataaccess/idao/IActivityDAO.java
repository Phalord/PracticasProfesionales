package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Activity;
import java.util.List;

public interface IActivityDAO {
    List<Activity> getAllActivityDescription();
    Activity getActivityDescriptionByID(int idActivity);
    void addActivity(Activity activity);
    void deleteActivity0(Activity activity);
}
