package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.IniciarSesionPage;
import pages.RegistrarServicioPage;

public class LoginUsuarioDriverTest {
	private String urlInicial = "http://localhost:8080/DetoditoService/";
	private IniciarSesionPage iniciarSesionPage;
	private RegistrarServicioPage registrarServicio;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = fuenteDeDatos.MySql.leerUsuarioLoginMySql();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = fuenteDeDatos.Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	@Test(dataProvider = "datosEntrada")
	public void registrarServicio( String usuario, String contrasena, String mensaje, String login) throws Exception {
		try {
			String valorEsperado = mensaje;
			String valorObtenido = iniciarSesionPage.iniciarSesionTest(usuario, contrasena,login);
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}