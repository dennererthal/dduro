<%-- 
    Document   : navbar
    Created on : 08/05/2016, 19:46:43
    Author     : herykgasparini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   // Get last access time of this web page.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String userIDKey = new String("userID");
   String userID = new String("ABCD");

   // Check if this is new comer on your web page.
   if (session.isNew()){
      session.setAttribute(userIDKey, userID);
   } 
   userID = (String)session.getAttribute(userIDKey);
%>
<!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="occurrenceList.jsp"> D-Duro Web </a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> Usuário <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="userForm.jsp"><i class="fa fa-gear fa-fw"></i> Preferências </a>
            </li>
            <li class="divider"></li>
            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout </a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
               
                <li>
                    <a href="occurrenceList.jsp"><i class="fa fa-list fa-fw"></i> Ocorrências </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-users fa-fw"></i> Usuários <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="userForm.jsp"><i class="fa fa-plus fa-fw"></i> Cadastro de usuários </a>
                        </li>
                        <li>
                            <a href="userList.jsp"><i class="fa fa-list fa-fw"></i> Lista de usuários </a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
              
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
    </nav>