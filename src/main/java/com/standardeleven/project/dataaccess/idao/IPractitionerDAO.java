package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Practitioner;

import java.util.List;

public interface IPractitionerDAO {

    List<Practitioner> getAllPractitioners();
    Practitioner getPractitioner(int studentEnrollment);
    void updatePractitioner(Practitioner practitioner);
    void deletePractitioner(Practitioner practitioner);

}


