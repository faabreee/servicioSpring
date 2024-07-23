package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comentario;
import com.example.demo.repository.ComentarioRepository;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository repository;

    public List<Comentario> listarComentarioxEvento(Integer codEvento){
        return repository.findByComentarioxEvento(codEvento);
    }

    public Comentario comentarioGuardar(Comentario comentario) {
        return repository.save(comentario);
    }

    public Comentario comentarioDel(Integer id) {
        Comentario temp = repository.findById(id).orElse(null);
        if(temp == null) {
            return new Comentario();
        }else {
            repository.deleteById(id);
            return temp;
        }

    }

}