
document.addEventListener("DOMContentLoaded", function() {
	
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
	    var horariosTable = document.getElementById("myTable");
	    var marcacoesTable = document.getElementById("marcacoes");
		
	    var data = {
	        horarios: [],
	        marcacoes: [],
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
	    console.log(jsonData);
	    
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
	    xhr.send(jsonData);
	
	});
 
});
