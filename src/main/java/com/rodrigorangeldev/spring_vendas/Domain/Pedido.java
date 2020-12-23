package com.rodrigorangeldev.spring_vendas.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date instante;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeentrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> items = new HashSet<>();

    public Pedido(){

    }

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeentrega) {
        this.id = id;
        this.instante = instante;
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

    public Set<ItemPedido> getItems() {
        return items;
    }

    public void setItems(Set<ItemPedido> items) {
        this.items = items;
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
