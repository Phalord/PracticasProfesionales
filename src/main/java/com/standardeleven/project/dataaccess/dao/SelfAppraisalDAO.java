package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.logical.SelfAppraisal;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.standardeleven.project.dataaccess.idao.ISelfAppraisalDAO;

public class SelfAppraisalDAO implements ISelfAppraisalDAO{
    private final MySQLConnection mySQLConnection;
    private List<SelfAppraisal> selfAppraisals;
    private ResultSet resultQuery;
    final String INSERT = "INSERT INTO Autoevaluacion(idAutoevaluacion, archivoAutoevaluacion, Matricula) VALUES (?, ?, ?)";
    final String GETALL = "SELECT idAutoevaluacion, archivoAutoevaluacion, Matricula FROM Autoevaluacion"; 
    final String GETONE = "SELECT idAutoevaluacion, archivoAutoevaluacion, Matricula FROM Autoevaluacion WHERE idAutoevaluacion = ?";
    final String DELETE = "DELETE FROM Autoevaluacion WHERE idAutoevaluacion = ?";

    public SelfAppraisalDAO() {
        mySQLConnection = new MySQLConnection();
    }
    
    @Override
    public List<SelfAppraisal> getAllSelfAppraisals() {
        SelfAppraisal selfAppraisal;
        try(Connection connect = mySQLConnection.getConnection()){
            PreparedStatement sentence = connect.prepareStatement(GETALL);
            resultQuery = sentence.executeQuery();
            while(resultQuery.next()){
                selfAppraisal = new SelfAppraisal();
                selfAppraisal.setSelfappraisalID(resultQuery.getInt("idAutoevaluacion"));
                selfAppraisal.setSelfappraisalFile((File)resultQuery.getObject("archivoAutoevaluacion"));
                selfAppraisal.setStudentEnrollment(resultQuery.getString("Matricula"));
                selfAppraisals.add(selfAppraisal);
            }
        } catch(SQLException exception){
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, null, exception);
        }
        return selfAppraisals;
    }

    @Override
    public SelfAppraisal getSelfAppraisalByID(int selfappraisalID) {
        SelfAppraisal selfAppraisal = null;
        try(Connection connect = mySQLConnection.getConnection()){
            PreparedStatement sentence = connect.prepareStatement(GETONE);
            sentence.setInt(1, selfappraisalID);
            resultQuery = sentence.executeQuery();
            while(resultQuery.next()){
                selfAppraisal = new SelfAppraisal();
                selfAppraisal.setSelfappraisalID(resultQuery.getInt("idAutoevaluacion"));
                selfAppraisal.setSelfappraisalFile((File)resultQuery.getObject("archivoAutoevaluacion"));
                selfAppraisal.setStudentEnrollment(resultQuery.getString("Matricula"));
            }
        } catch(SQLException exception){
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, null, exception);
        }
        return selfAppraisal;
    }

    @Override
    public void saveSelfAppraisal(SelfAppraisal selfappraisal) {
        try(Connection connect = mySQLConnection.getConnection()){
            PreparedStatement sentence = connect.prepareStatement(INSERT);
            sentence.setInt(1, selfappraisal.getSelfappraisalID());
            sentence.setObject(2, selfappraisal.getSelfappraisalFile());
            sentence.setString(3, selfappraisal.getStudentEnrollment());
            sentence.execute();
            if(sentence.executeUpdate() == 0){
               System.out.println("Puede que no se haya ingresado el registro");
            } else {
               System.out.println("Se ha ingresado el registro correctamente");
            }
            sentence.close();
        } catch (SQLException exception){
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @Override
    public void deleteSelfAppraisal(SelfAppraisal selfappraisal) {
        try(Connection connect = mySQLConnection.getConnection()){
            PreparedStatement sentence = connect.prepareStatement(DELETE);
            sentence.setInt(1, selfappraisal.getSelfappraisalID());
            sentence.execute();
            if(sentence.executeUpdate() == 0){
               System.out.println("Puede que no se haya borrado el registro");
            } else {
               System.out.println("Se ha borrado el registro correctamente");
            }
            sentence.close();
        } catch (SQLException exception){
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
