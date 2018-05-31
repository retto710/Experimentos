package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.deToditoDriver;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Usuarios;
import util.Utilitario;

public class BuscarServicioPage {

	private IniciarSesionPage iniciarSesionPage;
	private By botonBuscar = By.id("btnBuscar");
	private By txtServicio = By.id("txtServicio");
	private By txtCategoria = By.id("txtCategoria");
	private By cajaUsuario = By.id("txtUsuarioLogin");
	private By cajaClave = By.id("txtPassLogin");
	private By botonIniciarSesion = By.id("btnAcceder");
	private String urlInicial= "http://localhost:8080/DetoditoService/index.jsp";
	private WebDriver webDriver = null;
	


	private String rutaCarpetaError = "C:\\Users\\anthony\\Documents\\Entregable final\\OneDrive_1_5-30-2018\\DetoditoService-master\\capturas\\buscarServicio";
	
	
	public BuscarServicioPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	public String BuscarServicio(String busqueda, String tipo, String numero)throws Exception
	{
		String respuesta ="";	
		IUsuariosRep repo = new UsuariosRep();
		Usuarios objuser= repo.GetUsuarioById(1);
		//Iniciar sesion
		webDriver.get(urlInicial);
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(objuser.getCorreoElectronico());
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(objuser.getPassword());
		webDriver.findElement(botonIniciarSesion).click();
		Thread.sleep(2000);
		
		webDriver.findElement(txtServicio).clear();
		webDriver.findElement(txtServicio).sendKeys(busqueda);
		if(tipo!="Categoría")
		{
		//Lista
		WebElement lista= webDriver.findElement(txtCategoria);
		Select select = new Select(lista);
		select.deselectAll();
		select.selectByVisibleText(tipo);
		}
		
		Utilitario.caputarPantallarError(rutaCarpetaError, "buscar servicio test", webDriver,"flujoAlternativoTest",numero);
		webDriver.findElement(botonBuscar).click();
		Thread.sleep(2000);

		return respuesta;
	}
	public void cerrarPagina(){
		deToditoDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
