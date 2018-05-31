package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import driver.deToditoDriver;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import util.Utilitario;

public class RegistrarServicioPage {

	private By botonIrARegistrarServicio= By.id("irARegisterServ");
	private String rutaCarpetaError = "C:\\Users\\Usuario\\Documents\\cosas universidad\\exp\\deTodito\\DetoditoService-master\\capturas\\registrarServicio";
	
	
	
	
	
	private By cajaNDocumento = By.id("txtCodigoDocumentoRS");
	private By cajaNombre = By.id("txtServicioOfrecerRS");
	private By cajaDescripcion = By.id("txtDescripcionServicioRS");
	private By cajaObservaciones =By.id("txtObservacionesRS");
	
	
	private By botonRegistrar = By.id("btnRegisterServicio");
	
	private By mensajeObtenido = By.id("mensajeExito2");
	
		
		

		private WebDriver webDriver = null;
		
		public RegistrarServicioPage(WebDriver webDriver) {
			this.webDriver = webDriver;
		}
		public String registrarServicio(String ndocu, String nombre, String descripcion, String observaciones,String numero) throws Exception {

			String respuesta ="";
			
			IServiciosRep repo = new ServiciosRep();
			
			//webDriver.get("http://localhost:8080/DetoditoService/Registro_Servicio.jsp");
			
			webDriver.findElement(botonIrARegistrarServicio).click();
			//Thread.sleep(2000);
			
			
			webDriver.findElement(cajaNDocumento).clear();
			webDriver.findElement(cajaNombre).clear();
			webDriver.findElement(cajaDescripcion).clear();
			webDriver.findElement(cajaObservaciones).clear();
			
			//final Select selectDistrito = new Select(webDriver.findElement(By.id("selectDistrito")));
			//final Select selectCategoria = new Select(webDriver.findElement(By.id("selectCategoria")));
			//final Select selectTipoDocumento = new Select(webDriver.findElement(By.id("selectTipoDocumento")));
			//selectDistrito.selectByIndex(2);
			//selectCategoria.selectByIndex(2);
			//selectTipoDocumento.selectByIndex(1);
			webDriver.findElement(cajaNDocumento).click();
			webDriver.findElement(cajaNDocumento).sendKeys(ndocu);
			webDriver.findElement(cajaNombre).click();
			webDriver.findElement(cajaNombre).sendKeys(nombre);
			webDriver.findElement(cajaDescripcion).click();
			webDriver.findElement(cajaDescripcion).sendKeys(descripcion);
			webDriver.findElement(cajaObservaciones).click();
			webDriver.findElement(cajaObservaciones).sendKeys(observaciones);
			Thread.sleep(2000);
			
			webDriver.findElement(botonRegistrar).click();
			Thread.sleep(2000);
			
			if(ndocu.equals(respuesta)) {
				respuesta = "Introduzca un numero.";
				Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoAlternativoTest",numero);
			}
			else {
				if(nombre.equals(respuesta)||descripcion.equals(respuesta)||observaciones.equals(respuesta)) {
					respuesta = "Rellena este campo.";
					Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoAlternativoTest",numero);
				}
			else{respuesta = webDriver.findElement(mensajeObtenido).getText();
				Utilitario.caputarPantallarError(rutaCarpetaError, respuesta, webDriver,"flujoNormal",numero);
				
			}
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
