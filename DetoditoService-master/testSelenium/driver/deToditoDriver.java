package driver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class deToditoDriver {

	public final static WebDriver inicializarDriver(String navegador, boolean remoto) {
		WebDriver webDriver = null;
		System.out.println("Ejecución Remota: " + (remoto ? "SI" : "NO"));
		switch (navegador) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\anthony\\Documents\\Entregable final\\OneDrive_1_5-30-2018\\DetoditoService-master\\data\\geckodriver.exe");
			webDriver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\anthony\\Documents\\Entregable final\\OneDrive_1_5-30-2018\\DetoditoService-master\\data\\chromedriver.exe");
			webDriver = new ChromeDriver();
			break;
		}
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return webDriver;
	}

	public final static void cerrarPagina(WebDriver webDriver) {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
