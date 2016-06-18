<%-- 
    Document   : userForm
    Created on : 09/05/2016, 19:34:02
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
        <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                                Cadastro de Usuário
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>Nome (*)</label>
                                        <input type="text" class="form-control" id="name" name="name" placeholder="Digite o nome">
                                    </div>

                                    <div class="form-group">
                                        <label>CPF (*)</label>
                                        <input type="text" class="form-control" id="cpf" name="cpf" placeholder="Digite o CPF">
                                    </div>

                                    <div class="form-group">
                                        <label>E-mail (*)</label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="Digite o e-mail">
                                    </div>

                                    <div class="form-group">
                                        <label>Situação </label>
                                        <select class="form-control">
                                            <option id="status" name="status" selected="true">Ativo</option>
                                            <option id="status" name="status">Administrador</option>
                                            <option id="status" name="status">Inativo</option>
                                        </select>
                                    </div>

                                    <div class="alert alert-info">
                                        Não digite a senha para manter a anterior. 
                                    </div>


                                    <div class="form-group">
                                        <label>Senha </label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Digite a senha">
                                    </div>

                                    <div class="form-group">
                                        <label>Confirmação Senha </label>
                                        <input type="password" class="form-control" id="repassword" name="repassword" placeholder="Digite a confirmção da senha">
                                    </div>
                                </div>

                            </div>
                            <!-- /.panel-body -->
                            <div class="panel-footer">
                                <a type="button" href="userList.jsp" class="btn btn-default"><i class="fa fa-search"></i> Listar</a>
                                <button type="button" class="btn btn-default"><i class="fa fa-save"></i> Salvar</button>
                            </div>
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
        <script src="bower_components/jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

        <!-- DataTables JavaScript -->
        <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="dist/js/sb-admin-2.js"></script>
        <script src="dist/js/jquery.inputmask.bundle.js"></script>
        <script src="dist/js/utils.js"></script>

    </body>

</html>