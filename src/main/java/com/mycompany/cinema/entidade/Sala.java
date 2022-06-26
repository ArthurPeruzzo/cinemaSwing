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

    public Sala() {
    }

    public Sala(Object sala) {
        if(sala != null){
            Sala salaObject = (Sala) sala;
            this.id = salaObject.getId();
            this.codigo = salaObject.getCodigo();
        }
    }




    public Sala(Long id) {
        this.id = id;
    }

    public Sala(Long id, String codigo) {
        this.id = id;
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return id + " - " + codigo;
    }
}
