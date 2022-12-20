package br.com.cbss.auxiliares;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.cbss.jornada.Cadastro;
import br.com.cbss.jornada.Elementos;

public class GeradorDeCPF {
	public Elementos e = new Elementos();
	public String url = "";
	public static WebDriver driver;
	public String cpf = "";
	public String janela = "";
	public String janelaCpf = "";
	public String janelaDigio = "";
	
	
	
	public GeradorDeCPF(WebDriver driver) {
		GeradorDeCPF.driver = driver;
	}

	public void geraCpf(WebDriver driver, String url ) throws InterruptedException, IOException {
		GeradorDeCPF.driver = driver;
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		driver.manage().window().maximize();

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "TELA_CPF.png");
		
		driver.findElement(By.id(e.btGerarCpf)).click();
		cpf =  driver.findElement(By.id("texto_cpf")).getText();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "GEROU_CPF.png");
		
		System.out.println(janelaCpf);
		
	}
	
	
	public void fechaAbaCpf(WebDriver driver) throws InterruptedException {
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		Thread.sleep(2000);
		Cadastro.driver.close();
		
	}
	
}
