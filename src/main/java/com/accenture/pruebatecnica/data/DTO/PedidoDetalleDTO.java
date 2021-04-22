package com.accenture.pruebatecnica.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDetalleDTO extends RespuestaDTO {
	
	private Long idPedidoDetalle;
	
	private Long idPedido;
	
	private Long idProducto;

}
