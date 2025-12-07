package com.matera.poc.orquestrador.compra.pacote.viagem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "flightClient", url = "http://localhost:8083")
public interface VooClient {
    @PostMapping("/reserva-voo/{id}")
    void reservaVoo(@PathVariable String id);
}
