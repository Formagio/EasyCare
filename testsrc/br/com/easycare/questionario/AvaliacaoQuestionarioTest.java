package br.com.easycare.questionario;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.easycare.meta.Meta;
import br.com.easycare.meta.PerdaPesoComCorrida;
import br.com.easycare.meta.PerdaPesoComNatacao;

public class AvaliacaoQuestionarioTest {
	
	private Questionario questionario;
	
	@Before
	public void setup() {
		questionario = new Questionario();
	}
	
	@Test
	public void deveSugerirPerdaDePesoComCorrida() {
		questionario.setAltura(1.78f);
		questionario.setPeso(92f);
		questionario.setPossuiProblemaNasArticulacoes(false);
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<Meta> metas = avaliacao.avaliar();
		
		// Testa se a lista de metas contém a meta definida pelo teste
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(PerdaPesoComCorrida.class.getName())).findFirst().isPresent());
	}

	@Test
	public void deveSugerirPerdaDePesoComNatacao() {
		questionario.setAltura(1.78f);
		questionario.setPeso(92f);
		questionario.setPossuiProblemaNasArticulacoes(true);
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<Meta> metas = avaliacao.avaliar();
		
		// Testa se a lista de metas contém a meta definida pelo teste
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(PerdaPesoComNatacao.class.getName())).findFirst().isPresent());
	}
	
}
