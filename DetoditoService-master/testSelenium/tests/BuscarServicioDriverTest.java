package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BuscarServicioPage;
import pages.IniciarSesionPage;
import pages.RegistrarServicioPage;

public class BuscarServicioDriverTest {
	private String urlInicial = "http://localhost:8080/DetoditoService/";
	private IniciarSesionPage iniciarSesionPage;
	private BuscarServicioPage buscarServicio;
	
	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.buscarServicio = new BuscarServicioPage(this.iniciarSesionPage.getWebDriver());
		
	}
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = fuenteDeDatos.MySql.buscarServ();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = fuenteDeDatos.Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	
	@Test(dataProvider = "datosEntrada")
	public void buscarServicio(String busqueda, String tipo, String numero) throws Exception {
		try {
			iniciarSesionPage.goToLoginPage();
			String valorObtenido = buscarServicio.BuscarServicio(busqueda, tipo,numero);
			Assert.assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@AfterTest
	public void tearDown() throws Exception {
		buscarServicio.cerrarPagina();
	}
}
