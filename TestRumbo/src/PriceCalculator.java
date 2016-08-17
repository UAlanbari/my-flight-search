import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.Flight;
import model.FlightsList;
import model.UserInput;
import model.UserOutput;

public class PriceCalculator {
	
	public List<UserOutput> calculateUserPrice(UserInput userInput) {
		List<UserOutput> listFlightsWithPrice = new ArrayList<UserOutput>();
		FlightsList flighLists = new FlightsList();
		// Two kind of calculation prices
		//1. Time reservation
		//2. Type of passanger
		// Entonces recorremos los tipos de pasajeros y vamos calculando un precio por cabeza y sumando al total
		//obtengo un listado de vuelos ahora debo sacar para cada uno precio
		List<Flight> flightByOriginAndDestination = flighLists.getFlightListByOriginAndDestination(userInput.getOrigin(),userInput.getDestination());
		int length = flightByOriginAndDestination.size();
		for (int i=0; i<length ;i++){
			Flight element = flightByOriginAndDestination.get(i);
			UserOutput userOutput = new UserOutput();
			float adultsPrice = this.getAdultPrices(userInput, element.getPrice());
			float childsPrice = this.getChildPrices(userInput);
			float infantsPrice = this.getInfanctPrices(userInput, element.getPrice());
			float totalPrice = adultsPrice + childsPrice + infantsPrice;
			userOutput.setFlightCode(element.getAirline());
			userOutput.setFlightPrice(totalPrice);
			listFlightsWithPrice.add(userOutput);
		}
		
		return listFlightsWithPrice;
	}

	private float getInfanctPrices(UserInput userInput, float flightPrice) {
		float adultPrice = 0;
//		double percentage = this.getUserPercentage();
		return adultPrice * flightPrice;
	}


	private float getChildPrices(UserInput userInput) {
//		double percentage = this.getUserPercentage(userInput.getDateOfDeparture());
//		return (float) (percentage * flightPrice) ;
		return 0;
	}

	private float getAdultPrices(UserInput userInput, float flightPrice) {
		double percentage = this.getUserPercentage(userInput.getDateOfDeparture());
		return (float) (userInput.getPassengers().getNumberOfAdults() *
						(percentage * flightPrice)) ;

	}
	
	private Double getUserPercentage(Date date) {
		Double percentage = 0.0;
		Date today = new Date();
		long daysBetween = TimeUnit.MILLISECONDS.toDays(today.getTime() - date.getTime());
		if (daysBetween > 30) {
			percentage = 0.8;
		} else if (daysBetween <= 30 && daysBetween >=16){
			percentage = 1.0;
		} else if (daysBetween <= 15 && daysBetween >= 3) {
			percentage = 1.2;
		} else {
			percentage = 1.5;
		}
		
		return  percentage;
	}

}
