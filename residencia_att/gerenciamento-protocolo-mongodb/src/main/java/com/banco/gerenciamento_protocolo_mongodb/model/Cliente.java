package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {

    @Id
    private String id;

    private String nome;
    private String cpf;
    private String email;
    private String tipoCliente;  // Exemplo: "FISICO" ou "JURIDICO"
    private Telefone telefone;   // Detalhamento do telefone

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String tipoCliente, Telefone telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
