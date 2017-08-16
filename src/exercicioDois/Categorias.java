package exercicioDois;

import java.math.BigDecimal;

public enum Categorias {
	GOLD, SILVER, PLATINUM;
	
	
	public BigDecimal valorizacao(Categorias categoria){
		if(categoria.equals(Categorias.SILVER)){
			return new BigDecimal(0);
		}
		else if(categoria.equals(Categorias.GOLD)){
			return new BigDecimal(1.01);
		}
		else{
			return new BigDecimal(1.025);
		}
	}
	public Categorias verificaCategoria(BigDecimal saldo, Categorias categoria){
		if(saldo.compareTo(new BigDecimal(50000)) == 0 || (((saldo.compareTo(new BigDecimal(50000))) == 1) && ((saldo.compareTo(new BigDecimal(200000)) == -1)))){ //se for maior ou igual a 50000 mas menor que 200000
			return GOLD;
		 }
		 else if(saldo.compareTo(new BigDecimal(200000)) == 0 || saldo.compareTo(new BigDecimal(200000)) == 1){
			 return PLATINUM;
		 }
		 else{
			 return SILVER;
		 }
	}
	
}
