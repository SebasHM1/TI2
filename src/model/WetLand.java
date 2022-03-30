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
	
	public String addFauna (String speciesName, String cientificName, boolean mig, int faunaType, String wetlandsID) {
		
		boolean fin = false; 
		
		String msg = "";
		
		Fauna myFauna = new Fauna(speciesName, cientificName, mig, faunaType, wetlandsID);
		
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
	
	public String addFlora (String speciesName, String cientificName, boolean mig, int floraType, String wetlandID) {
		
		boolean fin = false; 
		
		String msg = "";
		
		Flora myFlora = new Flora(speciesName, cientificName, mig, floraType, wetlandID);
		
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
		
		return "WetLand Name: " + wetName + "Area: " + wetArea + ", Type: " + showUbi + ", wetland ID: " + wetlandID + ", photo url:"
				+ wetPhoto + ", place: " + place + ", private: " + showPriv + ", protected: " + showProt + ", goal: " + goalPercentage;
	}
	
	public String toStringAnimals() {
		
		String msg = "Wetland: " + wetName + " ID: " + wetlandID;
		
		for (int i = 0; i < animals.length; i++) {
			
			if (animals[i] == null) {
				
				msg += "\nfree position of animals: " + i + " at " + wetlandID;
				
			} else {
				
				msg += "\n" + animals[i].toString();
				
			}
			
			
		}
		
		return msg; 
		
	}
	
	public String toStringEvents() {
		
		String msg = "Wetland: " + wetName + " ID: " + wetlandID;
		
		for (int i = 0; i < animals.length; i++) {
			
			if (events[i] == null ) {
				
				msg += "\nfree position of events: " + i + " at " + wetlandID;
				
			} else {
				
				msg += "\n" + events[i].toString();
				
			}
			
			
		}
		
		return msg; 
		
	}
		
	public String toStringPlants() {
		
		String msg = "Wetland: " + wetName + " ID: " + wetlandID;
		
		for (int i = 0; i < animals.length; i++) {
			
			if (plants[i] == null) {
				
				msg += "\nfree position of plants: " + i + " at " + wetlandID;
				
			} else {
				
				msg += "\n" + plants[i].toString();
				
			}
			
			
		}
		
		return msg; 
		
	}
	
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

}