package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.ActivityDescription;
import java.util.List;

public interface IActivityDescripcionDAO {
    List<ActivityDescription> getAllActivityDescription();
    ActivityDescription getActivityDescriptionByID(int idActivity);
    void saveActivityDescription(ActivityDescription activityDescription);
    void deleteActivityDescription(ActivityDescription activityDescription);
}
