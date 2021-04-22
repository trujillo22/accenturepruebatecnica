package com.accenture.pruebatecnica.utils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.accenture.pruebatecnica.data.DTO.RespuestaDTO;

/**
 * Clase que contiene metodos que pueden comunines y utilizados en cualquiera de los servicios
 * @author DANIEL
 * @version 1.0 20/04/2021
 */
public class Utilidades {
	
	public static String generarFechaActualConFormato(String formato) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		return dateFormat.format(new Date());
	}
	
	public static void setCodigoYMensajeDeRespuesta(String codigo, String mensaje, RespuestaDTO objetoDTO) {
		objetoDTO.setCodigoRespuesta(codigo);
		objetoDTO.setMensajeRespuesta(mensaje);
	}
	
	public static int diferenciaEnHorasEntreFechas(String fechaInicio, String fechaFin, String formato) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(formato);
		LocalDateTime fechaInicioDate = LocalDateTime .parse(fechaInicio, df);
		LocalDateTime  fechaFinDate = LocalDateTime .parse(fechaFin, df);
		
		Duration duration = Duration.between(fechaInicioDate, fechaFinDate);
		
		return (int) duration.toHours();
	}

}
