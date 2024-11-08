package com.banco.gerenciamento_protocolo_mongodb.repository;

import com.banco.gerenciamento_protocolo_mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    Optional<Funcionario> findByCodigoFuncional(String codigoFuncional);
}
