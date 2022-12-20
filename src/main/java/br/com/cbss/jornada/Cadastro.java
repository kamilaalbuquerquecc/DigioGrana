package br.com.cbss.jornada;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cbss.auxiliares.DataHoraScreen;
import br.com.cbss.auxiliares.Screen;



public class Cadastro {

	Elementos e = new Elementos();
	public static WebDriver driver;
	public static String url;
	public String nome ="";
	public String nomeCompleto ="";
	public String senha ="";
	public String celular ="";
	public String nomeMae ="";
	public String cep ="";
	public String numero ="";
	public String bairro ="";
	public String logradouro ="";
	public String complemento ="";
	public String nascimento ="";
	public String valoremprestimo ="";
	public String renda ="";
	public String rg ="";
	public String agencia ="";
	public String conta ="";
	public String digitoConta ="";
	public String janela = "";
	
	public Cadastro() {
		
	}
	
	public Cadastro(WebDriver driver, String url,  String nome, String nomeCompleto, String senha, String celular, String nomeMae, String cep,
			String numero,String bairro, String logradouro, String complemento, String nascimento, String valoremprestimo, String renda, String rg, String agencia, String conta,
			String digitoConta) {
		Cadastro.driver = driver;
		this.url = url;
		this.nome = nome;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.celular = celular;
		this.nomeMae = nomeMae;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.nascimento = nascimento;
		this.valoremprestimo = valoremprestimo;
		this.renda = renda;
		this.rg = rg;
		this.agencia = agencia;
		this.conta = conta;
		this.digitoConta = digitoConta;
	}
	
	public void cadastroInicial() throws InterruptedException, IOException {
		
		System.out.println("Cadastro inicial");
		driver.manage().window().maximize();
		driver.get(url);
		
		Thread.sleep(2000);	
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "LOGIN_1.png");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath((String.valueOf(e.btCriarConta)))).click();
		driver.findElement(By.id("mat-input-0")).sendKeys(nome);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NOME.png");

		driver.findElement(By.xpath(String.valueOf(e.btOKnome))).click();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "INSERIR_CPF.png");
		
		janela = driver.getWindowHandle();
		
	}
	
	public void cadastroEmail(String email, String senha) throws IOException, InterruptedException {
		
		driver = driver.switchTo().window(janela);
		driver.findElement(By.id("mat-input-2")).sendKeys(email);
		driver.findElement(By.id("mat-input-3")).sendKeys(email);
		driver.findElement(By.id("mat-input-4")).sendKeys(senha);
		driver.findElement(By.id("mat-input-5")).sendKeys(senha);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "EMAIL_SENHA.png");
		
		driver.findElement(By.xpath(e.btOKEmail)).click();
		
	}
	public void editaEmail() throws IOException, InterruptedException {
		driver.findElement(By.xpath(e.btEditaEmail)).click();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "EDITA_EMAIL.png");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).clear();
		
	}
	public void cadastroNovoEmail(String email) throws IOException, InterruptedException {
		
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		driver.findElement(By.id("mat-input-0")).sendKeys(email);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NOVO_EMAIL.png");
		
		driver.findElement(By.xpath(e.btOKNovoEmail)).click();
		
	}
	public void cadastroCpf( String cpf) throws IOException, InterruptedException {
		
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		
		driver.findElement(By.id("mat-input-1")).sendKeys(cpf);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "CPF.png");
		
		driver.findElement(By.xpath(e.btOKcpf)).click();
	
	}
	
	public void concordaComTermos() throws IOException, InterruptedException{
		
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		
		System.out.println("CONCORDA COM TERMOS");
		Thread.sleep(3000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "TERMOS.png");
		
		driver.findElement(By.xpath(e.btTermos)).click();
		
	}
	
	public void usarFacebookParaConectar() throws IOException, InterruptedException {
		
		System.out.println("CONECTA COM FACEBOOK?");
		Thread.sleep(3000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NAO_CONECTA_FACEBOOK.png");
		
		driver.findElement(By.xpath(e.btNaoFacebook)).click();
		
	}
	
	public void continuaCadastro() throws IOException, InterruptedException {
		//Cadastro de nome completo, nome da mão, conta, valor do emprestimo, renda, endereço...
		
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("CADASTRA CELULAR");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(celular);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "CELULAR.png");
		
		driver.findElement(By.xpath(e.btOKCelular)).click();
		
		//Espera Explícita
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(e.btOKsms))));
		System.out.println("DIGITA CÓDIGO DE SMS");
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "SMS.png");
		
		driver.findElement(By.id(e.btOKsms)).click();
		
		System.out.println("DIGITA NOME COMPLETO");
		
		driver.findElement(By.id("mat-input-1")).sendKeys(nomeCompleto);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NOME_COMPLETO.png");
		
		driver.findElement(By.xpath(e.btOKNomeompleto)).click();
		driver.findElement(By.xpath(e.btCasa)).click();

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "MOTIVO_EMPRESTIMO.png");
		
		driver.findElement(By.xpath(e.btContinuaMotivo)).click();
		System.out.println("DIGITA VALOR EMPRESTIMO");
		driver.findElement(By.id("mat-input-2")).sendKeys(valoremprestimo);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "VALOR_EMPRESTIMO.png");
		
		driver.findElement(By.xpath(e.btOKValorEmprestimo)).click();
		System.out.println("DIGITA DATA DE NASCIMENTO");
		driver.findElement(By.id("mat-input-4")).sendKeys(nascimento);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "NASCIMENTO.png");
		
		driver.findElement(By.xpath(e.btOKnascimento)).click();
		System.out.println("DIGITA RENDA");
		driver.findElement(By.id("mat-input-5")).sendKeys(renda);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "RENDA.png");
		
		driver.findElement(By.xpath(e.btOKrenda)).click();

		Thread.sleep(3000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "COMPROVAR_RENDA.png");
		
		driver.findElement(By.xpath(e.btExtrato)).click();
		
		//Adicionando os dados da conta
		System.out.println("SELECIONA E INSERE DADOS DA CONTA ");
		driver.findElement(By.xpath(e.btTipoConta)).click();
		WebElement div = driver.findElement(By.xpath(e.tiposDeContas));
		div.findElement(By.xpath(e.contaCorrenteIndividual)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(e.selecionarBanco)).click();
		div = driver.findElement(By.xpath(e.bancosDisponiveis));
		div.findElement(By.xpath(e.bancoDigio)).click();
		driver.findElement(By.id("mat-input-9")).sendKeys(agencia);
		driver.findElement(By.id("mat-input-10")).sendKeys(conta);
		driver.findElement(By.id("mat-input-11")).sendKeys(digitoConta);
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "DADOS_CONTA.png");
		
		driver.findElement(By.xpath(e.btOKConta)).click();
		

		Thread.sleep(5000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "SEXO.png");
		
		driver.findElement(By.xpath(e.btFeminino)).click();

		Thread.sleep(4000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "OCUPAÇÃO.png");
		
		driver.findElement(By.xpath(e.btAssalariado)).click();

		Thread.sleep(3000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "ESTADO_CIVIL.png");
		
		driver.findElement(By.xpath(e.btSolteiro)).click();
		System.out.println("DIGITA NOME DA MÃE");
		driver.findElement(By.id("mat-input-12")).sendKeys(nomeMae);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "MAE.png");
		
		driver.findElement(By.xpath(e.btOKMae)).click();
		System.out.println("DIGITA ENDEREÇO RESIDENCIAL E COMERCIAL"); 
		driver.findElement(By.id("mat-input-13")).sendKeys(cep);
		driver.findElement(By.id("mat-input-18")).sendKeys(numero);
		Thread.sleep(5000);
		
		if(verificaCampoPreenchido("mat-input-16")==false) {
			driver.findElement(By.id("mat-input-16")).sendKeys(bairro);
		}
		
		if(verificaCampoPreenchido("mat-input-17")==false) {
			driver.findElement(By.id("mat-input-17")).sendKeys(logradouro);
		}
		
		
		driver.findElement(By.id("mat-input-19")).sendKeys(complemento);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(e.btOkEndereco))));

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "ENDERECO_RESIDENCIAL.png");
		
		driver.findElement(By.xpath(e.btOkEndereco)).click();

		Thread.sleep(5000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "ENDERECO_COMERCIAL.png");
		
		driver.findElement(By.xpath(e.btOkEndereco)).click();

		
		
		System.out.println("DIGITA DADOS DOCUMENTO");
		driver.findElement(By.xpath(e.btTipoDoc)).click();
		driver.findElement(By.xpath(e.btRG)).click();
		driver.findElement(By.id("mat-input-27")).sendKeys(rg);

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "RG.png");
		
		driver.findElement(By.xpath(e.btOkDocumento)).click();
		
		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "ANALISANDO_PERFIL.png");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		String msgCredito = driver.findElement(By.xpath(e.h1CreditoPreAprovado)).getText();
		Assert.assertEquals(e.msgCreditoPreAprovado, msgCredito);
		

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "RESULTADO.png");
		
		driver.findElement(By.xpath(e.btContinuaAprovado)).click();

		Thread.sleep(2000);
		Screen.take(driver,  DataHoraScreen.dataHoraArquivo() + "VALOR_DISPONIVEL.png");
		
		Thread.sleep(5000);
	}
	
	public boolean verificaCampoPreenchido(String id_campo) {
		
		boolean preenchido = true;
		if (driver.findElement(By.id(id_campo)).getAttribute("value")=="")
			preenchido = false;
		return preenchido; 
	}
	public void fechaAbaDigio(WebDriver driver) throws InterruptedException {
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(0));
		Thread.sleep(2000);
		Cadastro.driver.close();
		
	}
	
	
	
	
}
