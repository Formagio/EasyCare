package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.atividade.ExameM;
import br.com.easycare.questionario.Questionario;

public class AlertaExameM implements Meta{
	
	@Override
	public String getDescricao() {
		return "Deve ser feito exame de mama anualmente";
	}
	
	@Override
	public List<Atividade> getAtividades() {
		return Arrays.asList(new ExameM());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		return ( (questoes.getGenero().equals("F")) && (((questoes.getIdade()>=40) &&
			!(questoes.PossuiHistoricoFamiliarCancerMama())) || ((questoes.getIdade()>=35) &&
					(questoes.PossuiHistoricoFamiliarCancerMama())))  );
	}
	
}
