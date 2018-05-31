package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import pages.IniciarSesionPage;
import pages.RegistrarUsuarioPage;


public class RegistrarUsuarioDriverTest {

	private String urlInicial = "http://localhost:8080/DetoditoService/";
	private IniciarSesionPage iniciarSesionPage;
	private RegistrarUsuarioPage registrarUsuario;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.registrarUsuario = new RegistrarUsuarioPage(this.iniciarSesionPage.getWebDriver());
	}
	
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = fuenteDeDatos.MySql.leerUsuarioMysql();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = fuenteDeDatos.Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	
	@Test(dataProvider = "datosEntrada")
	public void registrarUsuario(String nombre, String correo, String password, String telefono, String direccion, String mensaje, String numero) throws Exception {
		try {
			iniciarSesionPage.goToLoginPage();
			String valorEsperado = mensaje;
			String valorObtenido = registrarUsuario.registrarUsuario(nombre, correo, password, telefono, direccion,numero);
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		registrarUsuario.cerrarPagina();
	}


}
