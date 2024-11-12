package com.banco.gerenciamento_protocolo_mongodb.repository;


import com.banco.gerenciamento_protocolo_mongodb.model.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends MongoRepository<Cargo, String> {
}
