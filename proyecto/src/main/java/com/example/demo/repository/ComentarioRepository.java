package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query("SELECT c FROM Comentario c WHERE c.codEvento.id = ?1")
    List<Comentario> findByComentarioxEvento(Integer codEvento);
}
