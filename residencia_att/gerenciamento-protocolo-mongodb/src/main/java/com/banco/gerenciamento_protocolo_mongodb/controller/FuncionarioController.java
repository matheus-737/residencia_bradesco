package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Funcionario;
import com.banco.gerenciamento_protocolo_mongodb.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    // Método para criar um novo funcionário
    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.adicionarFuncionario(funcionario);
        return ResponseEntity.ok(novoFuncionario);
    }

    // Método para listar todos os funcionários
    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarTodos();
    }

    // Método para buscar um funcionário pelo código funcional
    @GetMapping("/{codigoFuncional}")
    public ResponseEntity<Funcionario> obterFuncionario(@PathVariable String codigoFuncional) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorCodigo(codigoFuncional);
        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para atualizar o status do funcionário (ativo/inativo)
    @PatchMapping("/{codigoFuncional}/status")
    public ResponseEntity<Void> atualizarStatusFuncionario(@PathVariable String codigoFuncional, @RequestBody String status) {
        funcionarioService.atualizarStatusFuncionario(codigoFuncional, status);
        return ResponseEntity.noContent().build();
    }

    // Método para atualizar parcialmente as informações do funcionário
    @PatchMapping("/{codigoFuncional}")
    public ResponseEntity<Funcionario> atualizarFuncionarioParcialmente(@PathVariable String codigoFuncional, @RequestBody Map<String, Object> updates) {
        Optional<Funcionario> optionalFuncionario = funcionarioService.buscarPorCodigo(codigoFuncional);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();

            // Atualizar campos individuais se presentes
            if (updates.containsKey("nome")) {
                funcionario.setNome((String) updates.get("nome"));
            }
            if (updates.containsKey("email")) {
                funcionario.setEmail((String) updates.get("email"));
            }
            if (updates.containsKey("departamento")) {
                funcionario.setDepartamento((String) updates.get("departamento"));
            }
            if (updates.containsKey("cargo")) {
                funcionario.setCargo((String) updates.get("cargo"));
            }
            if (updates.containsKey("status")) {
                funcionario.setStatus((String) updates.get("status"));
            }

            Funcionario funcionarioAtualizado = funcionarioService.salvarFuncionario(funcionario);
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para atualizar completamente as informações do funcionário
    @PutMapping("/{codigoFuncional}")
    public ResponseEntity<Funcionario> atualizarFuncionarioCompletamente(@PathVariable String codigoFuncional, @RequestBody Funcionario funcionarioAtualizado) {
        Optional<Funcionario> optionalFuncionario = funcionarioService.buscarPorCodigo(codigoFuncional);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();

            // Atualizar todos os campos do funcionário
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setDepartamento(funcionarioAtualizado.getDepartamento());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setStatus(funcionarioAtualizado.getStatus());

            Funcionario funcionarioSalvo = funcionarioService.salvarFuncionario(funcionario);
            return ResponseEntity.ok(funcionarioSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

        // Método para deletar um funcionário
    @DeleteMapping("/{codigoFuncional}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable String codigoFuncional) {
        boolean deletado = funcionarioService.deletarPorCodigo(codigoFuncional);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
