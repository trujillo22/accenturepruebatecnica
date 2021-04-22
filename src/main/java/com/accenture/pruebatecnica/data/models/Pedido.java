package com.accenture.pruebatecnica.data.models;

import java.util.Date;

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
 * Clase que representa el modelo de la entidad Pedido
 * @author DANIEL
 * @version 1.0 20/04/2021
 *
 */
@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO")
	private Long idPedido;
	
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
	@ManyToOne(optional = false)
	private Usuario idUsuario;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "SUBTOTAL")
	private Float subtotal;
	
	@Column(name = "ESTADO")
	private Long estado;
}
