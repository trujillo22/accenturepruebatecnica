package com.accenture.pruebatecnica.data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.pruebatecnica.data.DTO.ProductoDTO;
import com.accenture.pruebatecnica.data.mappers.ProductoMapper;
import com.accenture.pruebatecnica.data.models.Producto;
import com.accenture.pruebatecnica.data.repositories.IProductoRepository;

/**
 * Clase que encapsula la consulta por medio del repositorio y la transformacion de Entidades a DTO de los Pedido
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Component
public class ProductoDataService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	/**
	 * Permite consultar todos los productos existentes
	 * @return una list de tipo ProductoDTO
	 */
	public List<ProductoDTO> consultarTodos() {
		return productoMapper.transformEntitiesToDTO((List<Producto>) productoRepository.findAll());
	}
	
	/**
	 * Permite consultar todos los productos que esten relacionados al pedido identificado con el id pasado como parametro
	 * @param idPedido Long que representa el identificador del pedido
	 * @return una lista de tipo ProductoDTO
	 */
	public List<ProductoDTO> consultarTodosProductosDeUnPedido(Long idPedido) {
		return productoMapper.transformEntitiesToDTO(productoRepository.consultarTodosProductosDeUnPedido(idPedido));
	}
	
	/**
	 * Permite consultar un producto por su identificador
	 * @param idProducto Long que representa el identificador del producto
	 * @return un objeto de tipo ProductoDTO
	 */
	public ProductoDTO consultarPorIdProducto(Long idProducto) {
		Optional<Producto> producto = productoRepository.findById(idProducto);
		return producto.isPresent() ? productoMapper.transformEntityToDTO(producto.get()) : new ProductoDTO();
	}
	
	/**
	 * Permite guardar un producto nuevo
	 * @param productoDTO Objeto de tipo ProductoDTO con la informacion a guardar
	 * @return un objeto de tipo ProductoDTO con la informacion guardada
	 */
	public ProductoDTO guardar(ProductoDTO productoDTO) {
		return productoMapper.transformEntityToDTO(productoRepository.save(productoMapper.transformDTOToEntity(productoDTO)));
	}
	
	/**
	 * Permite eliminar un producto por el identificador
	 * @param idProducto Long que representa el identificador del producto
	 */
	public void eliminar(Long idProducto) {		
		productoRepository.deleteById(idProducto);
	}

}
