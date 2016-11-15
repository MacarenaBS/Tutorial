package controlador;

import java.util.Vector;

import connections.UsuariosDAO;
import exceptions.ConnectionException;
import exceptions.ParameterException;
import exceptions.UsuarioException;
import usuarios.*;
import usuarios.Usuario;

public class Controlador {
	
	private Usuario objUsuario;
	private static Controlador instance;
	private Vector<Rol> roles;
	
	private Controlador(){
		
		Administrador admin = new Administrador();
		roles.add(admin);
		CallCenter callCenter = new CallCenter();
		roles.add(callCenter);
		Consulta consulta= new Consulta();
		roles.add(consulta);
		ResponsableDistribucion rDistribucion= new ResponsableDistribucion();
		roles.add(rDistribucion);
		ResponsableFacturacion rFacturacion= new ResponsableFacturacion();
		roles.add(rFacturacion);
		ResponsableZonaDeEntrega rZonaDeEntrega= new ResponsableZonaDeEntrega();
		roles.add(rZonaDeEntrega);
		
		
	}
	
	public static Controlador getInstance(){
		
		if (instance == null)
		{
			instance= new Controlador();
		}
		return instance; 
	}
	
	private Usuario getUser(String strUsername) throws ConnectionException, ParameterException, UsuarioException{
		return UsuariosDAO.getInstance().getUsuario(strUsername);
	}
	
//	private boolean verificacionPasswordUsuario(String strUsername, String strPassword){
//		return objUsuario.passwordVerificacion(strUsername, strPassword);
//	}
	
	public boolean Connect(String strUsername, String strPassword) throws ConnectionException, ParameterException, UsuarioException{

		try{
			Usuario s= getUser(strUsername);
			this.objUsuario= s;
			
			if (this.objUsuario.passwordVerificacion(strUsername,strPassword)){
				System.out.println("Connection succesful - Welcome "+s.getStrUsername());
				return true;
			}
			else
			{
				System.out.println("Connection unsuccesful - Username or Password incorrect.");
				this.objUsuario=null;
				return false;
			}
		}
		catch(UsuarioException ex)
		{
			return false;
		}
		
		
		
	}
	
	public Usuario currentUser(){
		return this.objUsuario;
	}
	
	public void disconnect(){
		this.objUsuario=null;
	}
	
	public boolean crearUsuario(String strUsername, String strPassword, String strPermiso)
	{
		
		Usuario s= new Usuario(strUsername, strPassword, strPermiso);
		try {
			UsuariosDAO.getInstance().insertar(s);
		} catch (ConnectionException | ParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		for (Rol rol: roles)
		{
			if (rol.getClass().getSimpleName() == strPermiso)
			{
				rol.addUsuario(s);
			}
		}
		
		return true;
		
	}
	
	public boolean eliminarUsuario(String strUsername)
	{
		Usuario s;
		
		try {
			s = UsuariosDAO.getInstance().getUsuario(strUsername);
		} catch (ConnectionException | ParameterException | UsuarioException e) {
			System.out.println("Controlador - eliminarUsuario - "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		try {
			UsuariosDAO.getInstance().eliminar(s);
			
			for (Rol rol: roles)
			{
				if (rol.getClass().getSimpleName() == s.getRol())
				{
					rol.removeUsuario(s);
				}
			}
			
		} catch (ConnectionException | ParameterException e) {
			System.out.println("Controlador - eliminarUsuario - "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean modificarUsuario(String strUsername, String strPassword, String strRol)
	{
		try 
		{
			Usuario s= UsuariosDAO.getInstance().getUsuario(strUsername);
			s.setStrPassword(strPassword);
			s.setRol(strRol);
			UsuariosDAO.getInstance().modificarUsuario(s);
			
			for (Rol rol: roles)
			{
				if (rol.getClass().getSimpleName() == s.getRol())
				{
					rol.removeUsuario(s);
					rol.addUsuario(s);
				}
			}
			
			return true;
		} catch (ConnectionException | ParameterException | UsuarioException e) {
			System.out.println("Controlador - modificarUsuario - "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	

		
		
}
