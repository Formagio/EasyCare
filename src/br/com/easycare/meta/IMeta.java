package br.com.easycare.meta;

import java.util.List;

import br.com.easycare.atividade.IAtividade;
import br.com.easycare.questionario.Questionario;

public interface IMeta {
	
	public String getDescricao();
	public List<IAtividade> getAtividades();
	public boolean PodeSerAplicada(Questionario questoes);
	
}