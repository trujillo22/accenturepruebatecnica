package com.accenture.pruebatecnica.data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.pruebatecnica.data.DTO.PedidoDTO;
import com.accenture.pruebatecnica.data.mappers.PedidoMapper;
import com.accenture.pruebatecnica.data.models.Pedido;
import com.accenture.pruebatecnica.data.repositories.IPedidoRepository;

/**
 * Clase que encapsula la consulta por medio del repositorio y la transformacion de Entidades a DTO de los Pedido
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Component
public class PedidoDataService {
	
	@Autowired
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoMapper pedidoMapper;
	
	public List<PedidoDTO> consultarTodos() {
		return pedidoMapper.transformEntitiesToDTO((List<Pedido>) pedidoRepository.findAll());
	}
	
	public PedidoDTO consultarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		return pedido.isPresent() ? pedidoMapper.transformEntityToDTO(pedido.get()) : new PedidoDTO();
	}
	
	public PedidoDTO guardar(PedidoDTO pedidoDTO) {
		return pedidoMapper.transformEntityToDTO(pedidoRepository.save(pedidoMapper.transformDTOToEntity(pedidoDTO)));
	}
	
	public void eliminar(Long idPedido) {
		pedidoRepository.deleteById(idPedido);
	}

}
