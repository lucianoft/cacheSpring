package com.example.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cache.controller.UsuarioController;
import com.example.cache.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheSpringApplicationTests {
	
	@Autowired
	UsuarioController usuarioController; 
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void insert(){
		Usuario usuario = null;
		
		/*
		System.out.println("insert");
		usuario = inserir("luciano", "1");
		System.out.println(usuario);
		
		usuario = inserir("alicia", "1");
		System.out.println(usuario);
		
		usuario = inserir("murilo", "1");
		System.out.println(usuario);
		
		usuario = inserir("janne", "1");
		System.out.println(usuario);
		*/
		
		System.out.println("alterar");
		usuario = findById(1L);
		System.out.println(usuario);
		usuario = alterar(1L, usuario.getSenha() + "2");
		System.out.println(usuario);
		
		System.out.println("findById");
		System.out.println(usuario);
		usuario = findById(1L);
		System.out.println(usuario);
		
		usuario = findById(3L);
		System.out.println(usuario);
		
		usuario = findById(2L);
		System.out.println(usuario);
		
		usuario = findById(1L);
		System.out.println(usuario);
		
		usuario = findById(3L);
		System.out.println(usuario);
		
		usuario = findById(2L);
		System.out.println(usuario);
		
		usuario = findById(1L);
		System.out.println(usuario);
		
		usuario = findById(4L);
		System.out.println(usuario);
		
		usuario = findById(5L);
		System.out.println(usuario);
		
		usuario = findById(1L);
		System.out.println(usuario);
		
		usuario = findById(2L);
		System.out.println(usuario);
	}
	
	private Usuario inserir(String login, String senha){
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		ResponseEntity<Usuario> responseEntity = usuarioController.inserir(usuario);
		usuario = responseEntity.getBody();
		
		return usuario;
	}

	private Usuario findById(Long idUsuario){
		
		ResponseEntity<Usuario> responseEntity = usuarioController.getUsuario(idUsuario);
		Usuario usuario = responseEntity.getBody();
		
		return usuario;
	}
	
	private Usuario alterar(Long idUsuario, String senha){
		
		Usuario usuario = findById(idUsuario);
		usuario.setSenha(senha);
		usuario = update(usuario);
		
		return usuario;
	}
	private Usuario update(Usuario usuario){
		
		ResponseEntity<Usuario> responseEntity = usuarioController.alterar(usuario);
		usuario = responseEntity.getBody();
		
		return usuario;
	}
}
