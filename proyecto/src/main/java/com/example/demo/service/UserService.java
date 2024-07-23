package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<Usuario> listarUsuarios(){
		return repository.findUsuario();
	}
	
	public Usuario buscarUsuario(Integer codUsuario) {
		return repository.findById(codUsuario).orElse(new Usuario());
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
    public Usuario actualizarUsuario(Usuario usuario) {
        if (repository.existsById(usuario.getCodUsuario())) {
            return repository.save(usuario);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }
    
    public void eliminarUsuario(Integer codUsuario) {
    	repository.deleteById(codUsuario);
    }
    
	
}
