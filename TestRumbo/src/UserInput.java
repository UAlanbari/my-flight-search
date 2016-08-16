/**
 * 
 * @author usamaalanbari
 *
 */
public class UserInput {
	
	private String origin;
	private String destination;
	private Float dateOfDeparture;
	private Passengers passengers;
	
	public UserInput(String origin, String destination, Float dateOfDeparture, Passengers passengers){
		this.origin = origin;
		this.destination = destination;
		this.dateOfDeparture = dateOfDeparture;
		this.passengers = passengers;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Float getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Float dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Passengers getPassengers() {
		return passengers;
	}
	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}
	
	

}
