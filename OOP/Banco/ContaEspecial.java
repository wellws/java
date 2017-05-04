package Conta;

public class ContaEspecial extends Conta {

	private int limite;

	public ContaEspecial() {

		setTotal(0);
		setLimite(0);
	}

	public ContaEspecial(int limite) {
		
		setTotal(0);
		setLimite(limite);
	}
	
	public ContaEspecial(int limite, int total) {
		
		setTotal(total);
		setLimite(limite);
	}
	

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int calcTotal() {

		return getLimite() + getTotal();
	}
}
