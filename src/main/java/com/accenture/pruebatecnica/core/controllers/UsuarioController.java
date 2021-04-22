package com.accenture.pruebatecnica.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pruebatecnica.core.services.UsuarioService;
import com.accenture.pruebatecnica.data.DTO.UsuarioDTO;

/**
 * Clase que represeta el controlador de Usuario para acceder a los diferentes metodos expuestos
 * @author DANIEL
 * @version 1.0 21/04/2021
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Permite obtener la lista de todos los usuarios existentes
	 * @return una list de tipo UsuarioDTO
	 */
	@GetMapping("")
	public List<UsuarioDTO> consultarTodos() {
		return usuarioService.consultarTodos();
	}
	
	/**
	 * Permite consultar un usuario por el id del usario (El id es diferente que la cedula)
	 * @param idUsuario Long que representa el identificador del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	@GetMapping("/{idUsuario}")
	public UsuarioDTO consultarPorIdUsuario(@PathVariable("idUsuario") Long idUsuario) {
		return usuarioService.consultarPorIdUsuario(idUsuario);
	}
	
	/**
	 * Permite consultar un usuario por la cedula del usuario
	 * @param cedula String que represneta la cedula del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	@GetMapping("/cedula/{cedula}")
	public UsuarioDTO consultarPorCedula(@PathVariable("cedula") String cedula) {
		return usuarioService.consultarPorCedula(cedula);
	}
		
	/**
	 * Permite guardar un usuario nuevo
	 * 
	 * @param usuarioDTO Objeto de tipo UsuarioDTO con la informacion a guardar
	 * @return un objeto de tipo UsuarioDTO con la informacion guardada
	 */
	@PostMapping("")
	public UsuarioDTO guardar(@RequestBody UsuarioDTO peticiondTO) {
		return usuarioService.guardar(peticiondTO);
	}
	
	/**
	 * Permite modificar un usuario existente
	 * 
	 * @param usuarioDTO Objeto de tipo UsuarioDTO con la informacion a modificar
	 * @return un objeto de tipo UsuarioDTO con la informacion modificada
	 */
	@PutMapping("")
	public UsuarioDTO modificar(@RequestBody UsuarioDTO peticiondTO) {
		return usuarioService.modificar(peticiondTO);
	}
	
	/**
	 * Permite eliminar un usuario por el identificador
	 * 
	 * @param idUsuario Long que representa el identificador del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion eliminada
	 */
	@DeleteMapping("/{idUsuario}")
	public UsuarioDTO eliminar(@PathVariable("idUsuario") Long idUsuario) {
		return usuarioService.eliminar(idUsuario);
	}
	
	/**
	 * Permite eliminar un usuario por la cedula
	 * 
	 * @param cedula String que representa la cedula del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion eliminada
	 */
	@DeleteMapping("/cedula/{cedula}")
	public UsuarioDTO eliminarPorCedula(@PathVariable("cedula") String cedula) {
		return usuarioService.eliminarPorCedula(cedula);
	}

}
