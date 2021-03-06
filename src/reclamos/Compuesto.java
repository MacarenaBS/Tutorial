/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package reclamos;
/*==================================================*/
/*=====================Imports======================*/
/*==================================================*/
import java.util.List;
/*==================================================*/
/*===================End Imports====================*/
/*==================================================*/
/**
 * @author ezequiel.de-luca
 * @version 1.0
 */
public class Compuesto extends Reclamo
{
	/*==================================================*/
	/*====================Variables=====================*/
	/*==================================================*/
	private List<Reclamo> colReclamos;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Crea un nuevo reclamo compuesto
	 * @param intNumero N�mero de reclamod
	 * @param strDescripcion Descripci�n
	 */
	public Compuesto(String strNumero, String strDescripcion)
	{
		/*==================================================*/
		/*==========Establece el n�mero de reclamo==========*/
		/*==================================================*/
		this.setNumero(strNumero);
		/*==================================================*/
		/*=======Establece la descripci�n del reclamo=======*/
		/*==================================================*/
		this.setDescripcion(strDescripcion);
		/*==================================================*/
		/*==========Crea el reclamo como ingresado==========*/
		/*==================================================*/
		this.setEstado("INGRESADO");
	}
	/*==================================================*/
	/*=================End Constructor==================*/
	/*==================================================*/
	/*==================================================*/
	/*Vincula un reclamo simple con el reclamo compuesto*/
	/*==================================================*/
	/**
	 * Vincula un reclamo Simple con el reclamo actual
	 * @param objReclamo Reclamo
	 */
	public void asociarReclamo(Reclamo objReclamo)
	{
		/*==================================================*/
		/*================Vincula el reclamo================*/
		/*==================================================*/
		this.colReclamos.add(objReclamo);
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/