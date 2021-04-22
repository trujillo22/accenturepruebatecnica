package com.accenture.pruebatecnica.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.pruebatecnica.data.models.PedidoDetalle;

@Repository
public interface IPedidoDetalleRepository extends CrudRepository<PedidoDetalle, Long> {
	
	@Query("SELECT pd FROM PedidoDetalle pd WHERE pd.idPedido.idPedido = :idPedido")
	public List<PedidoDetalle> consultarTodosPorIdPedido(@Param("idPedido") Long idPedido);
}
