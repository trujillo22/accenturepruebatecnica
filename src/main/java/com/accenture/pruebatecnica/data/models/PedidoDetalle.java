package com.accenture.pruebatecnica.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase que representa el modelo de la entidad PRODUCTO_DETALLE.
 * 
 * Representa la entidad intermedia de la relacion muchos a muchos entre PEDIDO y PRODUCTO.
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Data
@Entity
@Table(name = "PEDIDO_DETALLE")
public class PedidoDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO_DETALLE")
	private Long idPedidoDetalle;
	
	@JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
	@ManyToOne(optional = false)
	private Pedido idPedido;
	
	@JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
	@ManyToOne(optional = false)
	private Producto idProducto;

}
