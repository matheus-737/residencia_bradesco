
package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "departamentos")
public class Departamento {
    
    @Id
    private String id;
    private String nome;
    private List<Funcionario> funcionarios; // Relacionamento com funcionários
    
    // Construtor padrão
    public Departamento() {}

    // Construtor com parâmetros
    public Departamento(String nome, List<Funcionario> funcionarios) {
        this.nome = nome;
        this.funcionarios = funcionarios;
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
