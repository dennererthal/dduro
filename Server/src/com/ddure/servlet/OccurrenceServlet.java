/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dduro.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author denner
 */
@WebServlet("/OccurrenceServlet")
@MultipartConfig
public class OccurrenceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = req.getPart("occurrenceImage").getInputStream();
        OutputStream out = new FileOutputStream(System.getProperty("user.home") + File.separator + "myfile.jpg");
        IOUtils.copy(in, out); //The function is below
        out.flush();
        out.close();
    }
    
}
