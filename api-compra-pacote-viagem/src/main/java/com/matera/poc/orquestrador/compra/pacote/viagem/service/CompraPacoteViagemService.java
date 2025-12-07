package com.matera.poc.orquestrador.compra.pacote.viagem.service;

import com.matera.poc.orquestrador.compra.pacote.viagem.client.CarroClient;
import com.matera.poc.orquestrador.compra.pacote.viagem.client.HotelClient;
import com.matera.poc.orquestrador.compra.pacote.viagem.client.VooClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CompraPacoteViagemService {

    private final CarroClient carroClient;
    private final HotelClient hotelClient;
    private final VooClient vooClient;

    public String processarCompraPacoteViagem(String id, boolean falhaCarro, boolean falhaHotel, boolean falhaVoo) {
        try {
            if (falhaCarro)
                throw new RuntimeException("Simulação de falha no carro");
            carroClient.reservaCarro(id);
            log.info(" ### Carro reservado com sucesso para o ID: {}", id);
        } catch (Exception e) {
            log.info(" --- Falha ao reservar carro para o ID: {}", id);
            return "Falha ao reservar carro, viagem cancelada!";
        }

        try {
            hotelClient.reservaHotel(id);
            if (falhaHotel)
                throw new RuntimeException("Simulação de falha no hotel");
            log.info(" ### Hotel reservado com sucesso para o ID: {}", id);
        } catch (Exception e) {
            carroClient.cancelarReservaCarro(id);
            log.info(" --- Reserva de carro cancelado devido a falha na reserva de hotel para o ID: {}", id);
            return "Falha ao reservar hotel, viagem cancelada!";
        }

        try {
            vooClient.reservaVoo(id);
            if (falhaVoo)
                throw new RuntimeException("Simulação de falha no voo");
            log.info(" #### Voo reservado com sucesso para o ID: {}", id);
        } catch (Exception e) {
            log.info(" --- Reserva de carro e hotel cancelados devido a falha na reserva de voo para o ID: {}", id);
            carroClient.cancelarReservaCarro(id);
            hotelClient.cancelarReservaHotel(id);
            return "Falha ao reservar voo, viagem cancelada!";
        }
        return "Compra do pacote de viagem processada com sucesso!";
    }
}
