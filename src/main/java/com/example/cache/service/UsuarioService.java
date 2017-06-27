package com.example.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cache.dao.UsuarioDAO;
import com.example.cache.model.Usuario;

@Service
//@CacheDefaults(cacheName = "CACHE_USUARIO")
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	//@CacheRemove
	public Usuario salvar(Usuario usuario) {
		usuario = usuarioDAO.save(usuario);

		return usuario;
	}

	//@CacheResult()
	public Usuario findById(Long id) {
		Usuario usuario = usuarioDAO.findOne(id);

		return usuario;
	}

	public List<Usuario> getAllUsuarios() {
		Iterable<Usuario> iterator = usuarioDAO.findAll();
		List<Usuario> usuarios = new ArrayList<>();
		iterator.forEach(usuarios::add);

		return usuarios;
	}
}
