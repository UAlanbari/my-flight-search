package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import businneslogic.PriceCalculator;
import model.Passengers;
import model.UserInput;
import model.UserOutput;

public class PriceCalculatorTest {

	@Test
	public void test() {
		Passengers passengers = new Passengers(2,1,0);
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
        List<UserOutput> output = priceCalculator.calculateUserPrice(userInput);
        System.out.println((float)output.get(0).getFlightPrice());
        float delta = 0;
        assertEquals(464,(output.get(0).getFlightPrice()), delta);
       
	}

}
