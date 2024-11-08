package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Funcionario;
import com.banco.gerenciamento_protocolo_mongodb.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorCodigo(String codigoFuncional) {
        return funcionarioRepository.findByCodigoFuncional(codigoFuncional);
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void atualizarStatusFuncionario(String codigoFuncional, String status) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByCodigoFuncional(codigoFuncional);
        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            funcionario.setStatus(status);
            funcionarioRepository.save(funcionario);
        }
    }
    //
    public boolean deletarPorCodigo(String codigoFuncional) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByCodigoFuncional(codigoFuncional);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return true;
        }
        return false;
    }
}
