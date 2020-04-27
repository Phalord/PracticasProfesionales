package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Project;

import java.util.List;

public interface IPractitionerDAO {

    List<Practitioner> getAllPractitioners();
    Practitioner getPractitioner(String studentEnrollment);

}


