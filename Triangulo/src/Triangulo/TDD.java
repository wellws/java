package Triangulo;

//Importamos as classes que precisamos para usar os métodos citados

//Importante importar essa como static, 
//pois usamos os métodos estáticos para realizar as comparações.

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/* Usar o RunWith informando que vamos usar uma classe parametrizada.
* Isso fará com que ao ser instanciada como JUnit Test, 
* a classe crie um objeto usando os parâmetros informados
* no método Parameters para realizar cada teste, 
* economizando dezenas de linhas de código.
*/
@RunWith(Parameterized.class)

//Declaramos uma classe normal
public class TDD {

	// Declaramos os inteiros que representarão os lados do triângulo
	private int a;
	private int b;
	private int c;
	
	// Declaramos a string que representará o resultado esperado
	private String tipo;
	
	// Metodos acessores
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public int getC() {
		return c;
	}


	public void setC(int c) {
		this.c = c;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	// Criamos o construtor que receberá os parâmetros para execução do teste
	public TDD(int a, int b, int c, String trianguloEsperado) {
	
		super();
		
		// Cada lado do triângulo recebe um valor
		//que vem dos parâmetros da classe
		setA(a);
		setB(b);
		setC(c);
		 
		// O resultado esperado recebe o ultimo parâmetro
		setTipo(trianguloEsperado);
	}
	
	// Método que retorna uma coleção 
	//com os parâmetros que serão usados no construtor instânciado para os testes
	
	@Parameters
	public static Collection carregaTriangulosDeTeste(){
	
		return Arrays.asList(
	
			new Object [][]{
				
				// Como array em Java começa no 0, 
				//vamos incluir o teste 1 na posição 0 do array 
				//e assim por diante
				 
				//Test0
				{2, 9, 10,"Escaleno"},
				 
				//Test1
				{20, 20, 20, "Equilátero"},
				 
				//Test2
				{20, 20, 30, "Isósceles"},
				 
				//Test3
				{20, 30, 20, "Isósceles"},
				 
				//Test4
				{30, 20, 20, "Isósceles"},
				 
				//Test5
				//{0, 2, 9, "Lado Nulo"},
				 
				//Test6
				{3, -2, 9, "Lado Negativo"},
				 
				//Test7
				{5, 6, 11, "Soma dos dois lados igual a terceiro"},
				
				//Test8
				{5, 11, 6, "Soma dos dois lados igual a terceiro"},
				 
				//Test9
				{11, 6, 5, "Soma dos dois lados igual a terceiro"},
				 
				//Test10
				{5, 6, 12, "Soma dos dois lados menor que a terceiro"},
				 
				//Test11
				{0, 0, 0, "Todos os lados são Nulos"},
				 
				//Test12
				{5, 12, 6, "Soma dos dois lados menor que a terceiro"},
				 
				//Test13
				{12, 5, 6, "Soma dos dois lados menor que a terceiro"},	
			}	
		);				
	}
	
	// Método que executa o teste a cada instanciação do objeto da classe teste	

	@Test
	public void test() {
		
		// Um objeto do tipo Trianglulo 
		//e passar os parâmetros do seu construtor
		Triangulo escalenoValido = new Triangulo(a, b, c);
		 
		// Realizamos a comparação entre o valor que foi retornado 
		//e o valor que é esperado
		assertEquals(escalenoValido.retornarTipo(), tipo);
	}

}

