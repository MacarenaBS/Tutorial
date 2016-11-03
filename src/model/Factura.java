/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package model;
/*==================================================*/
/*=====================Imports======================*/
/*==================================================*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*==================================================*/
/*===================End Imports====================*/
/*==================================================*/
/**
 * @author ezequiel.de-luca
 * @version 1.0
 */
public class Factura
{
	/*==================================================*/
	/*====================Variables=====================*/
	/*==================================================*/
	private Integer intNumero;
	private String strDescripcion;
	private Date objFecha;
	private List<ItemFactura> colProductos;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Crea una nueva factura
	 * @param intNumero N�mero de Factura
	 * @param strDescripcion Descripci�n
	 * @param objFecha Fecha de facturaci�n
	 */
	public Factura (Integer intNumero, String strDescripcion, Date objFecha)
	{
		this.setNumero(intNumero);
		this.setDescripcion(strDescripcion);
		this.setFecha(objFecha);
		this.colProductos = new ArrayList<ItemFactura>();
	}
	/*==================================================*/
	/*=================End Constructor==================*/
	/*==================================================*/
	/*==================================================*/
	/*==========Devuelve el n�mero de factura===========*/
	/*==================================================*/
	/**
	 * @return N�mero de factura
	 */
	public Integer getNumero()
	{
		/*==================================================*/
		/*================Devuelve el n�mero================*/
		/*==================================================*/
		return intNumero;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*==========Establece el n�mero de factura==========*/
	/*==================================================*/
	/**
	 * Establece el n�mero de factura.
	 * @param intValue N�mero de factura
	 */
	public void setNumero(Integer intValue)
	{
		/*==================================================*/
		/*===============Establece el n�mero================*/
		/*==================================================*/
		this.intNumero = intValue;
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*======Devuelve la descripci�n de la factura=======*/
	/*==================================================*/
	/**
	 * @return Descripci�n
	 */
	public String getDescripcion()
	{
		/*==================================================*/
		/*==============Devuelve la descipci�n==============*/
		/*==================================================*/
		return strDescripcion;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*======Establece la descipci�n de la factura=======*/
	/*==================================================*/
	/**
	 * Establece la descipci�n de la factura.
	 * @param strValue Descripci�n
	 */
	public void setDescripcion(String strValue)
	{
		/*==================================================*/
		/*=============Establece la descripci�n=============*/
		/*==================================================*/
		this.strDescripcion = strValue;
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*=========Devuelve la fecha de facturaci�n=========*/
	/*==================================================*/
	/**
	 * @return Fecha de facturaci�n
	 */
	public Date getFecha()
	{
		/*==================================================*/
		/*================Devuelve la fecha=================*/
		/*==================================================*/
		return objFecha;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*========Establece la fecha de facturaci�n=========*/
	/*==================================================*/
	/**
	 * Establece la fecha de facturaci�n
	 * @param objValue Fecha de facturaci�n
	 */
	public void setFecha(Date objValue)
	{
		/*==================================================*/
		/*================Establece la fecha================*/
		/*==================================================*/
		this.objFecha = objValue;
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*====Devuelve la lista de productos facturados=====*/
	/*==================================================*/
	/**
	 * @return Lista de productos facturados
	 */
	public List<ItemFactura> getProductos()
	{
		/*==================================================*/
		/*========Devuelve los productos facturados=========*/
		/*==================================================*/
		return colProductos;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*===Agrega un producto a la lista de facturaci�n===*/
	/*==================================================*/
	/**
	 * Agrega un producto a la lista de facturaci�n.
	 * @param objCantidad Producto y cantidad a facturar
	 */
	public void addProducto(ItemFactura objCantidad)
	{
		/*==================================================*/
		/*=====Agrega un producto y cantidad solicitada=====*/
		/*==================================================*/
		this.getProductos().add(objCantidad);
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*=====================Add Item=====================*/
	/*==================================================*/
	public void addItem(Producto objProducto, Integer intCantidad)
	{
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		ItemFactura objItem;
		/*==================================================*/
		/*====================Crear Item====================*/
		/*==================================================*/
		objItem = new ItemFactura(objProducto, intCantidad);
		/*==================================================*/
		/*================Agregar a la Lista================*/
		/*==================================================*/
		this.colProductos.add(objItem);
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*======================Equals======================*/
	/*==================================================*/
	public boolean equals(Factura objFactura)
	{
		/*==================================================*/
		/*==================Return Results==================*/
		/*==================================================*/
		return (this.getNumero() == objFactura.getNumero());
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/