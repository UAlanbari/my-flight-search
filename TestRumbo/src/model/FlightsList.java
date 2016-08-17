package model;

import java.util.ArrayList;
import java.util.List;

public class FlightsList {
	
	private Flight [] flightList = {
			new Flight("AMS","CPH","TK4927",290),
			new Flight("AMS","FRA","TK2372",197),
			new Flight("BCN","FRA","FR7521",150),
			new Flight("BCN","IST","VY9890",178),
			new Flight("BCN","AMS","U24985",191),
			new Flight("BCN","MAD","IB2171",259),
			new Flight("CDG","MAD","IB8482",295),
			new Flight("CPH","FRA","IB2818",186),
			new Flight("CPH","LHR","U23631",152),
			new Flight("AMS","CPH","TK4667",137),
			new Flight("CPH","FCO","U24631",268),
			new Flight("CPH","BCN","U22593",218),
			new Flight("CPH","LHR","BA7710",138),
			new Flight("CPH","FRA","LH1678",298),
			new Flight("FCO","CDG","VY4335",158),
			new Flight("FCO","MAD","BA1164",118),
			new Flight("FRA","AMS","U24107",237),
			new Flight("FRA","IST","LH4145",169),
			new Flight("FRA","CPH","BA4369",109),
			new Flight("IST","FRA","IB8911",180),
			new Flight("LHR","IST","TK8891",250),
			new Flight("LHR","FRA","LH2118",165),
			new Flight("LHR","CPH","LH6620",217),
			new Flight("MAD","CDG","IB9961",128),
			new Flight("MAD","CDG","IB6112",112),
			new Flight("MAD","LHR","TK4199",186),
			new Flight("MAD","CDG","IB7403",253)
			};
	


	                              
	       

	public Flight [] getFlightList() {
		return flightList;
	}

	public void setFlightList(Flight [] flightList) {
		this.flightList = flightList;
	}

	public List<Flight> getFlightListByOriginAndDestination(String origin, String destination) {
		List<Flight> filterFlights = new ArrayList<Flight>();
		int length = this.flightList.length;
		for (int i=0; i<length ; i++){
			Flight element = this.flightList[i];
			if (element.getOrigin().equals(origin) && element.getDestination().equals(destination)){
				filterFlights.add(element);
			}
		}
		return filterFlights;
	}

}
