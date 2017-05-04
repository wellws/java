package compadresToy;

public class Manufacturers {

	private String name;
	private String country;
	private int registry;

	public Manufacturers(){

		setCountry("");
		setName("");
		setRegistry(0);
	}

	public Manufacturers(String name){

		setCountry("");
		setName(name);
		setRegistry(0);
	}
	
	public Manufacturers(int code){

		setCountry("");
		setName("");
		setRegistry(code);
	}
	
	public Manufacturers(int registry, String name, String country){

		setCountry(country);
		setName(name);
		setRegistry(registry);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the registry
	 */
	public int getRegistry() {
		return registry;
	}

	/**
	 * @param registry the registry to set
	 */
	public void setRegistry(int registry) {
		this.registry = registry;
	}
}
