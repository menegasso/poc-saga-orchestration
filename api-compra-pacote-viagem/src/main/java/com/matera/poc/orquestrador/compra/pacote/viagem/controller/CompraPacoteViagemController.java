package com.matera.poc.orquestrador.compra.pacote.viagem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matera.poc.orquestrador.compra.pacote.viagem.service.CompraPacoteViagemService;

@RestController
@RequestMapping("/compra-pacote-viagem/")
public class CompraPacoteViagemController {

    public final CompraPacoteViagemService viagemService;

    public CompraPacoteViagemController(CompraPacoteViagemService viagemService) {
        this.viagemService = viagemService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> process(@PathVariable String id) {
        String resultado = viagemService.processarCompraPacoteViagem(id, false, false, false);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/simular-erro-carro/{id}")
    public ResponseEntity<String> simularErroCarro(@PathVariable String id) {
        String resultado = viagemService.processarCompraPacoteViagem(id, true, false, false);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/simular-erro-hotel/{id}")
    public ResponseEntity<String> simularErroHotel(@PathVariable String id) {
        String resultado = viagemService.processarCompraPacoteViagem(id, false, true, false);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/simular-erro-voo/{id}")
    public ResponseEntity<String> simularErroVoo(@PathVariable String id) {
        String resultado = viagemService.processarCompraPacoteViagem(id, false, false, true);
        return ResponseEntity.ok(resultado);
    }

}
