package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionarios")
public class Funcionario {

    @Id
    private String id;
    private String codigoFuncional; //deve ser composta por 7 números
    private String nome;
    private String email;
    private String departamento;
    private String cargo;
    private String status; // Ativo ou Inativo

    // Utilizando construtores
    public Funcionario() {}

    public Funcionario(String codigoFuncional, String nome, String email, String departamento, String cargo, String status) {
        this.codigoFuncional = codigoFuncional;
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
        this.cargo = cargo;
        this.status = status;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCodigoFuncional() { return codigoFuncional; }
    public void setCodigoFuncional(String codigoFuncional) { this.codigoFuncional = codigoFuncional; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
