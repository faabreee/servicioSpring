package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Entrada;
import com.example.demo.repository.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository repository;
	
	public List<Entrada> listarEntradaxUsuario(Integer codUsuario){
		return repository.findByEntradaporUsuario(codUsuario);
	}
	
    public Entrada entradaGuradar(Entrada entrada) {
        return repository.save(entrada);
    }
	
}
