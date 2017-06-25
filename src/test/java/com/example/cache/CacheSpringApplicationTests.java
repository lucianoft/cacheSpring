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
		Usuario usuario = new Usuario();
		usuario.setLogin("luciano");
		usuario.setSenha("1");
		ResponseEntity<Usuario> responseEntity = usuarioController.inserir(usuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
	}
	
	@Test
	public void alterar(){
		Long idUsuario = 1L;
		
		ResponseEntity<Usuario> responseEntity = usuarioController.getUsuario(idUsuario);
		Usuario usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		usuario.setSenha("_1121");
		responseEntity = usuarioController.alterar(usuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		responseEntity = usuarioController.getUsuario(idUsuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		usuario.setSenha("1121");
		responseEntity = usuarioController.alterar(usuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		responseEntity = usuarioController.getUsuario(idUsuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
	}
	
	@Test
	public void findById(){
		Long idUsuario = 1L;
		
		ResponseEntity<Usuario> responseEntity = usuarioController.getUsuario(idUsuario);
		Usuario usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		responseEntity = usuarioController.getUsuario(idUsuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		responseEntity = usuarioController.getUsuario(idUsuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
		
		
		responseEntity = usuarioController.getUsuario(idUsuario);
		usuario = responseEntity.getBody();
		System.out.println(usuario);
	}
}
