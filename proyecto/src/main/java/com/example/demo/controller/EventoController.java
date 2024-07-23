package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Evento;
import com.example.demo.service.EventoService;

@RestController
@RequestMapping(value = "evento", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {

	@Autowired
	private EventoService service;
	
	/*listar eventos creados por el usuario*/
	@GetMapping("/lista/{usuario}")
	public List<Evento> listarEventosPorCodUsuario(@PathVariable("usuario") Integer usuario) {
	    return service.listarEventosPorCodUsuario(usuario);
	}

	/*listar todos los eventos con estado 1*/
	@GetMapping("/listado")
	public List<Evento> listarEventos(Integer estado){
		return service.listarEventos(estado);
	}
	
	/*buscar eventos por codEvento*/
	@GetMapping("/ver/{codEvento}")
	public Evento verEvento(@PathVariable("codEvento") Integer codEvento) {
		return service.verEvento(codEvento);
	}
	
	/*agregar evento*/
	@PostMapping("/agregar")
    public Evento insertar(@RequestBody Evento evento) {
        return service.eventoGuardar(evento);
    }

	/*actualizar evento*/
    @PutMapping("/actualizar")
    public Evento actualizar(@RequestBody Evento evento) {
        return service.eventoGuardar(evento);
    }

    /*eliminar evento por codigo*/
    @DeleteMapping("eliminar/{id}")
    public Evento eliminar(@PathVariable("id") Integer id) {
        return service.eventoEliminar(id);
    }

    /*cambiar el estado de un evento*/
    @PutMapping("estado/{codEvento}/{estado}")
    public void setEstadoEvento(@PathVariable("codEvento") Integer codEvento, @PathVariable("estado") Integer estado) {
        service.actualizarEstadoEvento(codEvento, estado);
    }

}
