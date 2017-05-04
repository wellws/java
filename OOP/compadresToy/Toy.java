package compadresToy;

public class Toy {
	
	//Att
	private int code; 
	private String description;
	
	//Method
	public Toy() {
		setCode(0);
		setDescription("");
	}
	
	public Toy(int code) {
		setCode(code);
		setDescription("");
	}
	
	public Toy(String description) {
		setCode(0);
		setDescription(description);
	}
	
	public Toy(int code, String description) {
		setCode(code);
		setDescription(description);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
