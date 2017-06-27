package com.example.cache.dao;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheValue;

import org.springframework.data.repository.CrudRepository;

import com.example.cache.model.Usuario;

@CacheDefaults(cacheName = "USUARIO_CACHE")
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

	@Override
	@CacheRemove(/*cacheName = "USUARIO_CACHE"*/)
	<S extends Usuario> S save(S entity);

	@Override
    @CachePut(/*cacheName = "USUARIO_CACHE"*/)
	Usuario findOne(@CacheValue Long id);
}
