package br.com.cbss.auxiliares;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cbss.jornada.Cadastro;
import br.com.cbss.jornada.Elementos;
import junit.framework.Assert;

//Gerador de e-mail
public class Invertexto {

	Elementos e = new Elementos();
	public static WebDriver driver;
	public String url = "";
	public String email = "";
	public String janela = "";
	public String janelaEmail = "";
	
	public Invertexto(WebDriver driver) {
		GeradorDeCPF.driver = driver;
	}

	public void geraEmail(WebDriver driver, String url) throws InterruptedException, IOException {
		//gera e-mail
		Invertexto.driver = driver;
		driver = driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "INVERTEXTO.png");
		
		email = driver.findElement(By.id("email-input")).getAttribute("value");

		janela = driver.getWindowHandle();
		
	}
	
	public void confirmaEmail(WebDriver driver) throws InterruptedException, IOException {
		
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));

		Thread.sleep(3000);
		
		String assuntoEmail = driver.findElement(By.xpath(e.assuntoEmail)).getText();
		Assert.assertEquals("Kamila, seja bem-vindo(a) ao digiograna!", assuntoEmail);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "ASSUNTO_EMAIL.png");
		
		driver.findElement(By.xpath(e.clickEmEmail)).click();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "TEXTO_EMAIL.png");
		
		driver.findElement(By.xpath(e.btConfirmaEmail)).click();
		
		Thread.sleep(2000);
		abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		
		Thread.sleep(5000);
		String tagConfirmado = driver.findElement(By.xpath(e.tagConfirmando)).getText();

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "EMAIL_CONFIRMADO.png");
		
		Assert.assertEquals("E-mail confirmado!", tagConfirmado);
		driver.findElement(By.xpath(e.btContinuaLogin)).click();
		
	}
	
	public void geraNovoEmail() throws InterruptedException, IOException {
		//Gera e-mail
		
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		driver.navigate().refresh();
		Thread.sleep(2000);
		email = driver.findElement(By.id("email-input")).getAttribute("value");

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NOVO_EMAIL.png");
		
	}
	
	public void fechaAbaEmailConfirmado(WebDriver driver) throws InterruptedException {
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		Thread.sleep(2000);
		Cadastro.driver.close();
		
	}
	public void fechaAbaGeradorDeEmail(WebDriver driver) throws InterruptedException {
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		Thread.sleep(2000);
		Cadastro.driver.close();
		
	}
	
	
}
