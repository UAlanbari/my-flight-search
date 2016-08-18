package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author usamaalanbari
 *
 */
public class FlightsList {
	
	private Flight [] flightList = {
			new Flight("CPH","FRA","IB2818",186),
			new Flight("CPH","LHR","U23631",152),
			new Flight("CDG","MAD","IB8482",295),
			new Flight("BCN","FRA","FR7521",150),
			new Flight("CPH","FCO","TK4667",137),
			new Flight("CPH","FCO","U24631",268),
			new Flight("FCO","CDG","VY4335",158),
			new Flight("LHR","IST","TK8891",250),
			new Flight("FRA","AMS","U24107",237),
			new Flight("CPH","BCN","U22593",218),
			new Flight("BCN","IST","VY9890",178),
			new Flight("AMS","CPH","TK4927",290),
			new Flight("FCO","MAD","BA1164",118),
			new Flight("CPH","LHR","BA7710",138),
			new Flight("BCN","AMS","U24985",191),
			new Flight("MAD","CDG","IB9961",128),
			new Flight("LHR","FRA","LH2118",165),
			new Flight("IST","FRA","IB8911",180),
			new Flight("AMS","FRA","TK2372",197),
			new Flight("FRA","IST","LH4145",169),
			new Flight("MAD","CDG","IB6112",112),
			new Flight("CPH","FRA","LH1678",298),
			new Flight("LHR","CPH","LH6620",217),
			new Flight("MAD","LHR","TK4199",186),
			new Flight("MAD","CDG","IB7403",253),
			new Flight("FRA","CPH","BA4369",109),
			new Flight("BCN","MAD","IB2171",259),
			new Flight("IST","LHR","LH6412",197),
			new Flight("IST","MAD","LH1115",160),
			new Flight("LHR","LHR","VY8162",285),
			new Flight("FRA","LHR","BA8162",205),
			new Flight("AMS","FCO","BA7610",168),
			new Flight("LHR","IST","LH1085",148),
			new Flight("FCO","FRA","U21423",274),
			new Flight("CPH","MAD","U23282",113),
			new Flight("CDG","CPB","LB5778",263),
			new Flight("CPB","CDG","BA2777",284),
			new Flight("BCN","LHR","TK4375",208),
			new Flight("MAD","FCO","LH8408",149),
			new Flight("AMS","IST","IB4563",109),
			new Flight("LHR","FCO","LH5174",251),
			new Flight("MAD","BCN","BA9569",232),
			new Flight("AMS","FRA","TK2659",248),
			new Flight("LHR","CDG","IB2771",289),
			new Flight("IST","MAD","IB8688",150),
			new Flight("CPH","AMS","TK8355",137),
			new Flight("FCO","CDG","VY2974",111),
			new Flight("AMS","FRA","LH5909",113),
			new Flight("CPH","BCN","FR7949",176),
			new Flight("BCN","CPB","U27858",237),
			new Flight("FRA","AMS","LH2320",288),
			new Flight("LHR","BCN","VY4633",149),
			new Flight("AMS","IST","IB7289",163),
			new Flight("FRA","LHR","IB9443",254),
			new Flight("IST","FCO","LH4948",176),
			new Flight("IST","BCN","TK5558",211),
			new Flight("BCN","BCN","BA9409",215),
			new Flight("IST","AMS","FR9261",267),
			new Flight("CDG","IST","IB7181",227),
			new Flight("LHR","BCN","TK1446",217),
			new Flight("FCO","FRA","TK2793",175),
			new Flight("AMS","CPH","FR1491",284),
			new Flight("IST","BCN","IB9219",279),
			new Flight("MAD","AMS","TK7871",159),
			new Flight("FCO","AMS","VY4840",260),
			new Flight("MAD","FRA","BA8982",171),
			new Flight("IST","LHR","U23526",254),
			new Flight("FRA","MAD","BA6773",157),
			new Flight("CDG","CPB","IB5257",299),
			new Flight("CPH","CDG","LH8545",230),
			new Flight("LHR","AMS","IB4737",110),
			new Flight("BCN","MAD","LH5496",293),
			new Flight("CDG","LHR","U29718",103),
			new Flight("LHR","AMS","BA9561",253),
			new Flight("FRA","LHR","TK3167",118),
			new Flight("IST","FRA","FR4727",108),
			new Flight("CPH","IST","LH6320",115),
			new Flight("LHR","AMS","BA6657",122),
			new Flight("LHR","FRA","TK5342",295),
			new Flight("IST","LHR","IB4938",226),
			new Flight("CDG","BCN","VY9791",289),
			new Flight("MAD","LHR","IB4124",272),
			new Flight("FRA","MAD","BA7842",121),
			new Flight("AMS","FCO","VY5092",178),
			new Flight("CDG","LHR","BA9813",171),
			new Flight("FRA","IST","BA2421",226),
			new Flight("IST","CPB","U28059",262),
			new Flight("MAD","AMS","LH7260",191),
			new Flight("CDG","CPB","TK2044",186)
			};                           
	       

	public Flight [] getFlightList() {
		return flightList;
	}

	public void setFlightList(Flight [] flightList) {
		this.flightList = flightList;
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
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
