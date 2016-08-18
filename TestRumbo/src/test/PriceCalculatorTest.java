package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import businneslogic.PriceCalculator;
import model.Passengers;
import model.UserInput;
import model.UserOutput;

/**
 * 
 * @author usamaalanbari
 *
 */

public class PriceCalculatorTest {

	/**
	 * Test list with less than 30 days get first item equal 
	 */
	@Test
	public void testCheckFirstPrice() {
		Passengers passengers = new Passengers(2,0,0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "7-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("AMS","CPH",date, passengers);
        List<UserOutput> output = priceCalculator.calculateUserPrice(userInput);
        float delta = 0;
        assertEquals(696,(output.get(0).getFlightPrice()), delta);
       
	}
	
	/**
	 * Test get flight only with Adults with date greater than 30 days
	 */
	@Test
	public void testFlightsOnlyAdultsAndMoreThan30days() {
		Passengers passengers = new Passengers(2,0,0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "7-06-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("AMS","CPH",date, passengers);
        List<UserOutput> actual = priceCalculator.calculateUserPrice(userInput); 
		List<UserOutput> expected = new ArrayList<UserOutput>();
		UserOutput userOutput = new UserOutput();
		userOutput.setFlightCode("TK4927");
		userOutput.setFlightPrice(464);
		expected.add(userOutput);
		userOutput = new UserOutput();
		userOutput.setFlightCode("FR1491");
		userOutput.setFlightPrice((float) 454.4);
		expected.add(userOutput);
		
		int lengthActual = actual.size();
		int lengthExpected = expected.size();
		boolean result = true;
		if (lengthActual != lengthExpected) {
			result = false;
		} else {
			for (int i=0; i<lengthActual; i++) {
				if (!actual.get(i).getFlightCode().equals(expected.get(i).getFlightCode())
						|| actual.get(i).getFlightPrice() != expected.get(i).getFlightPrice()){
					result = false;
				}
			}
		}
		assertEquals(true, result);
       
	}
	
	
	/**
	 * Test get flights with adults and childs with 20 days before flight
	 */
	@Test
	public void testFlightsAdultsChilds20days() {
		Passengers passengers = new Passengers(2,2,0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "30-07-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("CPH","BCN",date, passengers);
        List<UserOutput> actual = priceCalculator.calculateUserPrice(userInput); 
		List<UserOutput> expected = new ArrayList<UserOutput>();
		UserOutput userOutput = new UserOutput();
		userOutput.setFlightCode("U22593");
		userOutput.setFlightPrice((float)579.88);
		expected.add(userOutput);
		userOutput = new UserOutput();
		userOutput.setFlightCode("FR7949");
		userOutput.setFlightPrice((float) 468.16);
		expected.add(userOutput);
		
		int lengthActual = actual.size();
		int lengthExpected = expected.size();
		boolean result = true;
		if (lengthActual != lengthExpected) {
			result = false;
		} else {
			for (int i=0; i<lengthActual; i++) {
				if (!actual.get(i).getFlightCode().equals(expected.get(i).getFlightCode())
						|| actual.get(i).getFlightPrice() != expected.get(i).getFlightPrice()){
					result = false;
				}
			}
		}
		assertEquals(true, result);
       
	}
	
	/**
	 * Test get flights with adults, childs and infants with 1 day before flight
	 */
	@Test
	public void testFlightsAdultsChildsAndInfants1day() {
		Passengers passengers = new Passengers(2,2,2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "17-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("CPH","BCN",date, passengers);
        List<UserOutput> actual = priceCalculator.calculateUserPrice(userInput); 
		List<UserOutput> expected = new ArrayList<UserOutput>();
		UserOutput userOutput = new UserOutput();
		userOutput.setFlightCode("U22593");
		userOutput.setFlightPrice((float)909.62);
		expected.add(userOutput);
		userOutput = new UserOutput();
		userOutput.setFlightCode("FR7949");
		userOutput.setFlightPrice((float) 742.24);
		expected.add(userOutput);
		
		int lengthActual = actual.size();
		int lengthExpected = expected.size();
		boolean result = true;
		if (lengthActual != lengthExpected) {
			result = false;
		} else {
			for (int i=0; i<lengthActual; i++) {
				if (!actual.get(i).getFlightCode().equals(expected.get(i).getFlightCode())
						|| actual.get(i).getFlightPrice() != expected.get(i).getFlightPrice()){
					result = false;
				}
			}
		}
		assertEquals(true, result);
       
	}
	
	/**
	 * Test get infant prices
	 */
	@Test
	public void testGetInfantPrices() {
		Passengers passengers = new Passengers(2,2,2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "17-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("CPH","BCN",date, passengers);
        float infantPrice = (float) priceCalculator.getInfanctPrices(userInput, "U2");
        float delta = 0;
        float expected = (float) (19.90 * 2);
        assertEquals(expected,infantPrice, delta);
       
	}
	
	/**
	 * Test get adult prices
	 */
	@Test
	public void testGetAdultPrices() {
		Passengers passengers = new Passengers(2,2,2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "17-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("CPH","BCN",date, passengers);
        float flightPrice = 218;
        float adultPrice = (float) priceCalculator.getAdultPrices(userInput, flightPrice);
        float delta = 0;
        float expected = (float) (218 * 1.5 * 2);
        assertEquals(expected,adultPrice, delta);
       
	}
	
	/**
	 * Test get Child prices
	 */
	@Test
	public void testGetChildPrices() {
		Passengers passengers = new Passengers(2,2,2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "17-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        UserInput userInput = new UserInput("CPH","BCN",date, passengers);
        float flightPrice = 218;
        float childPrice = (float) priceCalculator.getChildPrices(userInput, flightPrice);
        float delta = 0;
        float expected = (float) (218 * 1.5 * 0.33 * 2);
        assertEquals(expected,childPrice, delta);
       
	}
	
	/**
	 * Test get Child prices
	 */
	@Test
	public void testGetUserPercentage() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "17-08-2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
        }
        PriceCalculator priceCalculator = new PriceCalculator();
        float infantPrice = priceCalculator.getUserPercentage(date);
        float delta = 0;
        float expected = (float) 1.5;
        assertEquals(expected,infantPrice, delta);
       
	}
	

}
