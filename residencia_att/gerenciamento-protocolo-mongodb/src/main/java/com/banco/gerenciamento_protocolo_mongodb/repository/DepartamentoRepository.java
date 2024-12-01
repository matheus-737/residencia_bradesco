package com.banco.gerenciamento_protocolo_mongodb.repository;

import com.banco.gerenciamento_protocolo_mongodb.model.Departamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends MongoRepository<Departamento, String> {
}
