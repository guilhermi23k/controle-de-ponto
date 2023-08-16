<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Controle de ponto</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<link href="css/home.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	    <div class="container">
	        <div class="row">
	            <div class="col-md-6">
	                <div class="table-container">
	                    <h3>Horário de trabalho</h3>
	                    <div class="table-responsive">
	                        <table id="myTable" class="table table-striped table-hover ">
	                            <thead>
	                                <tr>
	                                    <th scope="col">Entrada</th>
	                                    <th scope="col">Saida</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                </tr>
	                                <tr>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                </tr>
	                                <tr>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	                    <div class="table-buttons">
	                        <button id="addRowButton" type="button" class="btn btn-primary">Adicionar nova marcação</button>
	                        <button id="submitButton" type="button" class="btn btn-success">Enviar</button>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-6">
	                <div class="table-container">
	                    <div class="fixed-header">
	                        <h3>Marcações</h3>
	                    </div>
	                    <div class="table-responsive">
	                        <table id="marcacoes" class="table table-striped table-hover table-responsive">
	                            <thead>
	                                <tr>
	                                    <th scope="col">Entrada</th>
	                                    <th scope="col">Saida</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                    <td><input type="time" class="form-control" placeholder="HH:MM" step="300"></td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row" style="margin-top: 5%;">
	            <div class="col-md-6 ">
	                <div class="table-container">
	                    <h3>Horas Extras</h3>
	                    <div class="table-responsive">
	                        <table id="horasExtrasTable" class="table table-striped table-hover table-responsive">
	                            <thead>
				                    <tr>
				                        <th scope="col">Entrada</th>
				                        <th scope="col">Saida</th>
				                    </tr>
				                </thead>
				                <tbody>
				                        
				                </tbody>
	                        </table> 
	                    </div>
	                    
	                </div>
	            </div>
	            <div class="col-md-6">
	                <div class="table-container">
	                    <div class="fixed-header">
	                        <h3>Atrasos</h3>
	                    </div>
	                    <div class="table-responsive">
	                        <table id="atrasosTable" class="table table-striped table-hover table-responsive">
	                            <thead>
	                                <tr>
	                                    <th scope="col">Entrada</th>
	                                    <th scope="col">Saida</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	    <script src="js/home.js"></script>
	</body>
</html>
