package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.repository.ProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    public Protocolo criarProtocolo(Protocolo protocolo) {
        // Aqui, você pode adicionar lógica para verificar e associar corretamente o Cliente e Funcionario
        return protocoloRepository.save(protocolo);
    }
}
