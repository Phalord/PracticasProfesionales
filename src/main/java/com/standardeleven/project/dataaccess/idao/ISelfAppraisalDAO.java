package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.SelfAppraisal;
import java.util.List;

public interface ISelfAppraisalDAO {
    List<SelfAppraisal> getAllSelfAppraisals();
    SelfAppraisal getSelfAppraisalByID(int selfappraisalID);
    void saveSelfAppraisal(SelfAppraisal selfappraisal);
    void deleteSelfAppraisal(SelfAppraisal selfappraisal);
}
