package br.com.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Empresa;
import br.com.model.Horario;
import br.com.model.Jornada;

public class ControllerEmpresa {
	Empresa emp = new Empresa();
	List<Jornada> horarios = new ArrayList<>();
	List<Jornada> marcacoes = new ArrayList<>();
	
	public ControllerEmpresa(Empresa emp) {
		this.emp.setHorarios(emp.getHorarios());
		this.emp.setMarcacoes(emp.getMarcacoes());
		setHorarios();
	}

	
	
//	List<Jornada> horarios  = converteHorario(emp.getHorarios());
//	List<Jornada> marcacoes = converteHorario(emp.getMarcacoes());
	public List<Horario>[] subtraiMarcacoes() {
		List<Horario> atrasos = new ArrayList<>();
		List<Horario> hExtras = new ArrayList<>();
        List<Jornada> mAntigas = new ArrayList<>();
		int flag = 0;
        
        for (Jornada horario : horarios) {
        	for(int i=0; i<marcacoes.size(); i++) {
        		LocalDateTime entrada = marcacoes.get(i).getEntrada();
        		LocalDateTime saida = marcacoes.get(i).getSaida();
        		
        		if(entrada.isAfter(horario.getEntrada())) {	
        			atrasos.add(new Horario(horario.getEntrada().toLocalTime(), entrada.toLocalTime()));
        			hExtras.addAll(verificaHoraExtra(saida, horario.getSaida(), flag, horarios));
        			
        			if(saida.isBefore(horario.getSaida())) {
        				atrasos.add(new Horario(saida.toLocalTime(), horario.getSaida().toLocalTime()));
        			}
        		}
        		
        		if(entrada.isBefore(horario.getEntrada())) {
        			hExtras.add(new Horario(entrada.toLocalTime(), horario.getEntrada().toLocalTime()));
        			
        			hExtras.addAll(verificaHoraExtra(saida, horario.getSaida(), flag, horarios));
        			
        			
        			if(saida.isBefore(horario.getSaida())) {
        				atrasos.add(new Horario(saida.toLocalTime(), horario.getSaida().toLocalTime()));
        			}
        			
        		}
        		
        		if(entrada.equals(horario.getEntrada())) {
        			
        			hExtras.addAll(verificaHoraExtra(saida, horario.getSaida(), flag, horarios));
        			
        			if(saida.isBefore(horario.getSaida())) {
        				atrasos.add(new Horario(saida.toLocalTime(), horario.getSaida().toLocalTime()));
        			}
        			
        		}
        		mAntigas.add(marcacoes.get(i));
        		marcacoes.remove(i);
        		
        		
        	}
        	
		}
        LocalDateTime ultimaSaida = mAntigas.get(mAntigas.size()-1).getSaida();
        LocalDateTime ultimoHorarioEntrada = horarios.get(horarios.size()-1).getEntrada();
        LocalDateTime ultimoHorarioSaida = horarios.get(horarios.size()-1).getSaida();
        
        if(ultimaSaida.isBefore(ultimoHorarioEntrada) || ultimaSaida.equals(ultimoHorarioEntrada) )  	
        	atrasos.add(new Horario(ultimoHorarioEntrada.toLocalTime(), ultimoHorarioSaida.toLocalTime()));
        
//		adiciona as marcações restantes como horas extras
        marcacoes.forEach(m->hExtras.add(new Horario(m.getEntrada().toLocalTime(), m.getSaida().toLocalTime())));
        
        return new List[]{atrasos, hExtras};
        
	}
	
	protected List<Horario> verificaHoraExtra(LocalDateTime saidaMarcacao, LocalDateTime saidaHorario, int flag, List<Jornada> horarios) {
		List<Horario> hExtras = new ArrayList<>();
		
		if(saidaMarcacao.isAfter(saidaHorario)) {
			if(flag == horarios.size()-1) {
				hExtras.add(new Horario(saidaHorario.toLocalTime(), saidaMarcacao.toLocalTime()));
			}
			if(flag < horarios.size()-1) {
//		    adiciona a hora extra equivalente do final do primeiro periodo até o começo da próxima
				hExtras.add(new Horario(saidaHorario.toLocalTime() , horarios.get(flag+1).getEntrada().toLocalTime()));
				
				hExtras.addAll(verificaHoraExtra(saidaMarcacao, horarios.get(flag+1).getSaida(), flag+1, horarios));
			}
		
		}
		
		return hExtras;
		
		
	}
	
	protected List<Jornada> converteHorario(List<Horario> horarios){
		List<Jornada> jornadas = new ArrayList<>();
		horarios.forEach(h -> {
			jornadas.add(new Jornada(h.getEntrada(), h.getSaida()));
		});
		return jornadas;
	}
	
	protected List<Horario> converteJornada(List<Jornada> jornadas){
		List<Horario> horarios = new ArrayList<>();
		jornadas.forEach(j -> {
			horarios.add(new Horario(j.getEntrada().toLocalTime(), j.getSaida().toLocalTime()));
		});
		return horarios;
		
	}
	
	protected void setHorarios(){
		if(!emp.getHorarios().isEmpty())
			horarios.addAll(converteHorario(emp.getHorarios()));
		
		if(!emp.getMarcacoes().isEmpty())
		    marcacoes.addAll(converteHorario(emp.getMarcacoes()));
	}

}
