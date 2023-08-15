<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Controle de ponto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .fixed-header {
            position: sticky;
            top: 0;
            background-color: white;
        }
        .table-container {
            border: 1px solid #dee2e6;
            border-radius: 6px;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 10px;
        }
        .table-container h3 {
            margin-bottom: 10px;
        }
        .table-responsive {
            overflow-x: auto;
        }
        .btn-margin {
            margin-top: 10px;
        }
        .table-buttons {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 15px;
        }
        .table-responsive {
		    max-height:314px;
		}
        
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="table-container">
                    <h3>Horário de trabalho</h3>
                    <div class="table-responsive">
                    	<input id="DataHorario" type="date" class="form-control" step="300">
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
                    	<input id="DataMarcacao"type="date" class="form-control" step="300">
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
    <script>
    	document.getElementById("addRowButton").addEventListener("click", function() {
        var marcacoes = document.getElementById("marcacoes");
        var newRow = marcacoes.insertRow(-1);

        var inputCell1 = newRow.insertCell(0);
        var input1 = document.createElement("input");
        input1.type = "time";
        input1.className = "form-control";
        input1.step = 300; 
        inputCell1.appendChild(input1);

        var inputCell2 = newRow.insertCell(1);
        var input2 = document.createElement("input");
        input2.type = "time";
        input2.className = "form-control";
        input2.step = 300; 
        inputCell2.appendChild(input2);
    });

    document.getElementById("submitButton").addEventListener("click", function() {
    	var dataHorario = document.getElementById("DataHorario").value;
    	var dataMarcacao = document.getElementById("DataMarcacao").querySelector("input");
    	console.log(dataHorario);
    	console.log(dataMarcacao);
        var horariosTable = document.getElementById("myTable");
        var marcacoesTable = document.getElementById("marcacoes");
        var date = {
                horario: [],
                marcacao: []
            };
        date.horario.push({
        	data: dataHorario
        });
        date.marcacao.push({
        	data: dataMarcacao
        });
		
        var data = {
            horarios: [],
            marcacoes: []
        };

        // Preenche a lista de horários
        for (var i = 1; i < horariosTable.rows.length; i++) {
            var entradaInput = horariosTable.rows[i].cells[0].querySelector("input");
            var saidaInput = horariosTable.rows[i].cells[1].querySelector("input");

            if (entradaInput.value.trim() !== "" && saidaInput.value.trim() !== "") {
                data.horarios.push({
                    entrada: entradaInput.value,
                    saida: saidaInput.value
                });
            }
        }

        // Preenche a lista de marcações
        for (var j = 1; j < marcacoesTable.rows.length; j++) {
            var entradaInputMarcacoes = marcacoesTable.rows[j].cells[0].querySelector("input");
            var saidaInputMarcacoes = marcacoesTable.rows[j].cells[1].querySelector("input");

            if (entradaInputMarcacoes.value.trim() !== "" && saidaInputMarcacoes.value.trim() !== "") {
                data.marcacoes.push({
                    entrada: entradaInputMarcacoes.value,
                    saida: saidaInputMarcacoes.value
                });
            }
        }

        var jsonData = JSON.stringify(data);
        
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/ponto/registro", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log("Dados enviados com sucesso!");
                    var horasExtrasTable = document.getElementById("horasExtrasTable");
                    var horasExtrasBody = horasExtrasTable.getElementsByTagName("tbody")[0];
                    
                    var atrasosTable = document.getElementById("atrasosTable");
                    var atrasosBody = atrasosTable.getElementsByTagName("tbody")[0];

                    var response = JSON.parse(xhr.responseText);
                    var hExtras = response.hExtras;
                    var atrasos = response.atrasos;

                    // Limpe as linhas existentes
                    horasExtrasBody.innerHTML = "";
                    atrasosBody.innerHTML = "";
                    
                    
                    // Preencha a tabela com os dados de hExtras
                    hExtras.forEach(function(horaExtra) {
                        var newRow = horasExtrasBody.insertRow();
                        var entradaCell = newRow.insertCell(0);
                        var saidaCell = newRow.insertCell(1);
                        var entradaValue = horaExtra.entrada === "24:00" ? "00:00" : horaExtra.entrada;
                        var saidaValue = horaExtra.saida === "24:00" ? "00:00" : horaExtra.saida;

                        entradaCell.textContent = entradaValue;
                        saidaCell.textContent = saidaValue;
                    });
                    
                    atrasos.forEach(function(atraso){
                    	var newRow = atrasosBody.insertRow();
                    	var entradaCell = newRow.insertCell(0);
                    	var saidaCell = newRow.insertCell(1);
                    	var entradaValue = atraso.entrada === "24:00" ? "00:00" : atraso.entrada;
                        var saidaValue = atraso.saida === "24:00" ? "00:00" : atraso.saida;

                        entradaCell.textContent = entradaValue;
                        saidaCell.textContent = saidaValue;
                    });
                    
                    
                    
                } else {
                    console.error("Erro ao enviar os dados: ", xhr.statusText);
                }
            }
        };
        const dateS = JSON.stringify(date);
        const jsonS = {jsonData, dateS};
        console.log(jsonS);
        xhr.send(JSON.stringify(jsonS));

    });
    </script>
</body>
</html>
