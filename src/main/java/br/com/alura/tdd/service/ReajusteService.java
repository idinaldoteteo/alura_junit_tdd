package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajusteSalarial(Funcionario funcionario, DesempenhoEnum desempenho) {
		BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal(desempenho.getPercentual()));
		funcionario.reajustarSalario(aumento);
	}
}
