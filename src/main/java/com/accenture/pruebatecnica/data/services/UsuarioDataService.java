package com.accenture.pruebatecnica.data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.pruebatecnica.data.DTO.UsuarioDTO;
import com.accenture.pruebatecnica.data.mappers.UsuarioMapper;
import com.accenture.pruebatecnica.data.models.Usuario;
import com.accenture.pruebatecnica.data.repositories.IUsuarioRepository;

/**
 * Clase que encapsula la consulta por medio del repositorio y la transformacion de Entidades a DTO de los Usuario
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Component
public class UsuarioDataService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	/**
	 * Permite obtener la lista de todos los usuarios existentes
	 * @return una list de tipo UsuarioDTO
	 */
	public List<UsuarioDTO> consultarTodos() {
		return usuarioMapper.transformEntitiesToDTO((List<Usuario>)usuarioRepository.findAll());
	}
	
	/**
	 * Permite consultar un usuario por el id del usario (El id es diferente que la cedula)
	 * @param idUsuario Long que representa el identificador del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	public UsuarioDTO consultarPorIdUsuario(Long idUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		return usuario.isPresent() ? usuarioMapper.transformEntityToDTO(usuario.get()) : new UsuarioDTO();
	}
	
	/**
	 * Permite consultar un usuario por la cedula del usuario
	 * @param cedula String que represneta la cedula del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	public UsuarioDTO consultarPorCedula(String cedula) {
		Usuario usuario = usuarioRepository.consultarPorCedula(cedula);
		return usuario != null ? usuarioMapper.transformEntityToDTO(usuario) : new UsuarioDTO();
	}
	
	/**
	 * Permite guardar un usuario nuevo
	 * @param usuarioDTO Objeto de tipo UsuarioDTO con la informacion a guardar
	 * @return un objeto de tipo UsuarioDTO con la informacion guardada
	 */
	public UsuarioDTO guardar(UsuarioDTO usuarioDTO) {
		return usuarioMapper.transformEntityToDTO(usuarioRepository.save(usuarioMapper.transformDTOToEntity(usuarioDTO)));
	}
	
	/**
	 * Permite eliminar un usuario por el identificador
	 * @param idUsuario Long que representa el identificador del usuario
	 */
	public void eliminar(Long idUsuario) {		
		usuarioRepository.deleteById(idUsuario);
	}
	
	/**
	 * Permite eliminar un usuario por la cedula
	 * @param cedula String que representa la cedula del usuario
	 */
	public void eliminarPorCedula(String cedula) {
		Usuario usuario = usuarioRepository.consultarPorCedula(cedula);
		
		if (usuario != null)
		{
			usuarioRepository.delete(usuario);
		}
	}

}
