package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.atividade.SonoIdeal;
import br.com.easycare.questionario.Questionario;

public class AlertaQuantidadeHorasIdealSono implements Meta {
	@Override
	public String getDescricao() {
		return "Para manter seu equilíbrio e a produtividade alta procure dormir de 7 a 9 horas por noite.";
	}
	
	@Override
	public List<Atividade> getAtividades() {
		return Arrays.asList(new SonoIdeal());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		
		long diferencaMS = questoes.getDataInicioSono().getTime() - questoes.getDataFinalSono().getTime();
	    long diferencaSegundos = diferencaMS / 1000;
	    long diferencaMinutos = diferencaSegundos / 60;
	    long diferencaHoras = diferencaMinutos / 60;
		
		return diferencaHoras < 7 || diferencaHoras > 11;
	}
}
