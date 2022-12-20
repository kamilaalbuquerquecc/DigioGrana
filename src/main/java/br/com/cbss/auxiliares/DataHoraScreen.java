package br.com.cbss.auxiliares;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataHoraScreen {

	public static String dataHoraArquivo() {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		return new SimpleDateFormat("yyyy_MM_hh_mm_ss").format(ts);
	}

}
