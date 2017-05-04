package Conta;

public class Conta {

	private int total;
	private String descricao;
	private Gerente gerente;
	private Cliente cliente;

	public Conta() {

		setDescricao(" ");
		setTotal(0);
	}

	public Conta(int total) {

		setDescricao(" ");
		setTotal(total);
	}

	public Conta(String descricao) {

		setDescricao(descricao);
		setTotal(0);
	}

	public Conta(String descricao, int total) {

		setDescricao(descricao);
		setTotal(total);
	}

	public Conta(String descricao, int total, Cliente cliente) {

		setCliente(cliente);
		setDescricao(descricao);
		setTotal(total);
	}
	
public Conta(String descricao, int total, Gerente gerente) {
		
		setGerente(gerente);
		setDescricao(descricao);
		setTotal(total);
	}

	public Conta(String descricao, int total, Gerente gerente, Cliente cliente) {

		setGerente(gerente);
		setCliente(cliente);
		setDescricao(descricao);
		setTotal(total);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int calcTotal() {

		return getTotal();
	}
}
