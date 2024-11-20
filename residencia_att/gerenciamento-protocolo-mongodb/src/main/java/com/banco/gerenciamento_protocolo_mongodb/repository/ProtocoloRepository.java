package com.banco.gerenciamento_protocolo_mongodb.repository;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocoloRepository extends MongoRepository<Protocolo, String> {
    // Métodos personalizados podem ser adicionados aqui
}
