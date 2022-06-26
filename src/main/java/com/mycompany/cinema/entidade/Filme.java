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
public class Filme {
    
    private Long id;

    private String nome;

    private LocalDateTime dataHoraEstreia;

    public Filme() {
    }

    public Filme(Long id) {
        this.id = id;
    }

    public Filme(Object filme) {
        if (filme != null) {
            Filme filmeObject = (Filme) filme;
            this.id = filmeObject.getId();
            this.nome = filmeObject.getNome();
            this.dataHoraEstreia = filmeObject.getDataHoraEstreia();
        }
    }

    public Filme(String nome, LocalDateTime dataHoraEstreia) {
        this.nome = nome;
        this.dataHoraEstreia = dataHoraEstreia;
    }

    public Filme(Long id, String nome, LocalDateTime dataHoraEstreia) {
        this.id = id;
        this.nome = nome;
        this.dataHoraEstreia = dataHoraEstreia;
    }

    public Filme(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHoraEstreia() {
        return dataHoraEstreia;
    }

    public void setDataHoraEstreia(LocalDateTime dataHoraEstreia) {
        this.dataHoraEstreia = dataHoraEstreia;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
