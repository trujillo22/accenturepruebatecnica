package com.accenture.pruebatecnica.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.pruebatecnica.data.models.Producto;

/**
 * Interface que representa el repositrio para Productos, permite realizar operaciones con a la BD
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {
	
	
	@Query("SELECT p FROM Producto p WHERE p.idProducto IN (SELECT pd.idProducto.idProducto FROM PedidoDetalle pd WHERE pd.idPedido.idPedido = :idPedido)")
	public List<Producto> consultarTodosProductosDeUnPedido(@Param("idPedido") Long idPedido);

}
