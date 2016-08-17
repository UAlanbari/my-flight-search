package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import model.Passengers;

public class UserInputTest {

	@Test
	public void testCreateUserInputDateDeparture() {
		Passengers passengers = new Passengers(2,1,1);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "7-08-2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
//		UserInput userInput = new UserInput("Origin", "Dest",1471339390892L , passengers);
//		assertEquals(1471339390892L,userInput.getDateOfDeparture());

	}

}
