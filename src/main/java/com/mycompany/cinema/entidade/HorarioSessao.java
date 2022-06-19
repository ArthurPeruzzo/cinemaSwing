/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.entidade;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Arthur
 */
public class HorarioSessao {
    
     private LocalDate data;

    private LocalTime hora;

    private Sala sala;

    private Filme filme;


    public HorarioSessao() {
    }

    public HorarioSessao(LocalDate data, LocalTime hora, Sala sala, Filme filme) {
        this.data = data;
        this.hora = hora;
        this.sala = sala;
        this.filme = filme;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
}
