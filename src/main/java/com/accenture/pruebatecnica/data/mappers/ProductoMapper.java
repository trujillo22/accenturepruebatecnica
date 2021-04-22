package com.accenture.pruebatecnica.data.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.accenture.pruebatecnica.data.DTO.ProductoDTO;
import com.accenture.pruebatecnica.data.models.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

	public ProductoDTO transformEntityToDTO(Producto entity);

	public Producto transformDTOToEntity(ProductoDTO dto);

	public List<ProductoDTO> transformEntitiesToDTO(List<Producto> listEntities);

	public List<Producto> transformDTOToEntities(List<ProductoDTO> listDTO);
}
