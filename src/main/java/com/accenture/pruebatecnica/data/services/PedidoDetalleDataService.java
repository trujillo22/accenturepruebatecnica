package com.accenture.pruebatecnica.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.pruebatecnica.data.DTO.PedidoDetalleDTO;
import com.accenture.pruebatecnica.data.mappers.PedidoDetalleMapper;
import com.accenture.pruebatecnica.data.models.PedidoDetalle;
import com.accenture.pruebatecnica.data.repositories.IPedidoDetalleRepository;

/**
 * Clase que encapsula la consulta por medio del repositorio y la transformacion de Entidades a DTO de los PedidoDetalle
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Component
public class PedidoDetalleDataService {
	
	@Autowired
	private IPedidoDetalleRepository pedidoDetalleRepository;
	
	@Autowired
	private PedidoDetalleMapper pedidoDetalleMapper;
	
	public PedidoDetalleDTO guardar(PedidoDetalleDTO pedidoDetalleDTO) {
		return pedidoDetalleMapper.transformEntityToDTO(pedidoDetalleRepository.save(pedidoDetalleMapper.transformDTOToEntity(pedidoDetalleDTO)));
	}
	
	public void eliminarTodosPorIdPedido(Long idPedido) {
		List<PedidoDetalle> lista = pedidoDetalleRepository.consultarTodosPorIdPedido(idPedido);
		
		if(!lista.isEmpty())
		{
			pedidoDetalleRepository.deleteAll(lista);
		}
	}
	

}
