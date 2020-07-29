package com.co.eventoapp.cadastro.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "TB_CONVIDADO")
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConvidado;
    private String rneConvidado;
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;
}
