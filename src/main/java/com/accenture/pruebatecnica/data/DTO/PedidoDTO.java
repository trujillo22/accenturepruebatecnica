package com.accenture.pruebatecnica.data.DTO;

import java.util.List;

import lombok.Data;

/**
 * Clase que representa el DTO de Pedido
 * @author DANIEL
 * @version 20/04/2021
 */
@Data
public class PedidoDTO extends RespuestaDTO {

	private Long idPedido;

	private Long idUsuario;
	
	private String nombreUsuario;
	
	private String fechaCreacion;

	private Float subtotal;
	
	private Long estado;
	
	private String estadoString;
	
	private Float totalIVA;
	
	private Float totalDomicilio;
	
	private Float totalNeto;
	
	/*
	 * Campo utilizado para concatenar los identificadores de los productos que se seleccionaron en el Pedido
	 */
	private String idProductosConcatenados;
	
	private List<ProductoDTO> listaProductos;

}
