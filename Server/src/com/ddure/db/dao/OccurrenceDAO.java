/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.db.dao;

import com.ddure.data.Occurrence;
import com.ddure.db.Database;
import com.ddure.schema.OccurrenceTable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class OccurrenceDAO {
    public boolean insertOccurrence(Occurrence occurrence) {
        Database db = Database.getInstance();
        try {
            String sql = "insert into " + OccurrenceTable.name + " "
                    + "(" + OccurrenceTable.Columns.id + ","
                    + OccurrenceTable.Columns.ref_user + " ,"
                    + OccurrenceTable.Columns.ref_location + " ,"
                    + OccurrenceTable.Columns.description + " ,"
                    + OccurrenceTable.Columns.date + " ,"
                    + OccurrenceTable.Columns.image + " ,"
                    + OccurrenceTable.Columns.status + " )"
                    + " values "
                    + "(default,"
                    + occurrence.getRef_user() + ","
                    + occurrence.getRef_location() + ","
                    + "'" + occurrence.getDescription() + "',"
                    + "'" + occurrence.getDate() + "',"
                    + "'" + occurrence.getImage() + "',"
                    + "'" + occurrence.getStatus() + "')";
            db.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Erro ao inserir occurrence = " + e);
            return false;
        } finally {
            db.release();
        }
        return true;
    }
            
    public boolean updateOccurrence(Occurrence occurrence) {
        Database db = Database.getInstance();
        try {
            String sql = "update " + OccurrenceTable.name + " set "
                    + OccurrenceTable.Columns.ref_user + " = " + occurrence.getRef_user() + ", "
                    + OccurrenceTable.Columns.ref_location + " = " + occurrence.getRef_location() + ", "
                    + OccurrenceTable.Columns.description + " = '" + occurrence.getDescription() + "', "
                    + OccurrenceTable.Columns.date + " = '" + occurrence.getDate() + "', "
                    + OccurrenceTable.Columns.image + " = '" + occurrence.getImage() + "', "
                    + OccurrenceTable.Columns.status + " = '" + occurrence.getStatus() + "' "
                    + "where " + OccurrenceTable.Columns.id + " = " + occurrence.getId() + " ";

            db.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Erro ao alterar occurrency = " + e);
            return false;
        } finally {
            db.release();
        }
        return true;
    }

    public Occurrence getOccurrenceById(int id) {
        Database db = Database.getInstance();
        try {
            return OccurrenceTable.fetchOne( db.executeQuery(OccurrenceTable.select + " where " + OccurrenceTable.Columns.id + " = " + id) );
        } catch (SQLException e) {
            System.out.println("Erro ao buscar occurrence = " + e);
            return null;
        } finally {
            db.release();
        }
    }

    public Occurrence getOccurrenceByUser(int refUser) {
        Database db = Database.getInstance();
        try {
            return OccurrenceTable.fetchOne( db.executeQuery(OccurrenceTable.select + " where " + OccurrenceTable.Columns.ref_user + " = " + refUser) );
        } catch (SQLException e) {
            System.out.println("Erro ao buscar occurrence = " + e);
            return null;
        } finally {
            db.release();
        }
    }
     
    public List<Occurrence> getOccurrences() {
        Database db = Database.getInstance();
        try {
            return OccurrenceTable.fetchMany(db.executeQuery(OccurrenceTable.select + " order by " + OccurrenceTable.Columns.id) );
        } catch (SQLException e) {
            System.out.println("Erro ao buscar occurrence = " + e);
            return null;
        } finally {
            db.release();
        }
    }

    public boolean excluirOccurrency(int id) {
        Database db = Database.getInstance();
        try {
            db.executeUpdate("delete from " + OccurrenceTable.name + " where " + OccurrenceTable.Columns.id + " = " + id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir = " + e);
            return false;
        }
        return true;
    }
    
}