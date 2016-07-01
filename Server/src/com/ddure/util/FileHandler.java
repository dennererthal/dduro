/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author denner
 */
public class FileHandler {
    public static void persist( InputStream in, String filename ) {
        try {
            OutputStream out = new FileOutputStream(System.getProperty("user.home") + File.separator + "ddure" + File.separator + filename + ".png");
            IOUtils.copy(in, out); //The function is below
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static File obtain( String filename ) {
        return new File( System.getProperty("user.home") + File.separator + "ddure" + File.separator + filename + ".png" );
    }
}
