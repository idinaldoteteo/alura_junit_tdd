package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {
	private BigDecimal salarioLimite =  new BigDecimal("1000.00");
	private static ReajusteService desempenhoService;
	private Funcionario funcionario;
	
	@BeforeAll
	static void init() {
		desempenhoService = new ReajusteService();
	}
	
	@BeforeEach
	void inicializar() {
		this.funcionario = new Funcionario("Idinaldo", LocalDate.now(), salarioLimite);
	}
	
	@Test
	void reajustarSalarioComTresPorcento() {
		desempenhoService.reajusteSalarial(funcionario, DesempenhoEnum.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajustarSalarioComQuinzePorcento() {
		desempenhoService.reajusteSalarial(funcionario, DesempenhoEnum.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajustarSalarioComVintePorcento() {
		desempenhoService.reajusteSalarial(funcionario, DesempenhoEnum.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
