package com.accenture.pruebatecnica.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebatecnica.data.DTO.PedidoDTO;
import com.accenture.pruebatecnica.data.DTO.PedidoDetalleDTO;
import com.accenture.pruebatecnica.data.DTO.ProductoDTO;
import com.accenture.pruebatecnica.data.services.PedidoDataService;
import com.accenture.pruebatecnica.data.services.PedidoDetalleDataService;
import com.accenture.pruebatecnica.data.services.ProductoDataService;
import com.accenture.pruebatecnica.utils.Constantes;
import com.accenture.pruebatecnica.utils.Utilidades;

/**
 * Clase que contiene toda la logica de negocio para Pedido
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
@Service
public class PedidoService {
	
	@Autowired
	private PedidoDataService pedidoDataService;
	
	@Autowired
	private ProductoDataService productoDataService;
	
	@Autowired
	private PedidoDetalleDataService pedidoDetalleDataService;
	
	/**
	 * Permite consultar todos los pedidos existentes
	 * @return una list de tipo PedidoDTO
	 */
	public List<PedidoDTO> consultarTodos() {
		List<PedidoDTO> listaPedidos = pedidoDataService.consultarTodos();
		
		for (PedidoDTO pedidoDTOTemp : listaPedidos) {
			setProductosToPedido(pedidoDTOTemp);
		}
		return listaPedidos;
	}
	
	/**
	 * Permite consultar un pedido por el identificador del pedido
	 * @param idPedido Long que representa el identificador del pedido
	 * @return un objeto de tipo PedidoDTO
	 */
	public PedidoDTO consultarPorIdPedido(Long idPedido) {
		PedidoDTO respuesta = pedidoDataService.consultarPorId(idPedido);
		
		if (respuesta != null && respuesta.getIdPedido() != null) {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CONSULTA_EXITOSA,
					respuesta);
			setProductosToPedido(respuesta);
		} else {
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE,
					respuesta);
		}
		
		return respuesta;
	}
	
	/**
	 * Permite guardar un pedido
	 * @param pedidoDTO objeto de tipo PedidoDTO con la informacion a guardar
	 * @return un objeto de tipo pedidoDTO con la informacion guardada
	 */
	public PedidoDTO guardar(PedidoDTO pedidoDTO) {
		calcularValorDelPedido(pedidoDTO);
		
		PedidoDTO respuesta = pedidoDataService.guardar(pedidoDTO);
		
		String[] arregloIdProductos = pedidoDTO.getIdProductosConcatenados().split(Constantes.CONCATENADOR);
		
		for (String idProductoTemp : arregloIdProductos) {
			
			Long idProductoAuxLong = new Long(idProductoTemp);
			PedidoDetalleDTO pedidoDetalleDTOAux = new PedidoDetalleDTO(null, respuesta.getIdPedido(), idProductoAuxLong);			
			pedidoDetalleDataService.guardar(pedidoDetalleDTOAux);
		}
		
		respuesta = consultarPorIdPedido(respuesta.getIdPedido());
		Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CREACION_EXITOSA, respuesta);
		return respuesta;
	}
	
	public PedidoDTO modificar(PedidoDTO pedidoDTO) {
		PedidoDTO respuesta = new PedidoDTO();
		PedidoDTO pedidoDTOAnterior = pedidoDataService.consultarPorId(pedidoDTO.getIdPedido());
		
		if (pedidoDTOAnterior != null && pedidoDTOAnterior.getIdPedido() != null)
		{
			String fechaActual = Utilidades.generarFechaActualConFormato(Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES);
			int cantidadHorasEntreFechas = Utilidades.diferenciaEnHorasEntreFechas(pedidoDTOAnterior.getFechaCreacion(), fechaActual, Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES);
			
			if(cantidadHorasEntreFechas <= Constantes.CANTIDAD_HORAS_MAXIMAS_PERMITIDAS_PARA_MODIFICAR_PEDIDO)
			{
				pedidoDetalleDataService.eliminarTodosPorIdPedido(pedidoDTOAnterior.getIdPedido());
				pedidoDTO.setFechaCreacion(pedidoDTOAnterior.getFechaCreacion());
				pedidoDTO.setEstado(pedidoDTOAnterior.getEstado());
				pedidoDTO.setIdUsuario(pedidoDTOAnterior.getIdUsuario());
				respuesta = guardar(pedidoDTO);
				
				Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_MODIFICACION_EXITOSA, respuesta);
			}
			else
			{
				Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_MODIFICACION_FALLIDA_POR_EXCESO_DE_TIEMPO, respuesta);
			}
		}
		else
		{
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE, respuesta);
		}
		
		return respuesta;
	}
	
	public PedidoDTO eliminar(Long idPedido)
	{
		PedidoDTO respuesta = consultarPorIdPedido(idPedido);
		
		if (respuesta != null && respuesta.getIdPedido() != null)
		{
			String fechaActual = Utilidades.generarFechaActualConFormato(Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES);
			int cantidadHorasEntreFechas = Utilidades.diferenciaEnHorasEntreFechas(respuesta.getFechaCreacion(), fechaActual, Constantes.DATE_AND_TIME_FORMAT_WITH_MINUTES);
			
			if(cantidadHorasEntreFechas <= Constantes.CANTIDAD_HORAS_MAXIMAS_PERMITIDAS_PARA_ELIMINAR_PEDIDO)
			{
				pedidoDetalleDataService.eliminarTodosPorIdPedido(idPedido);
				pedidoDataService.eliminar(idPedido);
				
				Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_ELIMINACION_EXITOSA, respuesta);
			}
			else
			{
				respuesta.setEstado(Constantes.ESTADO_PEDIDO_CANCELADO);
				respuesta = guardar(respuesta);
				Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_200, Constantes.MENSAJE_CANCELACION_EXITOSA, respuesta);
			}
		}
		else
		{
			Utilidades.setCodigoYMensajeDeRespuesta(Constantes.CODIGO_400, Constantes.MENSAJE_REGISTRO_INEXISTENTE, respuesta);
		}
		
		return respuesta;
	}
	
	private void setProductosToPedido(PedidoDTO pedidoDTO) {		
		List<ProductoDTO> listaProductos = productoDataService.consultarTodosProductosDeUnPedido(pedidoDTO.getIdPedido());		
		StringBuilder idProductosConcatenados = new StringBuilder("");
		String concatenador = "";
		for (ProductoDTO productoDTO : listaProductos) {
			idProductosConcatenados.append(String.format("%s%s", concatenador,productoDTO.getIdProducto().toString()));
			concatenador = Constantes.CONCATENADOR;
		}
		
		pedidoDTO.setListaProductos(listaProductos);
		pedidoDTO.setIdProductosConcatenados(idProductosConcatenados.toString());
	}
	
	private void calcularValorDelPedido(PedidoDTO pedidoDTO) {
		String[] arregloIdProductos = pedidoDTO.getIdProductosConcatenados().split(Constantes.CONCATENADOR);
		
		Float subtotalTemp = new Float(0);
		
		for (String idProductoTemp : arregloIdProductos) {			
			Long idProductoAuxLong = new Long(idProductoTemp);			
			ProductoDTO productoDTOAux = productoDataService.consultarPorIdProducto(idProductoAuxLong);
			
			subtotalTemp = subtotalTemp + productoDTOAux.getValor();			
		}
		
		pedidoDTO.setSubtotal(subtotalTemp);
	}

}
