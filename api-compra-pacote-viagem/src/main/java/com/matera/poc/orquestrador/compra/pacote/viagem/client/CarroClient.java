package com.matera.poc.orquestrador.compra.pacote.viagem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "carClient", url = "http://localhost:8081")
public interface CarroClient {
    @PostMapping("/reserva-carro/{id}")
    void reservaCarro(@PathVariable String id);

    @PostMapping("/reserva-carro/cancelar/{id}")
    void cancelarReservaCarro(@PathVariable String id);
}