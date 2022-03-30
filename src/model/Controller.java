package model;

public class Controller {
	
	private int urbanCounter;
	private int ruralCounter;
	private int publicCounter;
	private int privateCounter;
	private WetLand[] wetlands;
	
	public Controller() {
		
		wetlands = new WetLand[80];
		urbanCounter = 0;
		ruralCounter = 0;
		publicCounter = 0;
		privateCounter = 0;
		
	}
	
	public String createWetland(int wetUbiType, int wetArea, String wetName, String wetlandID,  String wetPhoto, String place, double goalPercentage, boolean priv, boolean protectedArea) {
		
		String msg = "no"; 
		boolean fin = false;
		
		WetLand myWetland = new WetLand(wetUbiType, wetArea, wetName, wetlandID, wetPhoto, place, goalPercentage, priv, protectedArea);
		
		System.out.println(wetUbiType + " 2. " + urbanCounter +  " 3. " + ruralCounter);
			
			for (int i = 0; i < wetlands.length && !fin; i++) {
				
				if (wetlands[i] == null) {
					
					System.out.println(wetUbiType + " 2. " + urbanCounter +  " 3. " + ruralCounter);
					
					if (wetUbiType == 1 && urbanCounter < 51) {
						
						if (priv == true && privateCounter < 60) {
							
							wetlands[i] = myWetland;
							
							privateCounter ++;
							urbanCounter ++;
							
							msg = "The Wetland was registered successfully";
							fin = true;
							
						} else if (priv == false && publicCounter < 16) {
							
							wetlands[i] = myWetland;
							
							publicCounter ++;
							urbanCounter ++;
							
							msg = "The Wetland was registered successfully";
							fin = true;
							
						} else if(privateCounter > 65 || publicCounter > 15) {
							
							msg = "The cetagory private or public is already full";
							fin = true;
				
						}
						
					} else if(wetUbiType == 2 && ruralCounter < 31) {
						
						if (priv == true && privateCounter < 60) {
							
							wetlands[i] = myWetland;
							
							privateCounter ++;
							ruralCounter ++;
							
							msg = "The Wetland was registered successfully";
							fin = true;
							
						} else if (priv == false && publicCounter < 16) {
							
							wetlands[i] = myWetland;
							
							publicCounter ++;
							ruralCounter ++;
							
							msg = "The Wetland was registered successfully";
							fin = true;
							
						} else if(privateCounter > 65 || publicCounter > 15) {
							
							msg = "The cetagory private or public is already full";
							fin = true;
							
						}

						
					} else if (urbanCounter > 50) {
						
						msg = "The category Rural is already full";
						fin = true;
						
					} else if (ruralCounter > 50) {
						
						msg = "The category Urban is already full";
						fin = true;
					}
					
				}
				
			}
		
		return msg;
		
	}
	
	public String createFauna (String specieName, String cientificName, boolean mig, int faunaType, String wetlandID) {
		
		boolean fin = false;
		String msg = "";
		
		for (int i = 0; i < wetlands.length && !fin; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].addFauna(specieName, cientificName, mig, faunaType, wetlandID);
					
				}
				
			}
			
		}
		
		return msg;
		
	}
	
	public String createFlora (String specieName, String cientificName, boolean mig, int floraType, String wetlandID) {
		
		boolean fin = false;
		String msg = "";
		
		for (int i = 0; i < wetlands.length && !fin; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].addFlora(specieName, cientificName, mig, floraType, wetlandID);
					
				}
				
			}
			
		}
		
		return msg;
		
	}
	
	public String createEvent (String hostName, double value, String description, int year, int month, int day, int eventType, String wetlandID) {
		
		String msg = ".";
		boolean fin = false;
		
		for (int i = 0; i < wetlands.length && !fin; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].addEvent(hostName, value, description, year, month, day, eventType, wetlandID);
					fin = true;
					
				} else {
					
					msg = "A wetland with that id doesnt exist";
					fin = true;
					
				}
				
			}
			
		}
		
		return msg;
	}
	
	public String showWetlands () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toString();				
			}
			
		}
		
		return msg;
		
	}
	
	public String showPlants () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringPlants();				
			}
			
		}
		
		return msg;
		
	}
	
	public String showAnimals () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringAnimals();				
			}
			
		}
		
		return msg;
		
	}
	
	public String showEvents () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringEvents();				
			}
			
		}
		
		return msg;
		
	}
	
	public String maintenance (String wetlandID, int year) {
		
		String msg = "";
		boolean fin = false;
		
		for (int i = 0; i < wetlands.length && fin == false; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].numberMaintenance(year);
					
				}
				
			}
			
		}
		
		
		return msg;
		
	}

}