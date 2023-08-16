package br.com.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Empresa;
import br.com.model.Horario;
import br.com.model.Jornada;

public class ControllerEmpresa {
	Empresa emp = new Empresa();
	List<Horario> horarios = new ArrayList<>();
	List<Horario> marcacoes = new ArrayList<>();
	
	public ControllerEmpresa(Empresa emp) {
		this.horarios = emp.getHorarios();
		this.marcacoes = emp.getMarcacoes();
	}

	

	public List<Horario>[] subtraiMarcacoes() {
		List<Horario> atrasos = new ArrayList<>();
		List<Horario> hExtras = new ArrayList<>();
		
		int length = 1440;
		int[] timeMap = new int[length];
		for (int i = 0; i < length; ++i) {
            timeMap[i] = 0;
        }
		
		for(Horario workTime : horarios) {
			int start = timeToMinute(workTime.getEntrada());
			int end = timeToMinute(workTime.getSaida());
			
			if(start>end)
				end += timeMap.length;
			
			for(int i=start; i<end; i++) {
				if(i>=timeMap.length) {
					timeMap[i-length] = 1;
				}else {
					timeMap[i] = 1;
				}
				
			}
		}
		
		for(Horario registro : marcacoes) {
			int start = timeToMinute(registro.getEntrada());
			int end = timeToMinute(registro.getSaida());
			
			if(start>end)
				end += timeMap.length;
			
			for(int i=start; i<end; i++) {
				if(i>=timeMap.length) {
					timeMap[i-length] += 2;
				}else {
					timeMap[i] += 2;
				}
				
			}
		}
		
		int offset = timeToMinute(marcacoes.get(0).getEntrada());
		int start = offset;
		int previous = timeMap[offset];
		
		for(int j=offset; j<offset+1441; j++) {
			int i = j;
			if(i>= timeMap.length)
				i -= 1440;
			
			if(timeMap[i] == previous)
				continue;
			
//			if(start == -1) {
//				start = i;
//				previous = timeMap[i];
//				continue;
//			}
			
			LocalTime startTime = minuteToTime(start);
			LocalTime endTime = minuteToTime(i);
			if(previous == 1) 
				atrasos.add(new Horario(startTime, endTime));
				
			
			
			if(previous == 2) 
				hExtras.add(new Horario(startTime, endTime));
				
			
			
			start = i;
			previous = timeMap[i];
		}
		
		return new List[]{atrasos, hExtras};  
        
	}
	
	protected int timeToMinute(LocalTime timeStamp) {
		return (timeStamp.getHour() * 60) + timeStamp.getMinute();

	}
	
	protected LocalTime minuteToTime(int minutes) {
		int hh = minutes/60;
		int mm = minutes%60;
		return LocalTime.of(hh, mm);
	}
	
	

}
