package br.com.model;

import java.time.LocalDate;
import java.util.List;

public class Empresa {
	 private List<Horario> horarios;
	 private List<Horario> marcacoes;
	 	  
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

	
	 
	 
}
