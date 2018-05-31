package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.deToditoDriver;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Usuarios;
import util.Utilitario;

public class CambiarContraPage {
	
	private IniciarSesionPage iniciarSesionPage;
	private By botonBuscar = By.id("btnBuscar");
	private By btnCambiar = By.id("btnCambiar");
	private By txtPasword = By.id("txtPasword");
	private By txtPasword1 = By.id("txtPasword1");
	private By txtPasword2= By.id("txtPasword2");
	private By cajaUsuario = By.id("txtUsuarioLogin");
	private By cajaClave = By.id("txtPassLogin");
	private By botonIniciarSesion = By.id("btnAcceder");
	private By btnActualizar = By.id("btnActualizar");
	private By txtmensaje = By.id("epasswordNew1");
	//Menu
	
	
	
	private String urlInicial= "http://localhost:8080/DetoditoService/index.jsp";
	private WebDriver webDriver = null;
	private String rutaCarpetaError = "C:\\Users\\anthony\\Documents\\Entregable final\\OneDrive_1_5-30-2018\\DetoditoService-master\\capturas\\contra";
	
	
	public CambiarContraPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String CambiarContra(String correo, String contraActual, String contraNueva, String contraRepetida, String numero)throws Exception
	{
		String respuesta ="";	
		IUsuariosRep repo = new UsuariosRep();
		Usuarios objuser= repo.GetUsuario(correo);
		//Iniciar sesion
		webDriver.get(urlInicial);
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(correo);
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(contraActual);
		webDriver.findElement(botonIniciarSesion).click();
		Thread.sleep(2000);
		//Abrir pagina
		webDriver.get("http://localhost:8080/DetoditoService/perfilUsuario.jsp");
		//Click en cambiar
		Thread.sleep(2000);
		webDriver.findElement(btnCambiar).click();
		webDriver.findElement(txtPasword).clear();
		webDriver.findElement(txtPasword1).clear();
		webDriver.findElement(txtPasword2).clear();
		webDriver.findElement(txtPasword).sendKeys(contraActual);
		webDriver.findElement(txtPasword1).sendKeys(contraNueva);
		webDriver.findElement(txtPasword2).sendKeys(contraRepetida);
		webDriver.findElement(btnActualizar).click();
		Thread.sleep(2000);
		
		respuesta = webDriver.findElement(txtmensaje).getText();
		Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoAlternativoTest",numero);

		return respuesta;
		
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
