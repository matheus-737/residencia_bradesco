package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Cargo;
import com.banco.gerenciamento_protocolo_mongodb.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    public CargoRepository cargoRepository;

    // Método para adicionar um novo cargo
    public Cargo adicionarCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    // Método para listar todos os cargos
    public List<Cargo> listarTodos() {
        return cargoRepository.findAll();
    }

    // Método para buscar um cargo pelo ID
    public Optional<Cargo> buscarPorId(String id) {
        return cargoRepository.findById(id);
    }

    // Método para atualizar um cargo
    public Cargo atualizarCargo(Cargo cargo) {
        return cargoRepository.save(cargo);  // Salva ou atualiza o cargo no banco de dados
    }

    // Método para excluir um cargo pelo ID
    public void excluirCargo(String id) {
        cargoRepository.deleteById(id);
    }
}
