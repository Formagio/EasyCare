package br.com.easycare.avaliacao;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import br.com.easycare.meta.AlertaExameMama;
import br.com.easycare.meta.AlertaExameProstata;
import br.com.easycare.meta.AlertaQuantidadeHorasIdealSono;
import br.com.easycare.meta.IMeta;
import br.com.easycare.meta.PerdaPesoComCorrida;
import br.com.easycare.meta.PerdaPesoComNatacao;
import br.com.easycare.questionario.Questionario;

public class Avaliacao {
	
	private Questionario questionario;
	
	public Avaliacao(Questionario questionario) {
		this.questionario = questionario;
	}
	
	public List<IMeta> avaliar() {
		ArrayList<IMeta> metas = new ArrayList<IMeta>();
		
		//TODO: usar reflexão
		if (new PerdaPesoComCorrida().PodeSerAplicada(questionario)) {
			metas.add(new PerdaPesoComCorrida());
		}
		
		if (new PerdaPesoComNatacao().PodeSerAplicada(questionario)) {
			metas.add(new PerdaPesoComNatacao());
		}
		
		if (new AlertaExameProstata().PodeSerAplicada(questionario)) {
			metas.add(new AlertaExameProstata());
		}
		
		if (new AlertaExameMama().PodeSerAplicada(questionario)) {
			metas.add(new AlertaExameMama());
		}
		
		if(new AlertaQuantidadeHorasIdealSono().PodeSerAplicada(questionario)) {
			metas.add(new AlertaQuantidadeHorasIdealSono());
		}
		
		// Busca todas as classes que implementam a interface Meta
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ServiceLoader<IMeta> servLoader = ServiceLoader.load(IMeta.class, classLoader);
		
		for (IMeta driver : servLoader) {
		   String driverName = driver.getClass().getName();		   
		   
		   try {
			   IMeta meta = (IMeta) Class.forName(driverName).newInstance();
			   
			   if (meta.PodeSerAplicada(this.questionario)) {
				   metas.add(meta);
			   }
		   } catch (ClassNotFoundException e) {
		   } catch (InstantiationException e) {
		   } catch (IllegalAccessException e) {
		   }
		}
		
		return metas;
	}
	
}
