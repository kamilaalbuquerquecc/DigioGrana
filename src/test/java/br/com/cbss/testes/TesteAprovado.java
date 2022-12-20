package br.com.cbss.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.cbss.auxiliares.GeradorDeCPF;
import br.com.cbss.auxiliares.Invertexto;
import br.com.cbss.jornada.Base_Test;
import br.com.cbss.jornada.Cadastro;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//@FixMethodOrder(MethodSorters.DEFAULT)
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massa.csv")

public class TesteAprovado extends Base_Test{
	
	@Test
	public void testeCadastro(@Param(name = "nome") String nome, @Param(name = "nomeCompleto") String nomeCompleto, 
			@Param(name = "celular") String celular, @Param(name = "nomeMae") String nomeMae, @Param(name = "senha") String senha, 
			@Param(name = "cep") String cep, @Param(name = "numero") String numero, @Param(name = "bairro")String bairro, 
			@Param(name = "logradouro") String logradouro, @Param(name = "complemento") String complemento, @Param(name = "nascimento") String nascimento, 
			@Param(name = "rg") String rg, @Param(name = "valoremprestimo") String valoremprestimo, @Param(name = "renda") String renda, 
			@Param(name = "agencia") String agencia, @Param(name = "conta") String conta, @Param(name = "digitoConta") String digitoConta) throws InterruptedException, IOException {
		
		Cadastro c = new Cadastro(driver, properties.getProperty("url.digio"),   nome,  nomeCompleto,  senha,  celular,  nomeMae,  cep,
				 numero,bairro, logradouro, complemento, nascimento,  valoremprestimo,  renda,  rg,  agencia,  conta, digitoConta);
		
		c.cadastroInicial();
		
		Thread.sleep(2000);
		
		//Gera e cadastra CPF
		GeradorDeCPF cpf = new  GeradorDeCPF(Cadastro.driver);
		
		cpf.geraCpf(Cadastro.driver, properties.getProperty("url.cpf"));
		
		c.cadastroCpf(cpf.cpf);
		
		cpf.fechaAbaCpf(Cadastro.driver);
		
		c.concordaComTermos();
		
		c.usarFacebookParaConectar();
		
		//Gera e cadastra e-mail
		
		Invertexto i = new Invertexto(Cadastro.driver);
		
		i.geraEmail(Cadastro.driver, properties.getProperty("url.email"));
		
		c.cadastroEmail(i.email, senha);
		
		c.fechaAbaDigio(driver);
		
		i.confirmaEmail(driver);
		
		c.editaEmail();
		
		i.geraNovoEmail();
		
		c.cadastroNovoEmail(i.email);
		
		i.fechaAbaEmailConfirmado(driver);
		
		i.confirmaEmail(driver);
		
		i.fechaAbaGeradorDeEmail(driver);
		
		c.continuaCadastro();
	
		
		
		
	}

}
