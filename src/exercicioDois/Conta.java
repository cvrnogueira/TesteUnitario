package exercicioDois;

import java.math.BigDecimal;

public class Conta {
	
	private String nomeCliente;
	private BigDecimal saldo;
	private Categorias categoriaDaConta;
	
	
	public Conta(String nomeCliente){
		this.nomeCliente = nomeCliente;
		this.saldo = new BigDecimal(0);
		this.categoriaDaConta = Categorias.SILVER;
	}
	
	 public String getNomeCliente(){
		 return nomeCliente;
	 }
	 public BigDecimal getSaldo(){
		 return saldo;
	 }
	 public Categorias getStatus(){
		 return categoriaDaConta;
	 }
	 public void deposito(BigDecimal valor) {
		 if(valor.compareTo(BigDecimal.ZERO) == 0 || valor.compareTo(BigDecimal.ZERO) == -1 ){ //deposito zero ou negativo
			 System.out.println("Não pode depositar valor negativo ou nulo!"); 
		 }
		 else{
			 if(categoriaDaConta.valorizacao(categoriaDaConta).compareTo(BigDecimal.ZERO) != 0){
				 valor = valor.multiply(categoriaDaConta.valorizacao(categoriaDaConta));
			 }
			 saldo = saldo.add(valor);
			 categoriaDaConta = categoriaDaConta.verificaCategoria(saldo,categoriaDaConta);
		 }
	 }
	 public void retirada(BigDecimal valor) {
		 if(valor.compareTo(BigDecimal.ZERO) == 0 || valor.signum() == -1 ){ //deposito zero ou negativo
			 System.out.println("Não pode retirar valor negativo ou nulo!"); 
		 }
		 else if(saldo.compareTo(valor) == -1){ //se o saldo for menor do que o valor a ser retirado
			 System.out.println("Você não tem saldo suficiente para isso!");
		 }
			 else{
				 saldo = saldo.subtract(valor);
				 categoriaDaConta = categoriaDaConta.verificaCategoria(saldo,categoriaDaConta); //pode regredir de categoria
			 }
	 }
}
