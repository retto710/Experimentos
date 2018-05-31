package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driver.deToditoDriver;
import util.Utilitario;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;

public class RegistrarUsuarioPage {
	
	private By botonRegistrar = By.id("btnRegistrar");

	private String rutaCarpetaError = "C:\\Users\\Usuario\\Documents\\cosas universidad\\exp\\deTodito\\DetoditoService-master\\capturas\\registrarUsuario";
	
	private By cajaNombre = By.id("txtNombreRegistro");
	private By cajaCorreo = By.id("txtCorreoRegistro");
	private By cajaPass = By.id("txtPassRegistro");
	private By cajaPassConfirm = By.id("txtConfirmPassRegistro");
	private By cajaTelefono = By.id("txtTelefonoRegistro");
	private By cajaDireccion = By.id("txtDireccionRegistro");
	
	private By botonGuardar = By.id("btnRegistrarUsuario");
	
	private By mensajeObtenido = By.id("mensajeDeExito");
	
	
	
	private By mensajeRespuesta = By.id("messages");
	
	
	
	private WebDriver webDriver = null;
	
	public RegistrarUsuarioPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String registrarUsuario(String nombre, String correo, String pass, String telefono, String direccion, String numero) throws Exception {

		String respuesta ="";
		
		IUsuariosRep repo = new UsuariosRep();
		
		webDriver.findElement(botonRegistrar).click();
		Thread.sleep(2000);
		
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaCorreo).clear();
		webDriver.findElement(cajaPass).clear();
		webDriver.findElement(cajaPassConfirm).clear();
		webDriver.findElement(cajaTelefono).clear();
		webDriver.findElement(cajaDireccion).clear();
		
		
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		webDriver.findElement(cajaCorreo).sendKeys(correo);
		webDriver.findElement(cajaPass).sendKeys(pass);
		webDriver.findElement(cajaPassConfirm).sendKeys(pass);
		webDriver.findElement(cajaTelefono).sendKeys(telefono);
		webDriver.findElement(cajaDireccion).sendKeys(direccion);
		Thread.sleep(2000);
		
		webDriver.findElement(botonGuardar).click();
		Thread.sleep(2000);
		
		if(nombre.equals(respuesta)||correo.equals(respuesta)||pass.equals(respuesta)||telefono.equals(respuesta)||direccion.equals(respuesta)) {
			respuesta = "falta un campo";
			Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoAlternativTest",numero);
		}else {
			respuesta = webDriver.findElement(mensajeObtenido).getText();
			Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoNormal",numero);
			repo.deleteUsuario(correo);
		}
		return respuesta;
		
	}
	
	public void cerrarPagina(){
		deToditoDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}



}
