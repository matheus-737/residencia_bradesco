package com.banco.gerenciamento_protocolo_mongodb.service;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.repository.ProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    // Método para abrir um novo protocolo
    public Protocolo abrirProtocolo(Protocolo protocolo) {
        protocolo.setNumeroProtocolo(UUID.randomUUID().toString());
        protocolo.setDataAbertura(LocalDate.now());
        protocolo.setDataPrazo(calcularPrazo(protocolo.getTipoProtocolo()));
        protocolo.setStatusProtocolo("Novo");
        return protocoloRepository.save(protocolo);  // Salvar novo protocolo
    }

    // Método para calcular o prazo com base no tipo de protocolo
    private LocalDate calcularPrazo(String tipoProtocolo) {
        switch (tipoProtocolo) {
            case "Reclamação":
                return LocalDate.now().plusDays(5);
            case "Elogio":
                return LocalDate.now().plusDays(10);
            case "Informação":
            case "Solicitação":
            case "Consulta":
                return LocalDate.now().plusDays(7);
            case "Denúncia":
                return LocalDate.now().plusDays(3);
            case "Cancelamento":
                return LocalDate.now().plusDays(2);
            default:
                return LocalDate.now().plusDays(7);
        }
    }

    // Método para salvar um protocolo
    public Protocolo salvarProtocolo(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);  // Salva ou atualiza o protocolo
    }

    // Método para listar todos os protocolos
    public List<Protocolo> listarTodos() {
        return protocoloRepository.findAll();
    }

    // Método para buscar um protocolo pelo número
    public Optional<Protocolo> buscarPorNumero(String numeroProtocolo) {
        return protocoloRepository.findByNumeroProtocolo(numeroProtocolo);
    }

    // Método para atualizar o status de um protocolo
    public void atualizarStatusProtocolo(String numeroProtocolo, String status) {
        Optional<Protocolo> optionalProtocolo = protocoloRepository.findByNumeroProtocolo(numeroProtocolo);
        if (optionalProtocolo.isPresent()) {
            Protocolo protocolo = optionalProtocolo.get();
            protocolo.setStatusProtocolo(status);
            protocolo.setDataUltimaAcao(LocalDate.now());  // Atualiza a data da última ação
            protocoloRepository.save(protocolo);  // Salva o protocolo com o novo status
        }
    }
}


