package com.mycompany.cinema.entidade;

public class PedidoPoltrona {

    private Long id;

    private Poltrona poltrona;

    private Pedido pedido;

    public PedidoPoltrona() {
    }

    public PedidoPoltrona(Long id) {
        this.id = id;
    }

    public PedidoPoltrona(Poltrona poltrona, Pedido pedido) {
        this.poltrona = poltrona;
        this.pedido = pedido;
    }

    public PedidoPoltrona(Long id, Poltrona poltrona, Pedido pedido) {
        this.id = id;
        this.poltrona = poltrona;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
