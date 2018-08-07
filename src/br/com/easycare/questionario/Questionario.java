package br.com.easycare.questionario;

public class Questionario {
	
	private float altura;
	private float peso;
	private boolean possuiProblemaNasArticulacoes;	
	
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
	
}
