package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Practitioner;
import java.sql.Connection;
import java.util.List;
import javafx.collections.ObservableList;

public interface IPractitionerDAO {

    List<Practitioner> getAllPractitioners();
    Practitioner getPractitioner(String studentEnrollment);
    boolean addPractitioner(Practitioner practitioner);
    boolean deletePractitioner(Practitioner practitioner);
    void fillPractitionerTable(Connection mySQLConnection, ObservableList<Practitioner> listPractitioner);

}


