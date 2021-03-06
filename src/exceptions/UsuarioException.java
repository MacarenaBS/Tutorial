/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package exceptions;
/**
 * Productos Reading Exception
 * @version 1.0
 * @author ezequiel.de-luca 
 */
public class UsuarioException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2464084130046574150L;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Displays an error Message
	 * @param strMessage Message to be displayed
	 */
	public UsuarioException(String strMessage)
	{
		/*==================================================*/
		/*==============Exceptions Constructor==============*/
		/*==================================================*/
		super(strMessage);
	}
	/*==================================================*/
	/*=================End Constructor==================*/
	/*==================================================*/
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/