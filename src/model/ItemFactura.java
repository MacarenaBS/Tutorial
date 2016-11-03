/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package model;
/**
 * @author ezequiel.de-luca
 * @version 1.0
 */
public class ItemFactura
{
	/*==================================================*/
	/*====================Variables=====================*/
	/*==================================================*/
	private Producto objProducto;
	private Integer intCantidad;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Crea un vincula de Producto con unidades solicitadas
	 * @param objProducto Producto
	 * @param intCantidad Cantidad de producto solicitada
	 */
	public ItemFactura(Producto objProducto, Integer intCantidad)
	{
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		this.setProducto(objProducto);
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		this.setCantidad(intCantidad);
	}
	/*==================================================*/
	/*=================End Constructor==================*/
	/*==================================================*/
	/*==================================================*/
	/*==========Devuelve el producto asociado===========*/
	/*==================================================*/
	/**
	 * @return Producto
	 */
	public Producto getProducto()
	{
		/*==================================================*/
		/*===============Devuelve el producto===============*/
		/*==================================================*/
		return objProducto;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*==========Establece el producto asociado==========*/
	/*==================================================*/
	/**
	 * @param objValue Producto a asociar
	 */
	public void setProducto(Producto objValue)
	{
		/*==================================================*/
		/*==============Establece el producto===============*/
		/*==================================================*/
		this.objProducto = objValue;
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*===Devuelve la cantidad solicitada del producto===*/
	/*==================================================*/
	/**
	 * @return Cantidad solicitada del producto
	 */
	public Integer getCantidad()
	{
		/*==================================================*/
		/*===============Devuelve la cantidad===============*/
		/*==================================================*/
		return intCantidad;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*==Establece la cantidad solicitada del producto===*/
	/*==================================================*/
	/**
	 * @param intValue Cantidad solicitada del producto
	 */
	public void setCantidad(Integer intValue)
	{
		/*==================================================*/
		/*==============Establece la cantidad===============*/
		/*==================================================*/
		this.intCantidad = intValue;
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/