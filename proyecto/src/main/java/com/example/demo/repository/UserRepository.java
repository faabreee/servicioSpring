package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{
	
    @Query("SELECT e FROM Usuario e WHERE e.estado = 1")
    List<Usuario> findUsuario();

}
