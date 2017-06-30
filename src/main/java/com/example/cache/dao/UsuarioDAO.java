package com.example.cache.dao;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;

import org.springframework.data.repository.CrudRepository;

import com.example.cache.model.Usuario;

@CacheDefaults(cacheName = "USUARIO_CACHE")
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

	@Override
	@CacheRemove()
	<S extends Usuario> S save(S entity);

	@Override
    @CacheResult()
	Usuario findOne(Long id);
	
	
}
