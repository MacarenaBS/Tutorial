/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package usuarios;
/*==================================================*/
/*=====================Imports======================*/
/*==================================================*/
import java.util.List;
import reclamos.Reclamo;
/*==================================================*/
/*===================End Imports====================*/
/*==================================================*/
/**
 * @author ezequiel.de-luca
 * @version 1.0
 */
public abstract class Rol
{
	/*==================================================*/
	/*====================Variables=====================*/
	/*==================================================*/
	protected List<Usuario> colUsuarios;
	protected List<Reclamo> colReclamos;
	/*==================================================*/
	/*===============Administrar Reclamo================*/
	/*==================================================*/
	/**
	 * Ejecuta una nueva acci�n sobre un reclamo existente.
	 * @param strNroReclamo N�mero de reclamo sobre el cual realizar la acci�n
	 */
	public abstract void administrarReclamo(String strNumero, String strDescipcion);
	/*==================================================*/
	/*==================Cerrar Reclamo==================*/
	/*==================================================*/
	/**
	 * Cierra un reclamo en curso.
	 * @param strNumero N�mero del reclamo a cerrar
	 */
	public abstract void cerrarReclamo(String strNumero);
	
	public void addUsuario(Usuario us)
	{
		if (!this.colUsuarios.contains(us))
		{
			this.colUsuarios.add(us);
		}
	}
	
	public void removeUsuario(Usuario us)
	{
		for (Usuario usuario : colUsuarios)
		{
			if (us.getStrUsername().equals(usuario.getStrUsername()))
			{
				this.colUsuarios.remove(us);
			}
		}
	}
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/
