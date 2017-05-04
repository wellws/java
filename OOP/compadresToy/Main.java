package compadresToy;

public class Main {

	public static void main(String[] args) {
		
		Toy brinquedo = new Toy(13,"novo");
		Doll boneco = new Doll("lion", 4, "velho");
		Manufacturers fabricante = new Manufacturers(8, "FIAT", "IT");
		Car carro = new Car(22, "Esportivo", "", fabricante);
		
		System.out.println(carro.getManufacturers().getName());
	}

}
