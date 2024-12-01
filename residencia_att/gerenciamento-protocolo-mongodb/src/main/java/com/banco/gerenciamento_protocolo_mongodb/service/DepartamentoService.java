package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Departamento;
import com.banco.gerenciamento_protocolo_mongodb.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Criar um novo departamento
    public Departamento criarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    // Buscar todos os departamentos
    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }

    // Buscar um departamento por ID
    public Departamento buscarPorId(String id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    // Atualizar um departamento existente
    public Departamento atualizarDepartamento(String id, Departamento departamentoAtualizado) {
        Departamento departamento = buscarPorId(id);
        if (departamento != null) {
            departamento.setNome(departamentoAtualizado.getNome());
            departamento.setFuncionarios(departamentoAtualizado.getFuncionarios());
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    // Excluir um departamento
    public void excluirDepartamento(String id) {
        departamentoRepository.deleteById(id);
    }
}
