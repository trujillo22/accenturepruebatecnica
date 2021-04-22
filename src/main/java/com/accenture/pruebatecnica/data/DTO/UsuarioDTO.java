package com.accenture.pruebatecnica.data.DTO;

import lombok.Data;

/**
 * Clase que representa el DTO de Usuario
 * @author DANIEL
 * @version 20/04/2021
 */
@Data
public class UsuarioDTO extends RespuestaDTO {

	private Long idUsuario;

	private String cedula;

	private String nombre;

	private String direccion;

	private String telefono;
}
