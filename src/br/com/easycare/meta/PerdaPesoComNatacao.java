package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.atividade.Natacao;
import br.com.easycare.questionario.Questionario;

public class PerdaPesoComNatacao implements Meta {
	
	@Override
	public String getDescricao() {
		return "Praticar natação duas vezes por semana durante três meses";
	}

	@Override
	public List<Atividade> getAtividades() {
		return Arrays.asList(new Natacao());
	}
	
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		return questoes.estaAcimaDoPesoIdeal() &&
			questoes.getPossuiProblemaNasArticulacoes();
	}
	
}
