package com.accenture.pruebatecnica.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebatecnica.data.DTO.RespuestaDTO;
import com.accenture.pruebatecnica.data.DTO.UsuarioDTO;
import com.accenture.pruebatecnica.data.models.Usuario;
import com.accenture.pruebatecnica.data.services.UsuarioDataService;
import com.accenture.pruebatecnica.utils.Constantes;
import com.accenture.pruebatecnica.utils.Utilidades;

/**
 * Clase que contiene toda la logica de negocio para Usuario
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioDataService usuarioDataService;

	/**
	 * Permite obtener la lista de todos los usuarios existentes
	 * 
	 * @return una list de tipo UsuarioDTO
	 */
	public List<UsuarioDTO> consultarTodos() {
		return usuarioDataService.consultarTodos();
	}

	/**
	 * Permite consultar un usuario por el id del usario (El id es diferente que la
	 * cedula)
	 * 
	 * @param idUsuario Long que representa el identificador del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	public UsuarioDTO consultarPorIdUsuario(Long idUsuario) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorIdUsuario(idUsuario);
		if (respuesta != null && respuesta.getIdUsuario() != null) {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CONSULTA_EXITOSA,
					respuesta);
		} else {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}

		return respuesta;
	}

	/**
	 * Permite consultar un usuario por la cedula del usuario
	 * 
	 * @param cedula String que represneta la cedula del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion correspondiente
	 */
	public UsuarioDTO consultarPorCedula(String cedula) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorCedula(cedula);
		if (respuesta != null && respuesta.getIdUsuario() != null) {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CONSULTA_EXITOSA,
					respuesta);
		} else {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}

		return respuesta;
	}

	/**
	 * Permite guardar un usuario nuevo
	 * 
	 * @param usuarioDTO Objeto de tipo UsuarioDTO con la informacion a guardar
	 * @return un objeto de tipo UsuarioDTO con la informacion guardada
	 */
	public UsuarioDTO guardar(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorCedula(usuarioDTO.getCedula());

		if (respuesta != null && respuesta.getIdUsuario() != null) {
			respuesta = new UsuarioDTO();
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400,
					Constantes.MENSAJE_CREACION_FALLIDA_USUARIO_CEDULA_REPETIDA, respuesta);
		} else {
			respuesta = usuarioDataService.guardar(usuarioDTO);
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CREACION_EXITOSA,
					respuesta);
		}
		return respuesta;
	}

	/**
	 * Permite modificar un usuario existente
	 * 
	 * @param usuarioDTO Objeto de tipo UsuarioDTO con la informacion a modificar
	 * @return un objeto de tipo UsuarioDTO con la informacion modificada
	 */
	public UsuarioDTO modificar(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorIdUsuario(usuarioDTO.getIdUsuario());
		
		if (respuesta != null && respuesta.getIdUsuario() != null) {
			UsuarioDTO respuestaAux = usuarioDataService.consultarPorCedula(usuarioDTO.getCedula());
			
			if (respuestaAux != null && respuestaAux.getIdUsuario() != null)
			{
				if (respuesta.getIdUsuario().equals(respuestaAux.getIdUsuario()))
				{
					respuesta = usuarioDataService.guardar(usuarioDTO);
					Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_MODIFICACION_EXITOSA,
							respuesta);
				}
				else
				{
					respuesta = new UsuarioDTO();
					Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400,
							Constantes.MENSAJE_MODIFICACION_FALLIDA_USUARIO_CEDULA_REPETIDA, respuesta);
				}
			}
			else
			{
				respuesta = usuarioDataService.guardar(usuarioDTO);
				Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_MODIFICACION_EXITOSA,
						respuesta);
			}
		}
		else
		{
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}
		
		return respuesta;
	
	}

	/**
	 * Permite eliminar un usuario por el identificador
	 * 
	 * @param idUsuario Long que representa el identificador del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion eliminada
	 */
	public UsuarioDTO eliminar(Long idUsuario) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorIdUsuario(idUsuario);
		
		if (respuesta != null && respuesta.getIdUsuario() != null) {
			usuarioDataService.eliminar(idUsuario);
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_ELIMINACION_EXITOSA,
						respuesta);
		}
		else
		{
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}
		
		return respuesta;
		
		
	}

	/**
	 * Permite eliminar un usuario por la cedula
	 * 
	 * @param cedula String que representa la cedula del usuario
	 * @return un objeto de tipo UsuarioDTO con la informacion eliminada
	 */
	public UsuarioDTO eliminarPorCedula(String cedula) {
		UsuarioDTO respuesta = usuarioDataService.consultarPorCedula(cedula);
		
		if (respuesta != null && respuesta.getIdUsuario() != null) {
			usuarioDataService.eliminarPorCedula(cedula);
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_ELIMINACION_EXITOSA,
						respuesta);
		}
		else
		{
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}
		
		return respuesta;
		
	}

}
