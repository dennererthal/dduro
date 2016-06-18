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
        <!--  <link href="../bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet"> -->

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
                                    <table class="table table-striped table-bordered table-hover" id="ocurrenceList">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Descrição</th>
                                                <th>Data</th>
                                                <th>Situação</th>
                                                <th>Editar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for(int i=0;i < 100; i++){
                                            
                                               if(i%2==0){
                                               
                                           
                                            %>
                                            <tr class="center">
                                                <td class="center"><%=i%></td>
                                                <td class="center">A vaca foi parar em cima do poste, nao sei como ex.<%= i %></td>
                                                <td class="center">10/05/2015</td>
                                                <td class="center"><button type="button" class="btn btn-outline btn-success"><i class="fa fa-check"></i> Resolvido</button></td>
                                                <td class="center"><button type="button" class="btn btn-outline btn-primary editButton" data-id="<%=i%>"><i class="fa fa-edit"> Editar</i></button></td>
                                            </tr>

                                            <% }else {%>
                                            <tr class="center">
                                                <td class="center"><%=i%></td>
                                                <td class="center">Tem um carro no telhado da casa ex.<%= i %></td>
                                                <td class="center">10/05/2015</td>
                                                <td class="center"><button type="button" class="btn btn-outline btn-warning"><i class="fa fa-warning"></i> Em aberto</button></td>
                                                <td class="center"><button type="button" class="btn btn-outline btn-primary editButton" data-id="<%=i%>" ><i class="fa fa-edit"> Editar</i> </button></td>
                                            </tr>

                                            <% } } %>

                                        </tbody>
                                    </table>
                                    <!-- The form which is used to populate the item data -->
                                    <form id="userForm" method="post" class="form-horizontal" style="display: none;">
                                        <div class="form-group">
                                            <label class="col-xs-3 control-label">ID</label>
                                            <div class="col-xs-3">
                                                <input type="text" class="form-control" name="id" disabled="disabled" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-3 control-label">Full name</label>
                                            <div class="col-xs-5">
                                                <input type="text" class="form-control" name="name" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-3 control-label">Email</label>
                                            <div class="col-xs-5">
                                                <input type="text" class="form-control" name="email" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-3 control-label">Website</label>
                                            <div class="col-xs-5">
                                                <input type="text" class="form-control" name="website" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-5 col-xs-offset-3">
                                                <button type="submit" class="btn btn-default">Save</button>
                                            </div>
                                        </div>
                                    </form>
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
            $(document).ready(function () {
                $('#ocurrenceList').DataTable({
                    responsive: true
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $('#userForm')
                        .formValidation({
                            framework: 'bootstrap',
                            icon: {
                                valid: 'glyphicon glyphicon-ok',
                                invalid: 'glyphicon glyphicon-remove',
                                validating: 'glyphicon glyphicon-refresh'
                            },
                            fields: {
                                name: {
                                    validators: {
                                        notEmpty: {
                                            message: 'The full name is required'
                                        },
                                        regexp: {
                                            regexp: /^[a-zA-Z\s]+$/,
                                            message: 'The full name can only consist of alphabetical characters'
                                        }
                                    }
                                },
                                email: {
                                    validators: {
                                        notEmpty: {
                                            message: 'The email address is required'
                                        },
                                        emailAddress: {
                                            message: 'The email address is not valid'
                                        }
                                    }
                                },
                                website: {
                                    validators: {
                                        notEmpty: {
                                            message: 'The website address is required'
                                        },
                                        uri: {
                                            allowEmptyProtocol: true,
                                            message: 'The website address is not valid'
                                        }
                                    }
                                }
                            }
                        })
                        .on('success.form.fv', function (e) {
                            // Save the form data via an Ajax request
                            e.preventDefault();

                            var $form = $(e.target),
                                    id = $form.find('[name="id"]').val();

                            // The url and method might be different in your application
                            $.ajax({
                                url: 'http://jsonplaceholder.typicode.com/users/' + id,
                                method: 'PUT',
                                data: $form.serialize()
                            }).success(function (response) {
                                // Get the cells
                                var $button = $('button[data-id="' + response.id + '"]'),
                                        $tr = $button.closest('tr'),
                                        $cells = $tr.find('td');

                                // Update the cell data
                                $cells
                                        .eq(1).html(response.id).end()
                                        .eq(2).html(response.email).end()
                                        .eq(3).html(response.website).end();

                                // Hide the dialog
                                $form.parents('.bootbox').modal('hide');

                                // You can inform the user that the data is updated successfully
                                // by highlighting the row or showing a message box
                                bootbox.alert('The user profile is updated');
                            });
                        });

                $('.editButton').on('click', function () {
                    // Get the record's ID via attribute
                    var id = $(this).attr('data-id');

                    $.ajax({
                        url: 'http://jsonplaceholder.typicode.com/users/' + id,
                        method: 'GET'
                    }).success(function (response) {
                        // Populate the form fields with the data returned from server
                        $('#userForm')
                                .find('[name="id"]').val(response.id).end()
                                .find('[name="name"]').val(response.name).end()
                                .find('[name="email"]').val(response.email).end()
                                .find('[name="website"]').val(response.website).end();

                        // Show the dialog
                        bootbox
                                .dialog({
                                    title: 'Edit the user profile',
                                    message: $('#userForm'),
                                    show: false // We will show it manually later
                                })
                                .on('shown.bs.modal', function () {
                                    $('#userForm')
                                            .show()                             // Show the login form
                                            .formValidation('resetForm'); // Reset form
                                })
                                .on('hide.bs.modal', function (e) {
                                    // Bootbox will remove the modal (including the body which contains the login form)
                                    // after hiding the modal
                                    // Therefor, we need to backup the form
                                    $('#userForm').hide().appendTo('body');
                                })
                                .modal('show');
                    });
                });
            });
        </script>

    </body>

</html>
