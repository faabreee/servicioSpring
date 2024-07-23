package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {

    @Query("SELECT e FROM Entrada e WHERE e.codUsuario.codUsuario = ?1")
    List<Entrada> findByEntradaporUsuario(Integer codUsuario);
    
}
