package br.com.alura.tdd.modelo;

public enum DesempenhoEnum {

	A_DESEJAR(0.03),
	BOM(0.15),
	OTIMO(0.20);
	
	private double percentual;
	
	DesempenhoEnum(double percentual) {
		this.percentual = percentual;
	}
	
	public double getPercentual() {
		return percentual;
	}
	
}
