package com.rodrigorangeldev.spring_vendas.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "Produto_Categoria",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> items = new HashSet<>();

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {

    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<ItemPedido> getItems() {
        return items;
    }

    public void setItems(Set<ItemPedido> items) {
        this.items = items;
    }

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x : items) {
            lista.add(x.getPedido());
        }

        return lista;
    }
}
