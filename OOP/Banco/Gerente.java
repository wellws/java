package Conta;

public class Gerente extends Pessoa{

	private String setor;

	public Gerente() {

		setSetor(" ");
		setNome(" ");
	}

	public Gerente(String setor) {

		setSetor(setor);
		setNome(" ");
	}
	
	/*public Gerente (String nome) {

		setSetor(" ");
		setNome(nome);
	}*/
	
	public Gerente(String setor, String nome) {

		setSetor(setor);
		setNome(nome);
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	} 

}
