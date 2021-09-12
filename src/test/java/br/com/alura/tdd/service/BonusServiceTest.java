package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.alura.tdd.modelo.Funcionario;

@TestInstance(Lifecycle.PER_CLASS)
class BonusServiceTest {

	private BonusService bonusService;
	
	@BeforeAll
	void init() {
		bonusService = new BonusService();
	}
	
	@Test
	void bonusDeDezPorcentoComValorMenorQueLimite() {
		BigDecimal salario = new BigDecimal("9500");
		Funcionario funcionario = new Funcionario("Idinaldo", LocalDate.now(), salario);
		assertEquals(new BigDecimal("950.00"), bonusService.calcularBonus(funcionario));
	}
	
	@Test
	void bonusDeZeroPorcentoAcimaDoLimite() {
		BigDecimal salario = new BigDecimal("10100");
		Funcionario funcionario = new Funcionario("Idinaldo", LocalDate.now(), salario);
		assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario)) ;
	}
	
	@Test
	void bonusDeDezPorcentoComValorIgualLimite() {
		BigDecimal salario = new BigDecimal("10000");
		Funcionario funcionario = new Funcionario("Idinaldo", LocalDate.now(), salario);
		assertEquals(new BigDecimal("1000.00"), bonusService.calcularBonus(funcionario));
	}

}
