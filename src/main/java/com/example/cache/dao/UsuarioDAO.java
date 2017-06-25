package com.example.cache.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.cache.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

}
