package com.matera.poc.orquestrador.compra.pacote.viagem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "hotelClient", url = "http://localhost:8082")
public interface HotelClient {
    @PostMapping("/reserva-hotel/{id}")
    void reservaHotel(@PathVariable String id);

    @PostMapping("/reserva-hotel/cancelar/{id}")
    void cancelarReservaHotel(@PathVariable String id);
}
