package com.co.eventoapp.cadastro.repository;

import com.co.eventoapp.cadastro.models.Convidado;
import com.co.eventoapp.cadastro.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
    List<Convidado> findAllByEvento(Evento evento);
}
