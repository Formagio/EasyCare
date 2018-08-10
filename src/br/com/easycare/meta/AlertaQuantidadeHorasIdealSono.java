package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.atividade.SonoIdeal;
import br.com.easycare.questionario.Questionario;

public class AlertaQuantidadeHorasIdealSono implements IMeta {
	
	@Override
	public String getDescricao() {
		return "Para manter seu equilíbrio e a produtividade alta procure dormir de 7 a 9 horas por noite";
	}
	
	@Override
	public List<IAtividade> getAtividades() {
		return Arrays.asList(new SonoIdeal());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questionario) {
		try {
			long diferencaMS = questionario.getDataInicioSono().getTime() - questionario.getDataFinalSono().getTime();
		    long diferencaSegundos = diferencaMS / 1000;
		    long diferencaMinutos = diferencaSegundos / 60;
		    long diferencaHoras = diferencaMinutos / 60;
			
			return diferencaHoras < 7 || diferencaHoras > 11;
		} catch (Exception ex) {
			return false;
		}
	}
}
