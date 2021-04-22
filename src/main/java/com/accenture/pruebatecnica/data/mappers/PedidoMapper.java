package com.accenture.pruebatecnica.data.mappers;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.accenture.pruebatecnica.data.DTO.PedidoDTO;
import com.accenture.pruebatecnica.data.models.Pedido;
import com.accenture.pruebatecnica.utils.Constantes;

/**
 * Interface para mapear los campos entre la entidad y DTO de Pedido
 * @author DANIEL
 * @version 20/04/2021
 *
 */
@Mapper(componentModel = "spring")
public interface PedidoMapper {
	
	@AfterMapping
	default void afterMapping(@MappingTarget PedidoDTO target, Pedido source) {
		
		Float totalIVA = new Float(0);
		Float totalDomicilio = new Float(0);
		Float totalNeto = new Float(0);
		
		if(source.getEstado().equals(Constantes.ESTADO_PEDIDO_ACTIVO))
		{
			target.setEstadoString(Constantes.ESTADO_PEIDIDO_ACTIVO_STRING);
			totalIVA = new Float(target.getSubtotal() * 0.19);
			totalDomicilio = target.getSubtotal() >= Constantes.VALOR_MINIMO_PARA_COBRO_DE_DOMICILIO && target.getSubtotal() <= Constantes.VALOR_MAXIMO_PARA_COBRO_DE_DOMICILIO ? new Float(target.getSubtotal() * 0.05) : new Float(0);
			totalNeto = target.getSubtotal() + totalIVA + totalDomicilio;
		}
		else if (source.getEstado().equals(Constantes.ESTADO_PEDIDO_CANCELADO))
		{
			target.setEstadoString(Constantes.ESTADO_PEDIDO_CANCELADO_STRING);
			totalNeto = new Float(target.getSubtotal() * 0.10);
		}		 
		
		
		target.setTotalIVA(totalIVA);
		target.setTotalDomicilio(totalDomicilio);
		target.setTotalNeto(totalNeto);
	}
	
	@Mapping(source = "entity.idUsuario.idUsuario", target = "idUsuario")
	@Mapping(source = "entity.idUsuario.nombre", target = "nombreUsuario")
	@Mapping(source = "entity.fechaCreacion", target = "fechaCreacion", dateFormat = Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES)
	@Mapping(source = "entity.estado", target = "estado")
	@Mapping(target = "idProductosConcatenados", ignore = true)
	@Mapping(target = "totalIVA", ignore = true)
	@Mapping(target = "totalDomicilio", ignore = true)
	@Mapping(target = "totalNeto", ignore = true)
	@Mapping(target = "codigoRespuesta", ignore = true)
	@Mapping(target = "mensajeRespuesta", ignore = true)
	@Mapping(target = "estadoString", ignore = true)
	public PedidoDTO transformEntityToDTO(Pedido entity);
	
	@Mapping(source = "DTO.idUsuario", target = "idUsuario.idUsuario")
	@Mapping(source = "DTO.fechaCreacion", target = "fechaCreacion", dateFormat = Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES)
	@Mapping(source = "DTO.estado", target = "estado")
	public Pedido transformDTOToEntity(PedidoDTO DTO);
	
	public List<PedidoDTO> transformEntitiesToDTO(List<Pedido> listEntities);
	
	public List<Pedido> transformDTOToEntities(List<Pedido> listDTO);

}
