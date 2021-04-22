package com.accenture.pruebatecnica.data.DTO;

import lombok.Data;

@Data
public class ProductoDTO extends RespuestaDTO {
	
	private Long idProducto;

	private String nombre;

	private Float valor;
}
