package br.com.easycare.meta;

import java.util.List;

import br.com.easycare.atividade.Atividade;
import br.com.easycare.questionario.Questionario;

public interface Meta {
	
	public String getDescricao();
	public List<Atividade> getAtividades();
	public boolean PodeSerAplicada(Questionario questoes);
	
}