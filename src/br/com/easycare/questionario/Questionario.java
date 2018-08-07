package br.com.easycare.questionario;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Questionario {
	
	private float altura;
	private float peso;
	private int idade;
	private String genero;
			

	private Date dataNascimento;
	private boolean possuiProblemaNasArticulacoes;	
	private boolean possuiHistoricoFamiliarCancerProstata;
	private boolean possuiHistoricoFamiliarCancerMama;
	
	private final float IMC_MINIMO_FAIXA_PESO_IDEAL = 18.5f;
	private final float IMC_MAXIMO_FAIXA_PESO_IDEAL = 25;
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
		
	public float getAltura() {
		return this.altura;
	}
			
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float getPeso() {
		return this.peso;
	}

	public boolean getPossuiProblemaNasArticulacoes() {
		return this.possuiProblemaNasArticulacoes;
	}

	public void setPossuiProblemaNasArticulacoes(boolean possuiProblemaNasArticulacoes) {
		this.possuiProblemaNasArticulacoes = possuiProblemaNasArticulacoes;
	}
	
	public boolean estaAbaixoDoPesoIdeal() {
		return this.getIMC() < IMC_MINIMO_FAIXA_PESO_IDEAL;
	}
	
	public boolean estaAcimaDoPesoIdeal() {
		return this.getIMC() > IMC_MAXIMO_FAIXA_PESO_IDEAL;
	}
	
	public float getIMC() {
		return this.peso / (this.altura * this.altura);
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return this.idade; 
	}
		
	public void setIdade() {	
		GregorianCalendar hj=new GregorianCalendar();
		GregorianCalendar nascimento=new GregorianCalendar();
		if(this.getDataNascimento()!=null){
			nascimento.setTime(this.getDataNascimento());
		}		
		int anohj=hj.get(Calendar.YEAR);
		int anoNascimento=nascimento.get(Calendar.YEAR);
		this.idade = (anohj-anoNascimento);
	}
	
	public boolean PossuiHistoricoFamiliarCancerProstata() {
		return possuiHistoricoFamiliarCancerProstata;
	}

	public void setPossuiHistoricoFamiliarCancerProstata(boolean possuiHistoricoFamiliarCancerProstata) {
		this.possuiHistoricoFamiliarCancerProstata = possuiHistoricoFamiliarCancerProstata;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isPossuiHistoricoFamiliarCancerMama() {
		return possuiHistoricoFamiliarCancerMama;
	}

	public void setPossuiHistoricoFamiliarCancerMama(boolean possuiHistoricoFamiliarCancerMama) {
		this.possuiHistoricoFamiliarCancerMama = possuiHistoricoFamiliarCancerMama;
	}
	
	
	
}
