package com.banco.gerenciamento_protocolo_mongodb.controller;

import com.banco.gerenciamento_protocolo_mongodb.model.Protocolo;
import com.banco.gerenciamento_protocolo_mongodb.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    // Método para criar um novo protocolo
    @PostMapping
    public Protocolo criarProtocolo(@RequestBody Protocolo protocolo) {
        return protocoloService.criarProtocolo(protocolo);
    }
}
