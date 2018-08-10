package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.atividade.Natacao;
import br.com.easycare.questionario.Questionario;

public class PerdaPesoComNatacao implements IMeta {
	
	@Override
	public String getDescricao() {
		return "Praticar natação duas vezes por semana durante três meses";
	}

	@Override
	public List<IAtividade> getAtividades() {
		return Arrays.asList(new Natacao());
	}
	
	@Override
	public boolean PodeSerAplicada(Questionario questionario) {
		try {
			return questionario.estaAcimaDoPesoIdeal() &&
				questionario.getPossuiProblemaNasArticulacoes();
		} catch (Exception ex) {
			return false;
		}
	}
	
}
