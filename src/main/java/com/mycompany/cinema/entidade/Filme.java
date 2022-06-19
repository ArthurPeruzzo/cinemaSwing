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

    private LocalDateTime dataHoraPreEstreia;

    public Filme() {
    }

    public Filme(String nome, LocalDateTime dataHoraEstreia, LocalDateTime dataHoraPreEstreia) {
        this.nome = nome;
        this.dataHoraEstreia = dataHoraEstreia;
        this.dataHoraPreEstreia = dataHoraPreEstreia;
    }

    public Filme(Long id, String nome, LocalDateTime dataHoraEstreia, LocalDateTime dataHoraPreEstreia) {
        this.id = id;
        this.nome = nome;
        this.dataHoraEstreia = dataHoraEstreia;
        this.dataHoraPreEstreia = dataHoraPreEstreia;
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

    public LocalDateTime getDataHoraPreEstreia() {
        return dataHoraPreEstreia;
    }

    public void setDataHoraPreEstreia(LocalDateTime dataHoraPreEstreia) {
        this.dataHoraPreEstreia = dataHoraPreEstreia;
    }
}
