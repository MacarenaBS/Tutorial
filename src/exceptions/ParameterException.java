/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package exceptions;
/**
 * Configuration File Parameter Reading Exception
 * @version 1.0
 * @author ezequiel.de-luca 
 */
public class ParameterException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1313079946797634642L;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Displays an error Message
	 * @param strMessage Message to be displayed
	 */
	public ParameterException(String strMessage)
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