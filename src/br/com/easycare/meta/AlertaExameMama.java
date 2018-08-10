package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.atividade.ExameMama;
import br.com.easycare.questionario.Questionario;

public class AlertaExameMama implements IMeta {
	
	@Override
	public String getDescricao() {
		return "Deve ser feito exame de mama anualmente";
	}
	
	@Override
	public List<IAtividade> getAtividades() {
		return Arrays.asList(new ExameMama());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		try
		{
			return questoes.getGenero().equals("F") && (
				(questoes.getIdade() >= 40 && !questoes.PossuiHistoricoFamiliarCancerMama()) || 
				(questoes.getIdade() >= 35 && questoes.PossuiHistoricoFamiliarCancerMama()));
		} catch (Exception ex) {
			return false;
		}
	}
	
}
