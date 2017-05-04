package Conta;

public class Cliente extends Pessoa {

	private int codigo;

	public Cliente() {

		setCodigo(0);
	}

	public Cliente(int codigo) {

		setNome(" ");
		setCodigo(codigo);
	}

	public Cliente(String nome) {

		setNome(nome);
		setCodigo(0);
	}

	public Cliente(int codigo, String nome) {

		setNome(nome);
		setCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


}
