package com.matera.poc.reserva.voo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva-voo")
public class ReservaVooController {

    @PostMapping("/{id}")
    public ResponseEntity<String> process(@PathVariable String id) throws InterruptedException {
        Thread.sleep(2000);
        return ResponseEntity.ok("Reserva de voo processada com sucesso!");
    }

}
