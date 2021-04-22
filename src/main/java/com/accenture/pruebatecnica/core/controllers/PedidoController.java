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

import com.accenture.pruebatecnica.core.services.PedidoService;
import com.accenture.pruebatecnica.data.DTO.PedidoDTO;
import com.accenture.pruebatecnica.utils.Constantes;
import com.accenture.pruebatecnica.utils.Utilidades;

/**
 * Clase que represeta el controlador de pedido para acceder a los diferentes metodos expuestos
 * @author DANIEL
 * @version 1.0 21/04/2021
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	/**
	 * Permite consultar todos los pedidos existentes
	 * @return una list de tipo PedidoDTO
	 */
	@GetMapping("")
	public List<PedidoDTO> consultarTodos() {
		return pedidoService.consultarTodos();
	}
	
	/**
	 * Permite consultar un pedido por el identificador del pedido
	 * @param idPedido Long que representa el identificador del pedido
	 * @return un objeto de tipo PedidoDTO
	 */
	@GetMapping("/{idPedido}")
	public PedidoDTO consultarPorIdPedido(@PathVariable("idPedido") Long idPedido) {
		return pedidoService.consultarPorIdPedido(idPedido);
	}
	
	
	@PostMapping("")
	public PedidoDTO guardar(@RequestBody PedidoDTO peticion) {
		peticion.setFechaCreacion(Utilidades.generarFechaActualConFormato(Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES));
		peticion.setEstado(Constantes.ESTADO_PEDIDO_ACTIVO);
		return pedidoService.guardar(peticion);
	}
	
	@PutMapping("")
	public PedidoDTO modificar(@RequestBody PedidoDTO peticion) {
		return pedidoService.modificar(peticion);
	}
	
	@DeleteMapping("/{idPedido}")
	public PedidoDTO eliminar(@PathVariable("idPedido") Long idPedido) {
		return pedidoService.eliminar(idPedido);
	}

}
