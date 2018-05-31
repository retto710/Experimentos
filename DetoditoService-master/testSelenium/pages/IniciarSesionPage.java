package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driver.deToditoDriver;
import util.Utilitario;

public class IniciarSesionPage {

	private String rutaCarpetaError = "C:\\Users\\Usuario\\Documents\\cosas universidad\\exp\\deTodito\\DetoditoService-master\\capturas\\loginUsuario";
	

	private By cajaUsuario = By.id("txtUsuarioLogin");
	private By cajaClave = By.id("txtPassLogin");
	private By botonIniciarSesion = By.id("btnAcceder");
	private String urlInicial;
	private WebDriver webDriver = null;
	
	public IniciarSesionPage(String navegador, String urlInicial, boolean remoto){
		this.webDriver = deToditoDriver.inicializarDriver(navegador, remoto);
		this.urlInicial = urlInicial;
	}
	
	public void iniciarSesion(String usuario, String clave) throws Exception{
		webDriver.get(urlInicial);
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(usuario);
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(clave);
		webDriver.findElement(botonIniciarSesion).click();
		
		
	}
	

	
	public String iniciarSesionTest(String usuario, String clave, String numero) throws Exception{
		String message ="";
		
		webDriver.get(urlInicial);
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(usuario);
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(clave);
		Thread.sleep(2000);
		
		
		webDriver.findElement(botonIniciarSesion).click();
		
		if(numero.equals("1")) {
			message = webDriver.findElement(By.id("titleMasBuscado")).getText();
			Utilitario.caputarPantallarError(rutaCarpetaError, message, webDriver,"flujoAlternativoTest",numero);
		}else {
			message = "error";
			Utilitario.caputarPantallarError(rutaCarpetaError, message, webDriver,"flujoAlternativoTest",numero);
		}
		
		return message;
	}
	
	public void cerrarPagina(){
		deToditoDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public void goToLoginPage() {
		webDriver.get(urlInicial);
	}
	

}
