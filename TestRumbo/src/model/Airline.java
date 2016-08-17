package model;

/**
 * 
 * @author usamaalanbari
 *
 */
public class Airline {

	private String iataCode;
	private String name;
	private float infantPrice;
	
	public Airline(String iataCode, String name, float infantPrice){
		this.iataCode = iataCode;
		this.name = name;
		this.infantPrice = infantPrice;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(float infantPrice) {
		this.infantPrice = infantPrice;
	}
	
	
}
