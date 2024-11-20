package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Cliente;
import com.banco.gerenciamento_protocolo_mongodb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        // Validação adicional, como verificar se o cliente já existe, pode ser feita aqui
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);  // Retorna null se não encontrar
    }
}
