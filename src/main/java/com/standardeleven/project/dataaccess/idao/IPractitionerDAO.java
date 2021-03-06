package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Practitioner;

import java.util.List;

public interface IPractitionerDAO {

    List<Practitioner> getAllPractitioners();
    Practitioner getPractitioner(String studentEnrollment);
    boolean addPractitioner(Practitioner practitioner);
    boolean deletePractitioner(Practitioner practitioner);

}


