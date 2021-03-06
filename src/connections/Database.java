/*==================================================*/
/*=====================Package======================*/
/*==================================================*/
package connections;
/*==================================================*/
/*=====================Imports======================*/
/*==================================================*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*==================================================*/
/*===================End Imports====================*/
/*==================================================*/
/**
 * SQLServer Database Connection Object
 * @version 1.0
 * @author ezequiel.de-luca 
 */
public class Database
{
	/*==================================================*/
	/*====================Variables=====================*/
	/*==================================================*/
	private Connection objConnection;
	/*==================================================*/
	/*===================Constructor====================*/
	/*==================================================*/
	/**
	 * Create a new connection to a specific SQLServer database instance.
	 * @param strServerName Database Server Name
	 * @param strInstance SQL Server Instance
	 */
	public Database(String strServerName, String strInstance, String strUsername, String strPassword)
	{
		/*==================================================*/
		/*===============Set Connection Value===============*/
		/*==================================================*/
		this.setConnection(strServerName, strInstance, strUsername, strPassword);
	}
	/*==================================================*/
	/*=================End Constructor==================*/
	/*==================================================*/
	/*==================================================*/
	/*==================Set Connection==================*/
	/*==================================================*/
	/**
	 * Set the connection to the specified SQLServer database instance.
	 * @param strServerName Database Server Name
	 * @param strInstance SQL Server Instance
	 * @param strUsername Username to initiate a connection to the database
	 * @param strPassword Password asociated to the previous username
	 */
	private void setConnection(String strServerName, String strInstance, String strUsername, String strPassword)
	{
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		String strConnectionURL;
	    /*==================================================*/
	    /*===============Initialize Variables===============*/
	    /*==================================================*/
	    this.objConnection = null;
	    /*==================================================*/
	    /*=============Check SQL Server Drivers=============*/
	    /*==================================================*/
	    try
	    {
	    	/*==================================================*/
	    	/*===========Load JDBC SQL Server Drivers===========*/
	    	/*==================================================*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/*==================================================*/
			/*=============Create Connection String=============*/
			/*==================================================*/
//		    strConnectionURL = "jdbc:microsoft:sqlserver://" + strServerName + ";DatabaseName=" + strInstance;
			strConnectionURL= "jdbc:sqlserver://"+strServerName+":1433;DatabaseName="+strInstance+";user="+strUsername+";Password="+strPassword;
		    /*==================================================*/
		    /*=================Check Connection=================*/
		    /*==================================================*/
		    try
		    {
		    	/*==================================================*/
		    	/*==================Get Connection==================*/
		    	/*==================================================*/
		    	this.objConnection = DriverManager.getConnection(strConnectionURL);
		    }
		    /*==================================================*/
		    /*=============Catch Connection Errors==============*/
		    /*==================================================*/
		    catch (Exception objException)
		    {
		    	/*==================================================*/
		    	/*===================Show Message===================*/
			    /*==================================================*/
				System.out.println("connection to the database could not be established");
		    }
		}
	    /*==================================================*/
	    /*==========Catch SQL Server Driver Errors==========*/
	    /*==================================================*/
	    catch (ClassNotFoundException objException)
	    {
	    	/*==================================================*/
	    	/*===================Show Message===================*/
		    /*==================================================*/
			System.out.println("SQL Server Drivers could not be loaded");
		}
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*==================Get Connection==================*/
	/*==================================================*/
	/**
	 * @return SQLServer Database Instance Connection
	 */
	public Connection getConnection()
	{
		/*==================================================*/
		/*================Return Connection=================*/
		/*==================================================*/
		return this.objConnection;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*==================Get ResultSet===================*/
	/*==================================================*/
	/**
	 * Retrieves a query resultset.
	 * @param strQuery SQL Query
	 * @return ResultSet
	 * @throws SQLException Query was not properly defined
	 */
	public ResultSet getResultSet(String strQuery) throws SQLException
	{
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		Statement objStatement;
		ResultSet objResultSet;
		/*==================================================*/
	    /*===============Initialize Variables===============*/
	    /*==================================================*/
		objResultSet = null;
		/*==================================================*/
		/*=================Check Statement==================*/
		/*==================================================*/
		try
		{
			/*==================================================*/
			/*===============Create SQL Statement===============*/
			/*==================================================*/
			objStatement = this.getConnection().createStatement();
			/*==================================================*/
	    	/*===================Show Message===================*/
		    /*==================================================*/
			System.out.println("SQL statement successfully created");
			/*==================================================*/
			/*==============Check Query Execution===============*/
			/*==================================================*/
			try
			{
				/*==================================================*/
				/*==============Execute SQL Statement===============*/
				/*==================================================*/
				objResultSet = objStatement.executeQuery(strQuery);
				/*==================================================*/
		    	/*===================Show Message===================*/
			    /*==================================================*/
				System.out.println("SQL statement successfully executed");
			}
			/*==================================================*/
			/*===========Catch Query Execution Errors===========*/
			/*==================================================*/
			catch (Exception objException)
			{
				/*==================================================*/
		    	/*===================Show Message===================*/
			    /*==================================================*/
				System.out.println("SQL statement execution failed: "+objException.getMessage());
				throw new SQLException(objException.getMessage());
			}
		}
		/*==================================================*/
		/*=========Catch Statement Creation Errors==========*/
		/*==================================================*/
		catch (Exception objException)
		{
			/*==================================================*/
	    	/*===================Show Message===================*/
		    /*==================================================*/
			System.out.println("SQL statement could not be created: "+objException.getMessage());
			throw new SQLException(objException.getMessage());
		}
		/*==================================================*/
		/*=================Return ResulsSet=================*/
		/*==================================================*/
		return objResultSet;
	}
	/*==================================================*/
	/*===================End Function===================*/
	/*==================================================*/
	/*==================================================*/
	/*==================Execute Query===================*/
	/*==================================================*/
	/**
	 * Execute a query on the database.
	 * @param strQuery SQL Query
	 * @throws SQLException Query was not properly defined
	 */
	public void executeQuery(String strQuery) throws SQLException
	{
		/*==================================================*/
		/*====================Variables=====================*/
		/*==================================================*/
		Statement objStatement;
		/*==================================================*/
		/*=================Check Statement==================*/
		/*==================================================*/
		try
		{
			/*==================================================*/
			/*===============Create SQL Statement===============*/
			/*==================================================*/
			objStatement = this.getConnection().createStatement();
			/*==================================================*/
	    	/*===================Show Message===================*/
		    /*==================================================*/
			System.out.println("SQL statement successfully created");
			/*==================================================*/
			/*==============Check Query Execution===============*/
			/*==================================================*/
			try
			{
				/*==================================================*/
				/*==============Execute SQL Statement===============*/
				/*==================================================*/
				objStatement.execute(strQuery);
				/*==================================================*/
		    	/*===================Show Message===================*/
			    /*==================================================*/
				System.out.println("SQL statement successfully executed");
			}
			/*==================================================*/
			/*===========Catch Query Execution Errors===========*/
			/*==================================================*/
			catch (Exception objException)
			{
				/*==================================================*/
		    	/*===================Show Message===================*/
			    /*==================================================*/
				System.out.println("SQL statement execution failed: "+objException.getMessage());
				throw new SQLException(objException.getMessage());
			}
		}
		/*==================================================*/
		/*=========Catch Statement Creation Errors==========*/
		/*==================================================*/
		catch (Exception objException)
		{
			/*==================================================*/
	    	/*===================Show Message===================*/
		    /*==================================================*/
			System.out.println("SQL statement could not be created: "+objException.getMessage());
			throw new SQLException(objException.getMessage());
		}
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
	/*==================================================*/
	/*=================Close Connection=================*/
	/*==================================================*/
	/**
	 * Close the connection to the database.
	 * @throws SQLException Connection already closed.
	 */
	public void close() throws SQLException
	{
		/*==================================================*/
		/*=================Close Connection=================*/
		/*==================================================*/
		this.getConnection().close();
	}
	/*==================================================*/
	/*==================End Procedure===================*/
	/*==================================================*/
}
/*==================================================*/
/*====================End Class=====================*/
/*==================================================*/