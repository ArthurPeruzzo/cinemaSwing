/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.entidade;

import java.math.BigDecimal;

/**
 *
 * @author Arthur
 */
public class Sala {
    
    private Long id;

    private String codigo;

    private Cidade cidade;

    private BigDecimal capacidade;

    public Sala() {
    }

    public Sala(Long id) {
        this.id = id;
    }

    public Sala(Long id, String codigo, Cidade cidade, BigDecimal capacidade) {
        this.id = id;
        this.codigo = codigo;
        this.cidade = cidade;
        this.capacidade = capacidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }
}
