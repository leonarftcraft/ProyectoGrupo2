package Modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClaseConection {

	// objeto vacio de la clase de java Connection
	private Connection Cone;

	// metodo encargado de generar la conexion con mysql
	public void GetConexion(String Pass) {

		try {
			// driver mysql
			Class.forName("com.mysql.jdbc.Driver");
			Cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/asisproo", "root", Pass);

		} catch (ClassNotFoundException ex) {
			// en el caso de error se mostrara esto
			System.out.println("error de drivers");
		} catch (SQLException ex) {

		}

	}

	// metodo encargado de cerrar la conexion con mysql
	public void SetCloseConexion() {
		try {
			Cone.close();

		} catch (SQLException ex) {
			System.out.println("error al Cerrar Conexion");
		}
	}

	/*
	 * metodo encargado de ejecutar sentencia sql dirigida a guardar datos Nota:
	 * el parametro string sql, debera contener la sentencia cuando se instancie
	 * este metodo
	 */
	public void SetDatos(String sql) {

		try {

			Statement k = Cone.createStatement();
			k.executeUpdate(sql);
	
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al guardar datos");
		}

	}

	/*
	 * metodo encargado de ejecutar sentecia sql dirigidas a obtener datos
	 * 
	 * Nota: el parametro string sql, debera contener la sentencia cuando se
	 * instancie este metodo
	 */
	public ResultSet GetDatos(String sql) {

		ResultSet res = null;
		try {
			Statement s = Cone.createStatement();

			res = s.executeQuery(sql);

		} catch (SQLException ex) {

		}
		// el metodo debuelve una variable tipo resultset, ella contendra los
		// datos que se obtubieron de la BD
		return res;
	}

}
