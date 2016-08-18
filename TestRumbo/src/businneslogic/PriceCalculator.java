package businneslogic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.AirlineList;
import model.Flight;
import model.FlightsList;
import model.UserInput;
import model.UserOutput;

/**
 * 
 * @author usamaalanbari
 *
 */
public class PriceCalculator {
	
	/**
	 * 
	 * @param userInput
	 * @return
	 */
	public List<UserOutput> calculateUserPrice(UserInput userInput) {
		List<UserOutput> listFlightsWithPrice = new ArrayList<UserOutput>();
		FlightsList flighLists = new FlightsList();
		List<Flight> flightByOriginAndDestination = flighLists.getFlightListByOriginAndDestination(userInput.getOrigin(),userInput.getDestination());
		int length = flightByOriginAndDestination.size();
		for (int i=0; i<length ;i++){
			Flight element = flightByOriginAndDestination.get(i);
			UserOutput userOutput = new UserOutput();
			float adultsPrice = this.getAdultPrices(userInput, element.getPrice());
			float childsPrice = this.getChildPrices(userInput, element.getPrice());
			float infantsPrice = (float) this.getInfanctPrices(userInput, element.getAirline().substring(0, 1));
			float totalPrice = adultsPrice + childsPrice + infantsPrice;
			userOutput.setFlightCode(element.getAirline());
			userOutput.setFlightPrice(totalPrice);
			listFlightsWithPrice.add(userOutput);
		}
		
		return listFlightsWithPrice;
	}

	/**
	 * 
	 * @param userInput
	 * @param flightPrice
	 * @return
	 */
	private double getInfanctPrices(UserInput userInput, String flightCode) {
		AirlineList airlineList = new AirlineList();
		return userInput.getPassengers().getNumberOfInfants() * airlineList.getAirlineByCode(flightCode).getInfantPrice();
	}


	/**
	 * 
	 * @param userInput
	 * @param flightPrice
	 * @return
	 */
	private float getChildPrices(UserInput userInput, float flightPrice) {
		double percentage = this.getUserPercentage(userInput.getDateOfDeparture());
		return (float) (userInput.getPassengers().getNumberOfChilds() * (0.33 * (percentage * flightPrice))) ;
	}

	/**
	 * 
	 * @param userInput
	 * @param flightPrice
	 * @return
	 */
	private float getAdultPrices(UserInput userInput, float flightPrice) {
		double percentage = this.getUserPercentage(userInput.getDateOfDeparture());
		return (float) (userInput.getPassengers().getNumberOfAdults() *
						(percentage * flightPrice)) ;

	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
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
