package model;

/**
 * 
 * @author usamaalanbari
 *
 */
public class Passengers {
	
	private int numberOfAdults;
	private int numberOfChilds;
	private int numberOfInfants;
	
	public Passengers(int numberOfAdults, int numberOfChilds, int numberOfInfants) {
		this.numberOfAdults = numberOfAdults;
		this.numberOfChilds = numberOfChilds;
		this.numberOfInfants = numberOfInfants;
	}
	
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public int getNumberOfChilds() {
		return numberOfChilds;
	}
	public void setNumberOfChilds(int numberOfChilds) {
		this.numberOfChilds = numberOfChilds;
	}
	public int getNumberOfInfants() {
		return numberOfInfants;
	}
	public void setNumberOfInfants(int numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}
	
	public int sumTotalPassengers(){
		return this.numberOfAdults + this.numberOfChilds + this.numberOfInfants;
	}

}
