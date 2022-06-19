/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.processo;

import com.mycompany.cinema.dao.PedidoDao;
import com.mycompany.cinema.dao.PoltronaDao;
import com.mycompany.cinema.entidade.Cidade;
import com.mycompany.cinema.entidade.Estado;
import com.mycompany.cinema.entidade.Filme;
import com.mycompany.cinema.entidade.HorarioSessao;
import com.mycompany.cinema.entidade.Pedido;
import com.mycompany.cinema.entidade.Pessoa;
import com.mycompany.cinema.entidade.Poltrona;
import com.mycompany.cinema.entidade.Sala;
import com.mycompany.cinema.entidade.StatusPedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class Teste {

    public Teste(String texto) {
    
   
    //        FilmeDao filmeDao = new FilmeDao();
        Filme filme = new Filme(5L, "Vingadores", LocalDateTime.now(), LocalDateTime.now());
//        Filme filmee = filmeDao.insert(filme);

//        EstadoDao estadoDao = new EstadoDao();
        Estado estado = new Estado(1L, "PR");
//        Estado estadoo = estadoDao.insert(estado);

//        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = new Cidade(1L, "nome", estado);
//        Cidade insertCidade = cidadeDao.insert(cidade);

//        SalaDao salaDao = new SalaDao();
        Sala sala = new Sala(2L, "codigo1", cidade, new BigDecimal(30));
//        Sala insertSala = salaDao.insert(sala);

        Pessoa pessoa = new Pessoa(1L, "Arthur", "teste@gmail.com", "senha", "930219321");


//        HorarioDao horarioDao = new HorarioDao();
        HorarioSessao horario = new HorarioSessao(LocalDate.now(), LocalTime.now(), sala, filme);
//        List<HorarioSessao> all = horarioDao.findAll();

        PoltronaDao poltronaDao = new PoltronaDao();
        Poltrona poltrona = new Poltrona(1L, texto);
        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = new Pedido(1L, sala, filme, LocalDateTime.now(), StatusPedido.PAGO, pessoa, poltrona);
        pedidoDao.insert(pedido);
        List<Poltrona> poltronas = poltronaDao.buscaPoltronasIndisponiveis();

//        HorarioSessaoValidation horarioSessaoValidation = new HorarioSessaoValidation();
//        Boolean validar = horarioSessaoValidation.validar(horario);
    }
}
