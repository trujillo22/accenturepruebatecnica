package com.accenture.pruebatecnica.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.pruebatecnica.data.models.Pedido;

/**
 * Interface que representa el repositrio para Pedido, permite realizar operaciones con a la BD
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Repository
public interface IPedidoRepository extends CrudRepository<Pedido, Long> {	


}
