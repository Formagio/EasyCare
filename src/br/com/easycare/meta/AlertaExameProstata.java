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
	public boolean PodeSerAplicada(Questionario questionario) {
		try {
			return questionario.getGenero().equals("M") && (
				(questionario.getIdade() >= 50 && !questionario.PossuiHistoricoFamiliarCancerProstata()) || 
				(questionario.getIdade() >= 45 && questionario.PossuiHistoricoFamiliarCancerProstata()));
		} catch (Exception ex) {
			return false;
		}
	}
	
}
