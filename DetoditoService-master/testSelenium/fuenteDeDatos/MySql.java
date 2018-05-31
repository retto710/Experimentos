package fuenteDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySql {
	private static Connection cn = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;
	public static String[][] leerUsuarioMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM usuarioregistro");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][7];
			while (rs.next()) {
				datos[i][0] = rs.getString("nombre");
				datos[i][1] = rs.getString("correo");
				datos[i][2] = rs.getString("password");
				datos[i][3] = rs.getString("telefono");
				datos[i][4] = rs.getString("direccion");
				datos[i][5] = rs.getString("mensaje");
				datos[i][6] = rs.getString("numero");
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerUsuarioMysql2() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM solicitarservicio");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][9];
			while (rs.next()) {
				datos[i][0] = rs.getString("distrito");
				datos[i][1] = rs.getString("categoria");
				datos[i][2] = rs.getString("tipodocumento");
				datos[i][3] = rs.getString("ndocu");
				datos[i][4] = rs.getString("nombre");
				datos[i][5] = rs.getString("descripcion");
				datos[i][6] = rs.getString("observaciones");
				datos[i][7] = rs.getString("mensaje");
				datos[i][8] = rs.getString("numero");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerUsuarioLoginMySql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM usuariologin");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][4];
			while (rs.next()) {
				datos[i][0] = rs.getString("usuario");
				datos[i][1] = rs.getString("contrasena");
				datos[i][2] = rs.getString("mensaje");
				datos[i][3] = rs.getString("login");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerContra() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM cambiarcontra");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][6];
			while (rs.next()) {
				datos[i][0] = rs.getString("correo");
				datos[i][1] = rs.getString("password");
				datos[i][2] = rs.getString("newpassword");
				datos[i][3] = rs.getString("repeatpassword");
				datos[i][4] = rs.getString("mensaje");
				datos[i][5] = rs.getString("numero");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] buscarServ() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM cambiarcontra");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][3];
			while (rs.next()) {
				datos[i][0] = rs.getString("descripcion");
				datos[i][1] = rs.getString("tipo");
				datos[i][2] = rs.getString("numero");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	
	private static Connection obtenerConexion() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return (DriverManager.getConnection("jdbc:mysql://localhost:3306/detodito_service_test", "root", "root"));
	}
	
	private static int numeroFilas(ResultSet resultSet){
	    int totalFilas = 0;
	    try {
	        resultSet.last();
	        totalFilas = resultSet.getRow();
	        resultSet.beforeFirst();
	    } 
	    catch(Exception ex)  {
	        return 0;
	    }
	    return totalFilas ;    
	}

}
