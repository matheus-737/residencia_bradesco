package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Cargo;
import com.banco.gerenciamento_protocolo_mongodb.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    // Método para criar um novo cargo
    @PostMapping
    public ResponseEntity<Cargo> criarCargo(@RequestBody Cargo cargo) {
        Cargo novoCargo = cargoService.adicionarCargo(cargo);
        return ResponseEntity.ok(novoCargo);
    }

    // Método para listar todos os cargos
    @GetMapping
    public List<Cargo> listarCargos() {
        return cargoService.listarTodos();
    }

    // Método para buscar um cargo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> obterCargo(@PathVariable String id) {
        Optional<Cargo> cargo = cargoService.buscarPorId(id);
        return cargo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para atualizar um cargo existente (atualização completa)
    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizarCargo(@PathVariable String id, @RequestBody Cargo cargoAtualizado) {
        Optional<Cargo> optionalCargo = cargoService.buscarPorId(id);

        if (optionalCargo.isPresent()) {
            Cargo cargoExistente = optionalCargo.get();
            cargoExistente.setNome(cargoAtualizado.getNome());
            cargoExistente.setDescricao(cargoAtualizado.getDescricao());

            Cargo cargoSalvo = cargoService.atualizarCargo(cargoExistente);
            return ResponseEntity.ok(cargoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar um cargo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCargo(@PathVariable String id) {
        Optional<Cargo> cargo = cargoService.buscarPorId(id);
        if (cargo.isPresent()) {
            cargoService.excluirCargo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
