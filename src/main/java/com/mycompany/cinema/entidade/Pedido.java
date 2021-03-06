/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.entidade;

import java.time.LocalDateTime;

/**
 *
 * @author Arthur
 */
public class Pedido {
    
    private Long id;

    private Sala sala;

    private Filme filme;

    private LocalDateTime dataHora;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(Long id, Sala sala, Filme filme, LocalDateTime dataHora) {
        this.id = id;
        this.sala = sala;
        this.filme = filme;
        this.dataHora = dataHora;
    }

    public Pedido(Sala sala, Filme filme, LocalDateTime dataHora) {
        this.sala = sala;
        this.filme = filme;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
}
