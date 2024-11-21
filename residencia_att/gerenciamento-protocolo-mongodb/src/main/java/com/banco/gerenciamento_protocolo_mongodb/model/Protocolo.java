package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Protocolo {

    @Id
    private String id;

    private String status;
    private String descricao;
    private Cliente cliente;      // Relacionamento com Cliente
    private Funcionario funcionario;  // Relacionamento com Funcionario

    // Construtores
    public Protocolo() {
    }

    public Protocolo(String status, String descricao, Cliente cliente, Funcionario funcionario) {
        this.status = status;
        this.descricao = descricao;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Protocolo{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                '}';
    }
}
