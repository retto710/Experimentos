package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CambiarContraPage;
import pages.IniciarSesionPage;


public class CambiarContraDriverTest {
	private String urlInicial = "http://localhost:8080/DetoditoService/";
	private IniciarSesionPage iniciarSesionPage;
	private CambiarContraPage cambiarContra;
	
	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.cambiarContra = new CambiarContraPage(this.iniciarSesionPage.getWebDriver());

	}
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = fuenteDeDatos.MySql.leerContra();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = fuenteDeDatos.Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	@Test(dataProvider = "datosEntrada")
	public void cambiarContra(String correo, String contraActual, String contraNueva, String contraRepetida, String mensaje, String numero) throws Exception {
		try {
			
			iniciarSesionPage.goToLoginPage();
			String valorEsperado = mensaje;
			String valorObtenido = cambiarContra.CambiarContra(correo,contraActual, contraNueva, contraRepetida, numero);
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		cambiarContra.cerrarPagina();
	}
}
