package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    // Método para criar um novo protocolo
    @PostMapping
    public ResponseEntity<Protocolo> criarProtocolo(@RequestBody Protocolo protocolo) {
        Protocolo novoProtocolo = protocoloService.abrirProtocolo(protocolo);
        return ResponseEntity.ok(novoProtocolo);
    }

    // Método para listar todos os protocolos
    @GetMapping
    public List<Protocolo> listarProtocolos() {
        return protocoloService.listarTodos();
    }

    // Método para buscar um protocolo pelo número
    @GetMapping("/{numeroProtocolo}")
    public ResponseEntity<Protocolo> obterProtocolo(@PathVariable String numeroProtocolo) {
        Optional<Protocolo> protocolo = protocoloService.buscarPorNumero(numeroProtocolo);
        return protocolo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar o status do protocolo
    @PatchMapping("/{numeroProtocolo}/status")
    public ResponseEntity<Void> atualizarStatusProtocolo(@PathVariable String numeroProtocolo, @RequestBody String status) {
        protocoloService.atualizarStatusProtocolo(numeroProtocolo, status);
        return ResponseEntity.noContent().build();
    }

    // Atualizar parcialmente qualquer informação do protocolo (PATCH)
    @PatchMapping("/{numeroProtocolo}")
    public ResponseEntity<Protocolo> atualizarProtocoloParcialmente(@PathVariable String numeroProtocolo, @RequestBody Map<String, Object> updates) {
        Optional<Protocolo> optionalProtocolo = protocoloService.buscarPorNumero(numeroProtocolo);

        if (optionalProtocolo.isPresent()) {
            Protocolo protocolo = optionalProtocolo.get();

            // Atualizar os campos individualmente se estiverem presentes no corpo da requisição
            if (updates.containsKey("tipoProtocolo")) {
                protocolo.setTipoProtocolo((String) updates.get("tipoProtocolo"));
            }
            if (updates.containsKey("descricao")) {
                protocolo.setDescricao((String) updates.get("descricao"));
            }

            if (updates.containsKey("dataAbertura")) {
                protocolo.setDataAbertura(LocalDate.parse((String) updates.get("dataAbertura")));
            }
            if (updates.containsKey("dataPrazo")) {
                protocolo.setDataPrazo(LocalDate.parse((String) updates.get("dataPrazo")));
            }
            if (updates.containsKey("canal")) {
                protocolo.setCanal((String) updates.get("canal"));
            }
            if (updates.containsKey("dataUltimaAcao")) {
                protocolo.setDataUltimaAcao(LocalDate.parse((String) updates.get("dataUltimaAcao")));
            }
            if (updates.containsKey("propensaoBacen")) {
                protocolo.setPropensaoBacen((Boolean) updates.get("propensaoBacen"));
            }
            if (updates.containsKey("agilizar")) {
                protocolo.setAgilizar((Boolean) updates.get("agilizar"));
            }
            if (updates.containsKey("devido")) {
                protocolo.setDevido((Boolean) updates.get("devido"));
            }
            if (updates.containsKey("procedente")) {
                protocolo.setProcedente((Boolean) updates.get("procedente"));
            }
            if (updates.containsKey("statusProtocolo")) {
                protocolo.setStatusProtocolo((String) updates.get("statusProtocolo"));
            }

            protocolo.setDataUltimaAcao(LocalDate.now()); // Atualizar a data da última ação

            // Salvar protocolo atualizado
            Protocolo protocoloAtualizado = protocoloService.salvarProtocolo(protocolo);
            return ResponseEntity.ok(protocoloAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Atualizar completamente as informações do protocolo (PUT)
    @PutMapping("/{numeroProtocolo}")
    public ResponseEntity<Protocolo> atualizarProtocoloCompletamente(@PathVariable String numeroProtocolo, @RequestBody Protocolo protocoloAtualizado) {
        Optional<Protocolo> optionalProtocolo = protocoloService.buscarPorNumero(numeroProtocolo);

        if (optionalProtocolo.isPresent()) {
            Protocolo protocolo = optionalProtocolo.get();

            // Atualizar todos os campos do protocolo
            protocolo.setTipoProtocolo(protocoloAtualizado.getTipoProtocolo());
            protocolo.setDescricao(protocoloAtualizado.getDescricao());
            protocolo.setCliente(protocoloAtualizado.getCliente());
            protocolo.setDataAbertura(protocoloAtualizado.getDataAbertura());
            protocolo.setDataPrazo(protocoloAtualizado.getDataPrazo());
            protocolo.setCanal(protocoloAtualizado.getCanal());
            protocolo.setDataUltimaAcao(LocalDate.now());
            protocolo.setPropensaoBacen(protocoloAtualizado.isPropensaoBacen());
            protocolo.setAgilizar(protocoloAtualizado.isAgilizar());
            protocolo.setDevido(protocoloAtualizado.isDevido());
            protocolo.setProcedente(protocoloAtualizado.isProcedente());
            protocolo.setStatusProtocolo(protocoloAtualizado.getStatusProtocolo());

            Protocolo protocoloSalvo = protocoloService.salvarProtocolo(protocolo);
            return ResponseEntity.ok(protocoloSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



