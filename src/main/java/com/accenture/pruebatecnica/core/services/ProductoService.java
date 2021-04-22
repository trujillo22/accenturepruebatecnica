package com.accenture.pruebatecnica.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebatecnica.data.DTO.ProductoDTO;
import com.accenture.pruebatecnica.data.DTO.UsuarioDTO;
import com.accenture.pruebatecnica.data.services.ProductoDataService;
import com.accenture.pruebatecnica.utils.Constantes;
import com.accenture.pruebatecnica.utils.Utilidades;

/**
 * Clase que contiene toda la logica de negocio para Producto
 * 
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Service
public class ProductoService {

	@Autowired
	ProductoDataService productoDataService;

	/**
	 * Permite consultar todos los productos existentes
	 * 
	 * @return una list de tipo ProductoDTO
	 */
	public List<ProductoDTO> consultarTodos() {
		return productoDataService.consultarTodos();
	}

	/**
	 * Permite consultar un producto por su identificador
	 * 
	 * @param idProducto Long que representa el identificador del producto
	 * @return un objeto de tipo ProductoDTO
	 */
	public ProductoDTO consultarPorIdProducto(Long idProducto) {
		ProductoDTO respuesta = productoDataService.consultarPorIdProducto(idProducto);
		if (respuesta != null && respuesta.getIdProducto() != null) {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CONSULTA_EXITOSA,
					respuesta);
		} else {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}

		return respuesta;
	}

	/**
	 * Permite guardar un producto nuevo
	 * 
	 * @param productoDTO Objeto de tipo ProductoDTO con la informacion a guardar
	 * @return un objeto de tipo ProductoDTO con la informacion guardada
	 */
	public ProductoDTO guardar(ProductoDTO productoDTO) {
		ProductoDTO respuesta = productoDataService.guardar(productoDTO);
		Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CREACION_EXITOSA, respuesta);
		return respuesta;
	}

	/**
	 * Permite modificar un producto existente
	 * 
	 * @param productoDTO Objeto de tipo ProductoDTO con la informacion a modificar
	 * @return un objeto de tipo ProductoDTO con la informacion modificada
	 */
	public ProductoDTO modificar(ProductoDTO productoDTO) {
		ProductoDTO respuesta = productoDataService.consultarPorIdProducto(productoDTO.getIdProducto());

		if (respuesta != null && respuesta.getIdProducto() != null) {

			respuesta = productoDataService.guardar(productoDTO);
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_MODIFICACION_EXITOSA,
					respuesta);
		} else {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}

		return respuesta;
	}

	/**
	 * Permite eliminar un producto por el identificador
	 * 
	 * @param idProducto Long que representa el identificador del producto
	 * @return un objeto de tipo ProductoDTO con la informacion modificada
	 */
	public ProductoDTO eliminar(Long idProducto) {		
		ProductoDTO respuesta = productoDataService.consultarPorIdProducto(idProducto);
		
		if (respuesta != null && respuesta.getIdProducto()!= null) {
			productoDataService.eliminar(idProducto);
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
