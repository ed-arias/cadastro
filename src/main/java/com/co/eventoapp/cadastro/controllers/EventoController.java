package com.co.eventoapp.cadastro.controllers;

import com.co.eventoapp.cadastro.models.Convidado;
import com.co.eventoapp.cadastro.models.Evento;
import com.co.eventoapp.cadastro.repository.ConvidadoRepository;
import com.co.eventoapp.cadastro.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ConvidadoRepository convidadoRepository;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String formulario() {
        return "eventos/formularioEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String formulario(Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping(value = "deletarEvento/{id}")
    public String deletarEvento(@PathVariable(value = "id") Long id){
        Evento evento = eventoRepository.findEventoById(id);
        List<Convidado> convidados = convidadoRepository.findAllByEvento(evento);
        convidadoRepository.deleteAll(convidados);
        eventoRepository.delete(evento);
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/eventos")
    public ModelAndView listarEventos() {
        ModelAndView modelAndView = new ModelAndView("eventos/listaDeEventos");
        Iterable<Evento> eventos = eventoRepository.findAll();
        modelAndView.addObject("eventos", eventos);
        return modelAndView;
    }

    @RequestMapping(value = "detalheEvento/{id}", method = RequestMethod.GET)
    public ModelAndView detalheEvento(@PathVariable(value = "id") long id){
        ModelAndView modelAndView = new ModelAndView("eventos/detalheEvento");
        Evento evento = eventoRepository.findEventoById(id);
        List<Convidado> convidados = convidadoRepository.findAllByEvento(evento);
        modelAndView.addObject("evento", evento);
        modelAndView.addObject("convidados", convidados);
        return modelAndView;
    }

    @RequestMapping(value = "detalheEvento/{id}", method = RequestMethod.POST)
    public String cadastrarConvidado(@PathVariable(value = "id") Long id, Convidado convidado){
        Evento evento = eventoRepository.findEventoById(id);
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        return "redirect:{id}";
    }
}