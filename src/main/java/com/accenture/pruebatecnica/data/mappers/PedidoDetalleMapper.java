package com.accenture.pruebatecnica.data.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.accenture.pruebatecnica.data.DTO.PedidoDetalleDTO;
import com.accenture.pruebatecnica.data.models.PedidoDetalle;

@Mapper(componentModel = "spring")
public interface PedidoDetalleMapper {
	
	@Mapping(source = "entity.idPedido.idPedido", target = "idPedido")
	@Mapping(source = "entity.idProducto.idProducto", target = "idProducto")
	public PedidoDetalleDTO transformEntityToDTO(PedidoDetalle entity);
	
	@Mapping(source = "DTO.idPedido", target = "idPedido.idPedido")
	@Mapping(source = "DTO.idProducto", target = "idProducto.idProducto")
	public PedidoDetalle transformDTOToEntity(PedidoDetalleDTO DTO);
	
	public List<PedidoDetalleDTO> transformEntitiesToDTO(List<PedidoDetalle> listEntities);
	
	public List<PedidoDetalle> transformDTOToEntities(List<PedidoDetalleDTO> listDTO);

}
