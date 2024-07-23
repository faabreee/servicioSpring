package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Entrada;
import com.example.demo.service.EntradaService;

@RestController
@RequestMapping(value = "entrada", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntradaController {
	
	@Autowired
	private EntradaService service;
	
	/*listar entradas del usuario*/
	@GetMapping("/lista/{usuario}")
	public List<Entrada> listarEntradaPorCodUsuario(@PathVariable("usuario") Integer codUsuario) {
	    return service.listarEntradaxUsuario(codUsuario);
	}	
	
	/*agregar entrada*/
    @PostMapping("/agregar")
    public Entrada insertar(@RequestBody Entrada entrada) {
        return service.entradaGuradar(entrada);
    }

}
