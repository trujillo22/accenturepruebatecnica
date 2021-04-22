package com.accenture.pruebatecnica.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.pruebatecnica.data.models.Usuario;

/**
 * Interface que representa el repositrio para Usuario, permite realizar operaciones con a la BD
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.cedula = :cedula")
	public Usuario consultarPorCedula(@Param("cedula") String cedula);
}
