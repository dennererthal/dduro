/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.servlet;

import com.ddure.data.Location;
import com.ddure.data.Occurrence;
import com.ddure.db.Database;
import com.ddure.db.dao.LocationDAO;
import com.ddure.db.dao.OccurrenceDAO;
import com.ddure.util.FileHandler;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denner
 */
@WebServlet("/OccurrenceServlet")
@MultipartConfig
public class OccurrenceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter( "action" );
        
        if ( action != null && action.equals( "post" ) ) {
            InputStream in = req.getPart("occurrenceImage").getInputStream();
            String userId = req.getParameter( "userId" );
            String lat = req.getParameter( "locationLat" );
            String lon = req.getParameter( "locationLon" );
            String description = req.getParameter( "description" );
            
            Location location = new Location();
            location.setLat( lat );
            location.setLon( lon );
            
            LocationDAO.insertLocation( location );
            
            Occurrence occurrence = new Occurrence();
            occurrence.setDate( new Date(System.currentTimeMillis()) );
            occurrence.setDescription( description );
            occurrence.setImage( "" );
            occurrence.setRef_user( Integer.valueOf( userId ) );
            occurrence.setStatus( 'A' );
            occurrence.setRef_location( location.getId() );
            
            if ( OccurrenceDAO.insertOccurrence( occurrence ) ) {
                occurrence.setImage(String.valueOf(occurrence.getId()));
                FileHandler.persist(in, String.valueOf(occurrence.getId()));
                OccurrenceDAO.updateOccurrence(occurrence);
            }
        }
        
        else {
            String json = new Gson().toJson(OccurrenceDAO.getOccurrences());

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }
    
}
