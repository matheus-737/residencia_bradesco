package com.banco.gerenciamento_protocolo_mongodb.repository;

import com.banco.gerenciamento_protocolo_mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    // Adicionar métodos específicos se necessário
}
