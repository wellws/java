package compadresToy;

public class Car extends Toy {

	private String color;
	private Manufacturers manufacturers;

	public Car(){

		setColor("");
	}

	public Car(String color){

		setColor(color);
	}

	public Car(String color, Manufacturers manufacturers) {

		setColor(color);
		setManufacturers(manufacturers);
	}

	public Car(int code, String color) {

		setCode(code);
		//setDescription(description);
		setColor(color);
		//	setManufacturers(manufacturers);
	}

	public Car(int code, String description, String color) {
		
		setCode(code);
		setDescription(description);
		setColor(color);
		//	setManufacturers(manufacturers);
	}

	public Car(int code, String description, String color, Manufacturers manufacturers) {

		setCode(code);
		setDescription(description);
		setColor(color);
		setManufacturers(manufacturers);
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Manufacturers getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}


}
