package Triangulo;

//classe
public class Triangulo {
	
	//atributos
	private int a, b, c;

	//metodos acessores
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
	
	//construtor
	public Triangulo(int a, int b, int c) {
	
		setA(a);
		setB(b);
		setC(c);
	}
	
	public String retornarTipo() {
		 
		
		if((getA() == 0) || (getB() == 0) || (getC() == 0))
		return "Todos os lados são Nulos";
		 
		//if((getA() == 0) || (getB() == 0) || (getC() == 0)) 
		//return "Lado Nulo";
		 
		if((getA() < 0) || (getB() < 0) || (getC() < 0))
		return "Lado Negativo";
		 
		if((getA() == getB()) && (getB() == getC() ))
		return "Equilátero";
		 
		if(
		((getA() != getB()) && (getB() == getC() ))||
		((getA() == getB()) && (getB() != getC() ))||
		((getA() == getC()) && (getB() != getC() ))
		) 
		return "Isósceles";
		 
		if( (getA() + getB() == getC() )||
		(getB() + getC() == getA())||
		(getC() + getA() == getB())
		)
		return "Soma dos dois lados igual a terceiro";
		 
		if( (getA() + getB()< getC())||
		(getB() + getC() < getA())||
		(getC() + getA() < getB())
		)
		return "Soma dos dois lados menor que a terceiro";
		 
		if((getA() != getB()) && (getA() != getC()))
		return "Escaleno";
		 
		return null;	
	}
}

