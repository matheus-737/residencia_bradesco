package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Cliente;
import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.repository.ClienteRepository;
import com.banco.gerenciamento_protocolo_mongodb.repository.ProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para criar um protocolo
    public Protocolo criarProtocolo(Protocolo protocolo) {
        // Verificar se o cliente existe
        Cliente cliente = clienteRepository.findById(protocolo.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Associar o cliente ao protocolo
        protocolo.setCliente(cliente);

        // Salvar o protocolo no banco de dados
        return protocoloRepository.save(protocolo);
    }

    // Buscar protocolo por ID
    public Protocolo buscarProtocoloPorId(String id) {
        return protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));
    }
}
