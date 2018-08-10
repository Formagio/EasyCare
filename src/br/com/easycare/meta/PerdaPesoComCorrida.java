package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.atividade.Corrida;
import br.com.easycare.questionario.Questionario;

public class PerdaPesoComCorrida implements IMeta {
	
	@Override
	public String getDescricao() {
		return "Correr 5 kilômetros três vezes por semana durante dois meses";
	}

	@Override
	public List<IAtividade> getAtividades() {
		return Arrays.asList(new Corrida());
	}

	@Override
	public boolean PodeSerAplicada(Questionario questionario) {
		try {		
			return questionario.estaAcimaDoPesoIdeal() &&
				!questionario.getPossuiProblemaNasArticulacoes();
		} catch (Exception ex) {
			return false;
		}
	}
	
}
