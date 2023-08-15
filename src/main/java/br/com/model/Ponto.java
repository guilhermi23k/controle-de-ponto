package br.com.model;

import java.util.List;

public class Ponto {
	private List<Horario> atrasos;
	private List<Horario> hExtras;
	
	
	
	public Ponto(List<Horario> atrasos, List<Horario> hExtras) {
		this.atrasos = atrasos;
		this.hExtras = hExtras;
	}
	
	public List<Horario> getAtrasos() {
		return atrasos;
	}
	public void setAtrasos(List<Horario> atrasos) {
		this.atrasos = atrasos;
	}
	public List<Horario> gethExtras() {
		return hExtras;
	}
	public void sethExtras(List<Horario> hExtras) {
		this.hExtras = hExtras;
	}
	
	
	
}
