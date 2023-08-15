package br.com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Jornada {
	 private LocalDateTime entrada;
	 private LocalDateTime saida;

	 public Jornada(LocalDateTime entrada, LocalDateTime saida) {
        this.entrada = entrada;
        this.saida = saida;
    }
	 
	 public Jornada(LocalTime entrada, LocalTime saida) {
		 LocalDate dataAuxiliar = LocalDate.now();
		 
		 this.entrada = entrada.atDate(dataAuxiliar);
		 
		 if(entrada.isAfter(saida)) 
			 this.saida = saida.atDate(dataAuxiliar).plusDays(1);
		 
		 if(entrada.isBefore(saida)) 
			 this.saida = saida.atDate(dataAuxiliar);
	    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
}
