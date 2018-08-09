package br.com.easycare.questionario;

import java.util.ArrayList;
import java.util.List;

import br.com.easycare.meta.AlertaExameM;
import br.com.easycare.meta.AlertaExameP;
import br.com.easycare.meta.AlertaQuantidadeHorasIdealSono;
import br.com.easycare.meta.Meta;
import br.com.easycare.meta.PerdaPesoComCorrida;
import br.com.easycare.meta.PerdaPesoComNatacao;

public class Avaliacao {
	
	private Questionario questionario;
	
	public Avaliacao(Questionario questionario) {
		this.questionario = questionario;
	}
	
	public List<Meta> avaliar() {
		ArrayList<Meta> metas = new ArrayList<Meta>();
		
		//TODO: usar reflexão
		if (new PerdaPesoComCorrida().PodeSerAplicada(questionario)) {
			metas.add(new PerdaPesoComCorrida());
		}
		
;		if (new PerdaPesoComNatacao().PodeSerAplicada(questionario)) {
			metas.add(new PerdaPesoComNatacao());
		}
		
		if (new AlertaExameP().PodeSerAplicada(questionario)) {
			metas.add(new AlertaExameP());
		}
		
		if (new AlertaExameM().PodeSerAplicada(questionario)) {
			metas.add(new AlertaExameM());
		}
		
		if(new AlertaQuantidadeHorasIdealSono().PodeSerAplicada(questionario)) {
			metas.add(new AlertaQuantidadeHorasIdealSono());
		}
		
		// Busca todas as classes que implementam a interface Meta
		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ServiceLoader<Meta> servLoader = ServiceLoader.load(Meta.class, classLoader);
		
		for (Meta driver : servLoader) {
		   String driverName = driver.getClass().getName();		   
		   
		   try {
			   Meta meta = (Meta) Class.forName(driverName).newInstance();
			   
			   if (meta.PodeSerAplicada(this.questionario)) {
				   metas.add(meta);
			   }
		   } catch (ClassNotFoundException e) {
		   } catch (InstantiationException e) {
		   } catch (IllegalAccessException e) {
		   }
		}*/
		
		return metas;
	}
}
