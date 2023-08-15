package br.com.model;

import java.time.LocalDate;
import java.util.List;

public class Empresa {
	 private List<Horario> horarios;
	 private List<Horario> marcacoes;
	 private LocalDate dataHorario;
	 private LocalDate dataMarcacao;
	 	  
	public Empresa(List<Horario> horarios, List<Horario> marcacoes) {
		this.horarios = horarios;
		this.marcacoes = marcacoes;
	}
	
	public Empresa() {
		
	}
	
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public List<Horario> getMarcacoes() {
		return marcacoes;
	}
	public void setMarcacoes(List<Horario> marcacoes) {
		this.marcacoes = marcacoes;
	}

	public LocalDate getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(LocalDate dataHorario) {
		this.dataHorario = dataHorario;
	}

	public LocalDate getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(LocalDate dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}
	
	 
	 
}
