package exercicioDois;

import static org.junit.Assert.*;
import java.math.BigDecimal;

import org.junit.Test;

public class ContaMagicaTest {

	@Test
	public void adicionaSaldoPositivo() {
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(10));
		assertEquals(c1.getSaldo(), new BigDecimal(10)); //mudar!!! colocar o primeira parametro o q eu espero, e o segundo o valor que vem mesmo
	}
	@Test
	public void adicionaSaldoPositivoDuasvezes(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(10));
		c1.deposito(new BigDecimal(10.8765));
		assertEquals(c1.getSaldo(), new BigDecimal(20.8765));
	}
	@Test
	public void DepositoNegativo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(12));
		c1.deposito(new BigDecimal(-12));
		assertEquals(c1.getSaldo(), new BigDecimal(12));
	}
	@Test
	public void DepositoNulo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200000));
		c1.deposito(new BigDecimal(0));
		assertEquals(c1.getSaldo(), new BigDecimal(200000));
	}
	@Test
	public void retiraTendoOSaldo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(10));
		c1.deposito(new BigDecimal(10.8765));
		c1.retirada((new BigDecimal(20)));
		BigDecimal teste = new BigDecimal(0.8765).subtract(c1.getSaldo());
		assertTrue(teste.compareTo(new BigDecimal(0.001)) == -1); //testa se o teste é menor do que 0,001
	}
	@Test
	public void retiraNaoTendoOSaldo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(10));
		c1.deposito(new BigDecimal(10.8765));
		c1.retirada((new BigDecimal(200)));
		assertEquals(c1.getSaldo(), new BigDecimal(20.8765));
	}
	@Test
	public void retiraSaldonegativo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200000));
		c1.retirada(new BigDecimal(-100));
		assertEquals(c1.getSaldo(), new BigDecimal(200000));
	}
	@Test
	public void retiraSaldoNulo(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200000));
		c1.retirada(new BigDecimal(0));
		assertEquals(c1.getSaldo(), new BigDecimal(200000));
	}
	@Test
	public void verificaCategoriaGold(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(50000));
		assertEquals(c1.getStatus(), Categorias.GOLD);
	}
	@Test
	public void verificaCategoriaGold2(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(50040));
		assertEquals(c1.getStatus(), Categorias.GOLD);
	}
	@Test
	public void verificaCategoriaPlatinum(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200000));
		assertEquals(c1.getStatus(), Categorias.PLATINUM);
	}
	@Test
	public void verificaCategoriaPlatinum2(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(230000000));
		assertEquals(c1.getStatus(), Categorias.PLATINUM);
	}
	@Test
	public void verificaCategoriaSilver(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(1200));
		assertEquals(c1.getStatus(), Categorias.SILVER);
	}
	@Test
	public void verificaValorizacaoGold(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(50000));
		c1.deposito(new BigDecimal(1000));
		BigDecimal teste = new BigDecimal(51010).subtract(c1.getSaldo());
		assertTrue(teste.compareTo(new BigDecimal(0.001)) == -1); //testa se o teste é menor do que 0,001
	}
	@Test
	public void verificaValorizacaoSilver(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200));
		c1.deposito(new BigDecimal(1000));
		assertEquals(c1.getSaldo(), new BigDecimal(1200));
	}
	@Test
	public void verificaValorizacaoPlatinum(){
		Conta c1 = new Conta("Usuário 01");
		c1.deposito(new BigDecimal(200000));
		c1.deposito(new BigDecimal(1000));
		BigDecimal teste = new BigDecimal(21025).subtract(c1.getSaldo());
		assertTrue(teste.compareTo(new BigDecimal(0.001)) == -1); //testa se o teste é menor do que 0,001
	}

}
