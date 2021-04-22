package com.accenture.pruebatecnica.utils;

public class Constantes {
	public static final String CONCATENADOR=";";
	
	public static final String DATE_AND_TIME_FORMAT_WITH_MINUTES = "dd/MM/yyyy HH:mm";
	
	public static final String CODIGO_200 = "200";
	public static final String CODIGO_400 = "400";
	
	public static final Float VALOR_MAXIMO_PARA_COBRO_DE_DOMICILIO = 100000F;
	public static final Float VALOR_MINIMO_PARA_COBRO_DE_DOMICILIO = 70000F;
	
	public static final int CANTIDAD_HORAS_MAXIMAS_PERMITIDAS_PARA_MODIFICAR_PEDIDO = 5;
	public static final int CANTIDAD_HORAS_MAXIMAS_PERMITIDAS_PARA_ELIMINAR_PEDIDO = 12;
	
	public static final Long ESTADO_PEDIDO_ACTIVO = 1L;
	public static final String ESTADO_PEIDIDO_ACTIVO_STRING = "Activo";
	public static final Long ESTADO_PEDIDO_CANCELADO = 2L;
	public static final String ESTADO_PEDIDO_CANCELADO_STRING = "Cancelado";
	
	public static final String MENSAJE_CONSULTA_EXITOSA = "Se consulto exitosamente el registro";
	public static final String MENSAJE_CREACION_EXITOSA = "Se creo exitosamente el registro";
	public static final String MENSAJE_CREACION_FALLIDA = "Fallo la creacion del registro";
	public static final String MENSAJE_CREACION_FALLIDA_USUARIO_CEDULA_REPETIDA = "Fallo la creacion del registro de usuario, la cedula ya esta registrada";
	public static final String MENSAJE_REGISTRO_INEXISTENTE = "El registro no existe";
	public static final String MENSAJE_MODIFICACION_EXITOSA = "Se modifico exitosamente el registro";
	public static final String MENSAJE_MODIFICACION_FALLIDA_USUARIO_CEDULA_REPETIDA = "Fallo la modificacion del usuario, la cedula ya esta registrada";
	public static final String MENSAJE_ELIMINACION_EXITOSA = "Se elimino exitosamente el registro";
	public static final String MENSAJE_CANCELACION_EXITOSA = "El pedido no se pudo eliminar por exceso de horas permitidas para la eliminacion, debido a esto fue cancelado";
	public static final String MENSAJE_MODIFICACION_FALLIDA_POR_EXCESO_DE_TIEMPO = "Fallo la modificacion del registro por exceso de horas permitidas para la modificacion";

}
