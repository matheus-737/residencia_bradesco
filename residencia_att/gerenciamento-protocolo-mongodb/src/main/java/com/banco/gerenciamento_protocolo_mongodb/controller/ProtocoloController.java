package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    // Criar um protocolo
    @PostMapping
    public ResponseEntity<?> criarProtocolo(@RequestBody Protocolo protocolo) {
        try {
            Protocolo criado = protocoloService.criarProtocolo(protocolo);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar protocolo: " + e.getMessage());
        }
    }

    // Buscar um protocolo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProtocoloPorId(@PathVariable String id) {
        try {
            Protocolo protocolo = protocoloService.buscarProtocoloPorId(id);
            return ResponseEntity.ok(protocolo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Protocolo não encontrado: " + e.getMessage());
        }
    }
}
