package Conta;

public class main {

	public static void main(String[] args) {
		
		System.out.println("start");
		
		Cliente cliente = new Cliente(22, "tom");
		Cliente branca = new Cliente(8, "branca");
		
		Pessoa pessoa = new Pessoa("Gustavo");
		
		Gerente gerente = new Gerente("A","Pedro");
		
		Conta conta = new Conta("joao",1200,gerente,cliente);
		
		System.out.println( conta.getCliente().getNome());

	}

}
