package com.co.eventoapp.cadastro.repository;

import com.co.eventoapp.cadastro.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findEventoById(Long id);
}
