package model;
/**
 * 
 * @author usamaalanbari
 *
 */
public class UserOutput {
	
	private String flightCode;
	private float flightPrice;
	
	public UserOutput(String flightCode, float flightPrice){
		this.flightCode = flightCode;
		this.flightPrice = flightPrice;
	}

	public UserOutput() {
		// TODO Auto-generated constructor stub
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public float getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(float flightPrice) {
		this.flightPrice = flightPrice;
	}
	
	

}
