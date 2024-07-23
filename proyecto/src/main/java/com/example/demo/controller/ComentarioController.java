package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comentario;
import com.example.demo.service.ComentarioService;

@RestController
@RequestMapping(value = "comentario", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    /*listar comentarios por evento*/
    @GetMapping("lista/{codEvento}")
    public List<Comentario> listarComentarioxEvento(@PathVariable("codEvento") Integer codEvento){
        return service.listarComentarioxEvento(codEvento);
    }

    /*agregar nuevo comentario*/
    @PostMapping("/agregar")
    public Comentario insertar(@RequestBody Comentario comentario) {
        return service.comentarioGuardar(comentario);
    }

    /*eliminar comentario*/
    @DeleteMapping("eliminar/{id}")
    public Comentario eliminar(@PathVariable("id") Integer id) {
        return service.comentarioDel(id);
    }

























}