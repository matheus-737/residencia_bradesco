package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Departamento;
import com.banco.gerenciamento_protocolo_mongodb.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public Departamento criarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.criarDepartamento(departamento);
    }

    @GetMapping
    public List<Departamento> buscarTodos() {
        return departamentoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Departamento buscarPorId(@PathVariable String id) {
        return departamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Departamento atualizarDepartamento(@PathVariable String id, @RequestBody Departamento departamentoAtualizado) {
        return departamentoService.atualizarDepartamento(id, departamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirDepartamento(@PathVariable String id) {
        departamentoService.excluirDepartamento(id);
    }
}

//departamento