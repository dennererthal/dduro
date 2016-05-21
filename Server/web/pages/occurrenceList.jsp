<%-- 
    Document   : occurence
    Created on : 06/05/2016, 21:17:47
    Author     : herykgasparini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>D-Duro Web - Ocorrências</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
        <%@include file="navbar.jsp" %>
        <%@include file="modal.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Lista de ocorrências
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body"> 
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Descrição</th>
                                            <th>Data</th>
                                            <th>Situação</th>
                                            <th>Detalhes</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(int i=0;i < 100; i++){
                                            
                                           if(i%2==0){
                                               
                                           
                                        %>
                                        <tr class="center">
                                            <td class="center"><button type="button" class="btn btn-outline btn-primary"><i class="fa fa-chevron-right"></i></button></td>
                                            <td>A vaca morreu v.<%= i %>!</td>
                                            <td class="center">10/05/2015</td>
                                            <td class="center"><button type="button" class="btn btn-outline btn-success"><i class="fa fa-check"></i> Resolvido</button></td>
                                            <td class="center"><button type="button" class="btn btn-outline btn-primary" data-toggle="modal" data-target="#myModal"><i class="fa fa-eye"></i> Vizualizar</button></td>
                                        </tr>
                                        
                                       <% }else {%>
                                       <tr class="center">
                                            <td class="center"><button type="button" class="btn btn-outline btn-primary"><i class="fa fa-chevron-right"></i></button></td>
                                            <td>A vaca morreu v.<%= i %>!</td>
                                            <td class="center">10/05/2015</td>
                                            <td class="center"><button type="button" class="btn btn-outline btn-danger">Resolver</button></td>
                                            <td class="center"><button type="button" class="btn btn-outline btn-primary" data-toggle="modal" data-target="#myModal"><i class="fa fa-eye"></i> Vizualizar</button></td>
                                        </tr>
                                        
                                        <% } } %>
                                     
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                      
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>
