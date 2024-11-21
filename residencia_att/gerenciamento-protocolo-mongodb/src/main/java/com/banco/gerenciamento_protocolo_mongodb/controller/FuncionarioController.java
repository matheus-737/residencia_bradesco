package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Funcionario;
import com.banco.gerenciamento_protocolo_mongodb.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> buscarFuncionarioPorId(@PathVariable String id) {
        return funcionarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarCargo(@PathVariable String id, @RequestParam String cargo) {
        funcionarioService.atualizarCargoFuncionario(id, cargo);
        return funcionarioService.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deletarFuncionario(@PathVariable String id) {
        return funcionarioService.deletarFuncionario(id);
    }
}
