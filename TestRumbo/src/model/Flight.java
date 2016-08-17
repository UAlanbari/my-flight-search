package model;

public class Flight {
	
	private String origin;
	private String destination;
	private String airline;
	private Float price;
	
	public Flight(String origin, String destination, String airline, float price) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.price = price;
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
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight key = (Flight) o;
        return origin == key.origin && destination == key.destination;
    }

    @Override
    public int hashCode() {
//    	final int prime = 31;
//    	int result = 1;
//    	result = prime * result
//    			+ ((this.origin == null) ? 0 : this.origin.hashCode());
//    	result = prime * result
//    			+ ((lastName == null) ? 0 : lastName.hashCode());
    	return this.origin.hashCode() + this.destination.hashCode();
    }

	
}
