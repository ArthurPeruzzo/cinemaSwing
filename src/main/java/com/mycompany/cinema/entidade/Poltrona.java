/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.entidade;

/**
 *
 * @author Arthur
 */
public class Poltrona {
    
    private Long id;
    
    private String codigo;

    public Poltrona() {
    }

    public Poltrona(Long id) {
        this.id = id;
    }
    
    

    public Poltrona(Long id, String codigo) {
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

}
