package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Cliente;
import com.banco.gerenciamento_protocolo_mongodb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método para criar um novo cliente
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para obter um cliente por ID
    public Optional<Cliente> obterClientePorId(String id) {
        return clienteRepository.findById(id);
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Método para atualizar um cliente existente
    public Optional<Cliente> atualizarCliente(String id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTipoCliente(clienteAtualizado.getTipoCliente());
            cliente.setCpf(clienteAtualizado.getCpf()); // Atualizar o CPF
            return clienteRepository.save(cliente);
        });
    }

    // Método para deletar um cliente por ID
    public boolean deletarCliente(String id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

