package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.atividade.ExameProstata;
import br.com.easycare.questionario.Questionario;

public class AlertaExameProstata implements IMeta {
	
	@Override
	public String getDescricao() {
		return "Deve ser feito exame de prostata anualmente";
	}
	
	@Override
	public List<IAtividade> getAtividades() {
		return Arrays.asList(new ExameProstata());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		try {
			return questoes.getGenero().equals("M") && (
				(questoes.getIdade() >= 50 && !questoes.PossuiHistoricoFamiliarCancerProstata()) || 
				(questoes.getIdade() >= 45 && questoes.PossuiHistoricoFamiliarCancerProstata()));
		} catch (Exception ex) {
			return false;
		}
	}
	
}
