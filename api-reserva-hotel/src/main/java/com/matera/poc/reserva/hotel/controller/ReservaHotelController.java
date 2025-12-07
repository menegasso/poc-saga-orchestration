package com.matera.poc.reserva.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva-hotel")
public class ReservaHotelController {

    @PostMapping("/{id}")
    public ResponseEntity<String> process(@PathVariable String id) throws InterruptedException {
        Thread.sleep(3000);
        return ResponseEntity.ok("Reserva de hotel processada com sucesso!");
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<String> cancelProcess(@PathVariable String id) throws InterruptedException {
        Thread.sleep(3000);
        return ResponseEntity.ok("Cancelamento de reserva de hotel realizado com sucesso!");
    }
}
