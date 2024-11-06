package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    private String email;
    private TipoCliente tipoCliente;
    private String cpf;  // Novo campo CPF

    public Cliente() {}

    public Cliente(String email, TipoCliente tipoCliente, String cpf) {
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.cpf = cpf;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCpf() {      // Getter para CPF
        return cpf;
    }

    public void setCpf(String cpf) {   // Setter para CPF
        this.cpf = cpf;
    }

    // Enum TipoCliente

    public enum TipoCliente {
        FISICO,
        JURIDICO
    }
}
