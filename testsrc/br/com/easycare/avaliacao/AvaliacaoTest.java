package br.com.easycare.avaliacao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.easycare.avaliacao.Avaliacao;
import br.com.easycare.meta.AlertaExameMama;
import br.com.easycare.meta.AlertaExameProstata;
import br.com.easycare.meta.AlertaQuantidadeHorasIdealSono;
import br.com.easycare.meta.IMeta;
import br.com.easycare.meta.PerdaPesoComCorrida;
import br.com.easycare.meta.PerdaPesoComNatacao;
import br.com.easycare.questionario.Questionario;

public class AvaliacaoTest {
	
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
		List<IMeta> metas = avaliacao.avaliar();
		
		// Testa se a lista de metas contém a meta definida pelo teste
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(PerdaPesoComCorrida.class.getName())).findFirst().isPresent());
	}

	@Test
	public void deveSugerirPerdaDePesoComNatacao() {
		questionario.setAltura(1.78f);
		questionario.setPeso(92f);
		questionario.setPossuiProblemaNasArticulacoes(true);
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<IMeta> metas = avaliacao.avaliar();
		
		// Testa se a lista de metas contém a meta definida pelo teste
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(PerdaPesoComNatacao.class.getName())).findFirst().isPresent());
	}
	@Test
	//caso de teste 3
	public void deveSugerirExameDeProstata() {		
		questionario.setIdade(50);
		questionario.setPossuiHistoricoFamiliarCancerProstata(true);
		questionario.setGenero("M");
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<IMeta> metas = avaliacao.avaliar();
		
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(AlertaExameProstata.class.getName())).findFirst().isPresent());
	}
	
	
	//caso de teste 4
	@Test
	public void deveSugerirExameDeMama() {		
		questionario.setIdade(40);
		questionario.setPossuiHistoricoFamiliarCancerMama(false);
		questionario.setGenero("F");
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<IMeta> metas = avaliacao.avaliar();
		
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(AlertaExameMama.class.getName())).findFirst().isPresent());
	}
	
	// caso de teste 5
	@Test
	public void deveSugerirQuantidadeHorasIdealDeSono() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date dateStart = null;
		Date dateEnd = null;
		try {
			dateStart = (Date)formatter.parse("08/07/2018 23:00");
			dateEnd = (Date)formatter.parse("08/08/2018 05:30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		questionario.setDataInicioSono(dateStart);
		questionario.setDataFinalSono(dateEnd);
		
		Avaliacao avaliacao = new Avaliacao(questionario);
		List<IMeta> metas = avaliacao.avaliar();
		
		Assert.assertTrue(metas.stream().filter(o -> o.getClass().getName().equals(AlertaQuantidadeHorasIdealSono.class.getName())).findFirst().isPresent());
	}
}
