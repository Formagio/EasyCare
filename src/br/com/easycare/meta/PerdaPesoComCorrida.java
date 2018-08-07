package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.atividade.Corrida;
import br.com.easycare.questionario.Questionario;

public class PerdaPesoComCorrida implements Meta {
	
	@Override
	public String getDescricao() {
		return "Correr 5 kilômetros três vezes por semana durante dois meses";
	}

	@Override
	public List<Atividade> getAtividades() {
		return Arrays.asList(new Corrida());
	}

	@Override
	public boolean PodeSerAplicada(Questionario questionario) {
		return questionario.estaAcimaDoPesoIdeal() &&
			!questionario.getPossuiProblemaNasArticulacoes();
	}
	
}
