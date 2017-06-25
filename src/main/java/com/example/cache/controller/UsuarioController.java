package com.example.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cache.model.Usuario;
import com.example.cache.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		try {
			return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
		} catch (Exception e) {
			// log.error("Error retrieving message", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/findById/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id) {
		
		Usuario Usuario = usuarioService.findById(id);
		if (Usuario == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario Usuario) {
		try {
			Usuario = usuarioService.salvar(Usuario);
			return new ResponseEntity<>(Usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario Usuario) {
		try {
			Usuario = usuarioService.salvar(Usuario);
			return new ResponseEntity<>(Usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
