package br.com.easycare.meta;

import br.com.easycare.questionario.Questionario;

public abstract class AlertaExameP implements Meta{

	public boolean DefinirAlerta(Questionario questoes) {
		return ( (questoes.getGenero().equals("M")) && (((questoes.getIdade()>=50) &&
			!(questoes.PossuiHistoricoFamiliarCancerProstata())) || ((questoes.getIdade()>=45) &&
					(questoes.PossuiHistoricoFamiliarCancerProstata())))  );
	}
	
	
}
