package com.banco.gerenciamento_protocolo_mongodb.model;

public class Telefone {

    private String numero;
    private String ddd;
    private String tipoTelefone; // Exemplo: "CELULAR", "FIXO"

    public Telefone() {
    }

    public Telefone(String numero, String ddd, String tipoTelefone) {
        this.numero = numero;
        this.ddd = ddd;
        this.tipoTelefone = tipoTelefone;
    }

    // Getters e Setters
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

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "numero='" + numero + '\'' +
                ", ddd='" + ddd + '\'' +
                ", tipoTelefone='" + tipoTelefone + '\'' +
                '}';
    }
}
