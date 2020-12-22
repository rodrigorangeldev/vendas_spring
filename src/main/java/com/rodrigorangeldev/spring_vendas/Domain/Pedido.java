package com.rodrigorangeldev.spring_vendas.Domain;

import java.util.Date;
import java.util.Objects;

public class Pedido {

    private Integer id;
    private Date instante;

    private Pagamento pagamento;
    private Cliente cliente;
    private Endereco enderecoDeentrega;

    public Pedido(){

    }

    public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeentrega) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.enderecoDeentrega = enderecoDeentrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeentrega() {
        return enderecoDeentrega;
    }

    public void setEnderecoDeentrega(Endereco enderecoDeentrega) {
        this.enderecoDeentrega = enderecoDeentrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
