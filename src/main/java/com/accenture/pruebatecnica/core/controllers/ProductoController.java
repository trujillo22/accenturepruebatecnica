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

import com.accenture.pruebatecnica.core.services.ProductoService;
import com.accenture.pruebatecnica.data.DTO.ProductoDTO;

/**
 * Clase que represeta el controlador de Producto para acceder a los diferentes metodos expuestos
 * @author DANIEL
 * @version 1.0 21/04/2021
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	/**
	 * Permite consultar todos los productos existentes
	 * @return una list de tipo ProductoDTO
	 */
	@GetMapping("")
	public List<ProductoDTO> consultarTodos() {
		return productoService.consultarTodos();
	}
	
	/**
	 * Permite consultar un producto por su identificador
	 * @param idProducto Long que representa el identificador del producto
	 * @return un objeto de tipo ProductoDTO
	 */
	@GetMapping("/{idProducto}")
	public ProductoDTO consultarPorIdProducto(@PathVariable("idProducto") Long idProducto) {
		return productoService.consultarPorIdProducto(idProducto);
	}
	
	/**
	 * Permite guardar un producto nuevo
	 * 
	 * @param productoDTO Objeto de tipo ProductoDTO con la informacion a guardar
	 * @return un objeto de tipo ProductoDTO con la informacion guardada
	 */
	@PostMapping("")
	public ProductoDTO guardar(@RequestBody ProductoDTO peticion) {
		return productoService.guardar(peticion);
	}
	
	/**
	 * Permite modificar un producto existente
	 * 
	 * @param productoDTO Objeto de tipo ProductoDTO con la informacion a modificar
	 * @return un objeto de tipo ProductoDTO con la informacion modificada
	 */
	@PutMapping("")
	public ProductoDTO modificar(@RequestBody ProductoDTO peticion) {
		return productoService.modificar(peticion);
	}
	
	/**
	 * Permite eliminar un producto por el identificador
	 * 
	 * @param idProducto Long que representa el identificador del producto
	 * @return un objeto de tipo ProductoDTO con la informacion modificada
	 */
	@DeleteMapping("/{idProducto}")
	public ProductoDTO eliminar(@PathVariable("idProducto") Long idProducto) {		
		return productoService.eliminar(idProducto);
	}
}
