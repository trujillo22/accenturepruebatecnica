package com.accenture.pruebatecnica.data.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.accenture.pruebatecnica.data.DTO.UsuarioDTO;
import com.accenture.pruebatecnica.data.models.Usuario;

/**
 * Interface para mapear los campos entre la entidad y DTO de Usuario
 * @author DANIEL
 * @version 20/04/2021
 *
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	public UsuarioDTO transformEntityToDTO(Usuario entity);

	public Usuario transformDTOToEntity(UsuarioDTO DTO);

	public List<UsuarioDTO> transformEntitiesToDTO(List<Usuario> listEntities);

	public List<Usuario> transformDTOToEntities(List<UsuarioDTO> listDTO);

}
