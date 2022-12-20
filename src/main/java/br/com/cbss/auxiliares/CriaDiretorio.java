package br.com.cbss.auxiliares;

import java.io.File;
import java.io.IOException;

public class CriaDiretorio {
	
	public static String nomePasta;

	public static void criaDiretorio() throws IOException {
		// Cria Diretorio para cada vez que o teste é executado
		try {
			nomePasta = "Evidência" +  DataHoraScreen.dataHoraArquivo();
			File pasta = new File(System.getProperty("user.dir") +"\\target\\Screenshot\\" +"//"+ nomePasta);
			pasta.mkdir();
			 
		}
		catch(Exception f) {
			System.out.println("Erro ao criar pasta " + f.getMessage());
		}
			
	}
}
