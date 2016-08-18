package model;

public class AirlineList {
	
	private Airline [] airlineList = {
		new Airline("IB","Iberia", 10),
		new Airline("BA","British Airways", 15),
		new Airline("LH","Luflbansa", 7),
		new Airline("FR","Ryanair", 20),
		new Airline("VY","Vueling", 10),
		new Airline("TK","Turkish Airlines", 5),
		new Airline("U2","Easyjet", 19.90)		
	};

	public Airline [] getAirlineList() {
		return airlineList;
	}

	public void setAirlineList(Airline [] airlineList) {
		this.airlineList = airlineList;
	}
	
	public Airline getAirlineByCode(String flightCode){
		int length = airlineList.length;
		Airline element = null;
		for (int i=0; i< length; i++) {
			element = airlineList[i];
			if (element.getIataCode().equals(flightCode)) {
				return element;
			}
		}
		
		return element;
	}

}
