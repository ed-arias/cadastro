package com.co.eventoapp.cadastro.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_EVENTO")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String local;
	private String data;
	private String horario;

	@OneToMany
	private List<Convidado> convidados;
}
