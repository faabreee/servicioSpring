package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Evento;
import com.example.demo.repository.EventoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EventoService {
	
	@Autowired
	EventoRepository repository;
	
    public List<Evento> listarEventosPorCodUsuario(Integer usuario) {
        return repository.findByUsuarioCodUsuario(usuario);
    }
    
    public List<Evento> listarEventos(Integer estado) {
        return repository.findEventos(estado);
    }
    
	public Evento verEvento(Integer codEvento) {
		return repository.findById(codEvento).orElse(new Evento());
	}
	
	public Evento eventoGuardar(Evento evento) {
		return repository.save(evento);
	}
	
	public Evento eventoEliminar(Integer id) {
		Evento temp = repository.findById(id).orElse(null);
		if(temp == null) {
			return new Evento();
		}else {
			
			repository.deleteById(id);
			return temp;
		}
	} 

	@Transactional
    public Evento actualizarEstadoEvento(Integer idEvento, Integer nuevoEstado) {
        Evento evento = repository.findById(idEvento).orElse(null);
        if (evento != null) {
            if (nuevoEstado == 0 || nuevoEstado == 1) {
                evento.setEstado(nuevoEstado);
                return repository.save(evento);
            } else {
                throw new IllegalArgumentException("El nuevo estado debe ser 0 o 1");
            }
        } else {
            throw new EntityNotFoundException("El evento con ID " + idEvento + " no fue encontrado.");
        }
    }
	
}