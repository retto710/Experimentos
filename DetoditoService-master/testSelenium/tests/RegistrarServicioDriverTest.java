package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.IniciarSesionPage;
import pages.RegistrarServicioPage;

public class RegistrarServicioDriverTest {
	private String urlInicial = "http://localhost:8080/DetoditoService/";
	private IniciarSesionPage iniciarSesionPage;
	private RegistrarServicioPage registrarServicio;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.registrarServicio = new RegistrarServicioPage(this.iniciarSesionPage.getWebDriver());
		
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = fuenteDeDatos.MySql.leerUsuarioMysql2();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = fuenteDeDatos.Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	@Test(dataProvider = "datosEntrada")
	public void registrarServicio( String distrito, String categoria, String tipodocumento, String ndocu,String nombre, String descripcion, String observaciones,String mensaje, String numero  ) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion("juan@gmail.com", "123");
			String valorEsperado = mensaje;
			String valorObtenido = registrarServicio.registrarServicio(ndocu,nombre,descripcion,observaciones,numero);
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}