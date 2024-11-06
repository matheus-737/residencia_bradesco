package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    private String email;
    private TipoCliente tipoCliente;
    private Telefone telefone;

    public Cliente() {}

    public Cliente(String email, TipoCliente tipoCliente, Telefone telefone) {
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    // Enum TipoCliente

    public enum TipoCliente {
        FISICO,
        JURIDICO
    }

    // Classe interna Telefone

    public static class Telefone {
        private String numero;
        private String ddd;
        private TipoTelefone tipoTelefone;

        public Telefone() {}

        public Telefone(String numero, String ddd, TipoTelefone tipoTelefone) {
            this.numero = numero;
            this.ddd = ddd;
            this.tipoTelefone = tipoTelefone;
        }

        // Getters e Setters para Telefone

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getDdd() {
            return ddd;
        }

        public void setDdd(String ddd) {
            this.ddd = ddd;
        }

        public TipoTelefone getTipoTelefone() {
            return tipoTelefone;
        }

        public void setTipoTelefone(TipoTelefone tipoTelefone) {
            this.tipoTelefone = tipoTelefone;
        }
    }

    // Enum TipoTelefone

    public enum TipoTelefone {
        RESIDENCIAL,
        COMERCIAL,
        CELULAR
    }
}