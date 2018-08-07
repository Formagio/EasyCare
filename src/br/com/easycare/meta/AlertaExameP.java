package br.com.easycare.meta;

import java.util.Arrays;
import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.atividade.ExameP;
import br.com.easycare.questionario.Questionario;

public class AlertaExameP implements Meta{
	
	@Override
	public String getDescricao() {
		return "Deve ser feito exame de prostata anualmente";
	}
	
	@Override
	public List<Atividade> getAtividades() {
		return Arrays.asList(new ExameP());
	}
  
	@Override
	public boolean PodeSerAplicada(Questionario questoes) {
		return ( (questoes.getGenero().equals("M")) && (((questoes.getIdade()>=50) &&
			!(questoes.PossuiHistoricoFamiliarCancerProstata())) || ((questoes.getIdade()>=45) &&
					(questoes.PossuiHistoricoFamiliarCancerProstata())))  );
	}
	
	
}
