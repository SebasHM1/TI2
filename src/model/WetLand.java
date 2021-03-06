package model;

public class WetLand {
	
	private int wetUbiType;
	private int wetArea;
	private String wetName;
	private String wetlandID; 
	private String wetPhoto; 
	private String place; 
	private double goalPercentage;
	private boolean priv; 
	private boolean protectedArea;
	private Fauna[] animals;
	private Flora[] plants;
	private Event[] events;
	
	public WetLand (int wetUbiType, int wetArea, String wetName, String wetlandID, String wetPhoto,  String place, double goalPercentage, boolean priv, boolean protectedArea) {
		
		this.goalPercentage = goalPercentage;
		this.place = place;
		this.priv = priv;
		this.protectedArea = protectedArea;
		this.wetlandID = wetlandID;
		this.wetUbiType = wetUbiType;
		this.wetArea = wetArea;
		this.wetName = wetName;
		this.wetPhoto = wetPhoto;
		animals = new Fauna[20];
		plants = new Flora[20];
		events = new Event[20];
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object Fauna at the array animals
	 *pre: Animals array should be initialiced
	 *pos: a fauna object is created at array animals 
	 * </pre>	 
	 *@param specieName String contains the name of each specie 
	 *@param cientificName String contains the cientific name of each specie 
	 *@param mig boolean contains the information if the specie is migratory or not
	 *@param faunaType contains the type of fauna
	 *@param wetlandID contains the id of wetLand where the specie is located
	 *@return msg, a message of succes or fail
	*/
	
	public String addFauna (String specieName, String cientificName, boolean mig, int faunaType, String wetlandID) {
		
		boolean fin = false; 
		
		String msg = "";
		
		Fauna myFauna = new Fauna(specieName, cientificName, mig, faunaType, wetlandID);
		
		for (int i = 0; i < animals.length && !fin; i++) {
			
			if (animals[i] == null) {
				
				animals[i] = myFauna;
				fin = true;
				
				msg = "The animal was correctly added";
				
			}
			
		}
		
		if (fin == false) {
			
			msg = "The animal cannot be added";
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object flora
	 *pre: array plants should be initialiced
	 *pos: a flora object is created at plants
	 * </pre>	 
	 *@param specieName String contains the name of each specie 
	 *@param cientificName String contains the cientific name of each specie 
	 *@param mig boolean contains the information if the specie is migratory or not
	 *@param floraType int contains the type of flora
	 *@param wetlandID String contains the id of wetLand where the specie is located
	 *@return msg String a message of succes or fail
	 */
	
	
	public String addFlora (String specieName, String cientificName, boolean mig, int floraType, String wetlandID) {
		
		boolean fin = false; 
		
		String msg = "";
		
		Flora myFlora = new Flora(specieName, cientificName, mig, floraType, wetlandID);
		
		for (int i = 0; i < plants.length && !fin; i++) {
			
			if (plants[i] == null) {
				
				plants[i] = myFlora;
				fin = true;
				
				msg = "The plant was correctly added";
				
			}
			
		}
		
		if (fin == false) {
			
			msg = "The plant cannot be added";
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object Event
	 *pre: object wetlands have to be inicialiced and cant be null
	 *pos: a event object is created at events
	 * </pre>	 
	 *@param hostName String contains the name of event's host 
	 *@param value double contains the monetary value of the event 
	 *@param description String contains the event's description
	 *@param year int contains the event's year
	 *@param month int contains the event's month
	 *@param day int contains the event's day
	 *@param eventType int containg the type of event
	 *@param wetlandID String contains the id of wetLand where the event will happen
	 *@return msg String a message of succes or fail	
	*/
	
	public 	String addEvent (String hostName, double value, String description, int year, int month, int day, int eventType, String wetlandID) {
		
		boolean fin = false; 
		String msg = ".";
		
		Event myEvent = new Event(hostName, value, description, year, month, day, eventType, wetlandID);
		
		for (int i = 0; i < events.length && !fin; i++) {
			
			if (events [i] == null) {
				
				events[i] = myEvent;
				fin = true;
				
				msg = "The Event was added successfull";
				
			}
			
		}
		
		return msg;
		
	}
	
	public int getWetUbiType() {
		return wetUbiType;
	}

	public void setWetUbiType(int wetUbiType) {
		this.wetUbiType = wetUbiType;
	}

	public int getWetArea() {
		return wetArea;
	}

	public void setWetArea(int wetArea) {
		this.wetArea = wetArea;
	}

	public String getWetlandID() {
		return wetlandID;
	}

	public void setWetlandID(String wetlandID) {
		this.wetlandID = wetlandID;
	}

	public String getWetPhoto() {
		return wetPhoto;
	}

	public void setWetPhoto(String wetPhoto) {
		this.wetPhoto = wetPhoto;
	}

	public String getWetName() {
		return wetName;
	}

	public void setWetName(String wetName) {
		this.wetName = wetName;
	}

	public String getPlace() {
		return place;
	}

	
	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isPriv() {
		return priv;
	}

	public void setPriv(boolean priv) {
		this.priv = priv;
	}

	public boolean isProtectedArea() {
		return protectedArea;
	}

	public void setProtectedArea(boolean protectedArea) {
		this.protectedArea = protectedArea;
	}

	public double getGoalPercentage() {
		return goalPercentage;
	}

	public void setGoalPercentage(double goalPercentage) {
		this.goalPercentage = goalPercentage;
	}
	
	@Override
	public String toString() {
		
		String showUbi = "Error";
		String showProt = "Error";
		String showPriv = "Error";
		
		if (wetUbiType == 1) {
			
			showUbi = "Urban";
			
		} else if (wetUbiType == 2) {
		
			showUbi = "Rural";
			
		}
		
		if (protectedArea == true) {
			
			showProt = "Protected";
			
		} else if (protectedArea == false){
			
			showProt = "Not protected";
			
		}
		
		if (priv == true) {
			
			showPriv = "Yes";
			
		} else if (priv == false) {
			
			showPriv = "No";
			
		}
		
		return "\nWetLand Name: " + wetName + " Area: " + wetArea + ", Type: " + showUbi + ", wetland ID: " + wetlandID + ", photo url:"
				+ wetPhoto + ", place: " + place + ", private: " + showPriv + ", protected: " + showProt + ", goal: " + goalPercentage;
	}
	
	public String toStringAnimals() {
		
		String msg = "For Animals at wetland: " + wetName + " ID: " + wetlandID;
		
		for (int i = 0; i < animals.length; i++) {
			
			if (animals[i] != null) {
				
				msg += "\n" + animals[i].toString();
				
			} 
			
			
		}
		
		return msg; 
		
	}
	
	public String toStringEvents() {
		
		String msg = "For Events at wetland: " + wetName + " ID: " + wetlandID;
		
		for (int i = 0; i < animals.length; i++) {
			
			if (events[i] != null ) {
				
				msg += "\n" + events[i].toString();
				
			} 
			
			
		}
		
		return msg; 
		
	}
	
	public String toStringPlants() {
		
		String msg = "For Plants at wetland: " + wetName + " ID: " + wetlandID;
		for (int i = 0; i < animals.length; i++) {
			
			if (plants[i] != null) {
				
				msg += "\n" + plants[i].toString();
				
			} 
			
			
		}
		
		return msg; 
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object Event
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>	 
	 *@param year int contains the year where the program are going to search 
	 *@return msg String a message of succes and how many maintence did it have at the year
	*/
	
	
	public String numberMaintenance (int year) {
		
		String msg = "";
		int mainCounter = 0;
		
		for (int i = 0; i < events.length; i++) {
			
			if (events[i] != null ) {
				
				if ((events[i].getEventType() == EventType.MAINTENANCE) && (events[i].getEventDate().getYear() == year)) {
					
					mainCounter = mainCounter+1;
					
				}
				
			}
			
		}
		
		msg = "Total maintenance for " + wetlandID + " in " + year + " is " + mainCounter;
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method search at the wetlands the given specie 
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>	 
	 *@param checkSpecie String contains the name of searched specie 
	 *@return msg String a message of succes and how many wetlands have the specie 
	*/
	
	public String searchSpecie (String checkSpecie) {
		
		String msg = "The wetlands dont have that specie";
		boolean fin = false;
		
		for (int i = 0; i < animals.length && !fin; i ++ ) {
			
			if (animals[i] != null ) {
				
				if (checkSpecie.equals(animals[i].getSpecieName())) {
					
					msg = "\nThe wetland: " + wetName + " ID: "+ wetlandID + " contains the specie: " + checkSpecie;
					fin = true;
					
				} else if (checkSpecie.equals(plants[i].getSpecieName())) {
					
					msg = "\nThe wetland: " + wetName + " ID: "+ wetlandID + " contains the specie: " + checkSpecie;
					fin = true;
					
				} 
				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method search at the wetland how many fauna object did it have
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>	 
	 *@return counter int have the amount of fauna objects 
	*/
	
	public int moreFaunaWetland () {
		
		int counter = 0;
		
		for (int i = 0; i < animals.length; i ++) {
			
			if (animals[i] != null) {
				
				counter ++;
				
			}
			
		}
		
		return counter; 
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method search at the wetland how many flora objects did it have
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>	 
	 *@return counter int have the amount of flora objects 
	*/
	
	public int lessFloraWetland () {
		
		int counter = 0;
		
		for (int i = 0; i < plants.length; i ++) {
			
			if (plants[i] != null) {
				
				counter ++;
				
				
				
			} 
			
		}
		
		return counter;
		
	}

}
