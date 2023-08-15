package br.com.model;

import java.time.LocalTime;

public class Horario {
	 private LocalTime entrada;
	 private LocalTime saida;

	 public Horario(LocalTime entrada, LocalTime saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }
}
