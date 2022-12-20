package br.com.cbss.jornada;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.cbss.auxiliares.CriaDiretorio;

public class Base_Test {
	
	protected static WebDriver driver;
	protected Properties properties;
	
	@Before
	public void driverTest() throws IOException {
		properties = getProp();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CriaDiretorio.criaDiretorio();
	}
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties(); 
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");

		props.load(file);
		return props;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getProp());
	}
	
	/*@After
	public void finaliza() {
		driver.quit();
	}*/
}
