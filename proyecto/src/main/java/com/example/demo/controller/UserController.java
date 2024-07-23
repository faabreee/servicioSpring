package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	UserService userservice;

	/*listar usuarios con estado 1*/
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios() {
		return userservice.listarUsuarios();
	}
	
	/*buscar usuario por codUsuario*/
	@GetMapping("/buscar/{codUsuario}")
	public Usuario buscarUsuario(@PathVariable("codUsuario") Integer codUsuario) {
		return userservice.buscarUsuario(codUsuario);
	}
	
	/*guardar usuario*/
	@PostMapping("/guardar")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return userservice.guardarUsuario(usuario);
	}
	
	/*actualizar usuario*/
	@PutMapping("/actualizar")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return userservice.actualizarUsuario(usuario);
	}
	
	/*elminar usuario por codUsuario*/
	@DeleteMapping("eliminar/{codUsuario}")
	public void eliminarUsuario(@PathVariable Integer codUsuario) {
		userservice.eliminarUsuario(codUsuario);
	}

}
