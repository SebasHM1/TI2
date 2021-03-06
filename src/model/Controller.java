package model;

public class Controller {
	
	private int urbanCounter;
	private int ruralCounter;
	private int publicCounter;
	private int privateCounter;
	private WetLand[] wetlands;
	
	/**
	 <pre>
	 *<strong>Descripcion:</strong> This method inicialices the global variables
	 *pre: urbanCounter, ruralCounter, publicCounter, privateCounter and array wetlands should be declared 
	 *pos: surbanCounter, ruralCounter, publicCounter, privateCounter and array wetlands are inicialiced 
	 </pre>
	 */

	public Controller() {
		
		wetlands = new WetLand[80];
		urbanCounter = 0;
		ruralCounter = 0;
		publicCounter = 0;
		privateCounter = 0;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method creates the object wetland if the counter allow it
	 *pre: urbanCounter, ruralCounter, publicCounter, privateCounter and array wetlands should be inicialiced
	 *pos: surbanCounter, ruralCounter, publicCounter, privateCounter and array wetlands are modificated acording to circunstanses 
	 * </pre>	 
	 *@param wetUbiType int contains the Type of ubication 
	 *@param wetArea int contains the area
	 *@param wetName String contains the name
	 *@param wetlandID String contains the id of each wetland 
	 *@param wetPhoto String contains the URL of wetlands photo 
	 *@param place String contains the place name 
	 *@param goalPercentage double contains the percetnage of the enviromental managment plan
	 *@param priv boolean contains gthe information about if the wetland ios private or not
	 *@param protectedArea boolean contains gthe information about if the wetland is protected or not
	 *@return msg, a message of succes or fail
	 */
	
	public String createWetland(int wetUbiType, int wetArea, String wetName, String wetlandID,  String wetPhoto, String place, double goalPercentage, boolean priv, boolean protectedArea) {
		
		String msg = "no"; 
		boolean fin = false;
		
		WetLand myWetland = new WetLand(wetUbiType, wetArea, wetName, wetlandID, wetPhoto, place, goalPercentage, priv, protectedArea);
			
			for (int i = 0; i < wetlands.length && !fin; i++) {
				
				if (wetlands[i] == null) {
					
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
						
					} else if (ruralCounter > 30) {
						
						msg = "The category Urban is already full";
						fin = true;
					}
					
				}
				
			}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object flora
	 *pre: object wetlands have to be inicialiced and cant be null
	 *pos: a fauna object is created at the array wetlands
	 * </pre>	 
	 *@param specieName String contains the name of each specie 
	 *@param cientificName String contains the cientific name of each specie 
	 *@param mig boolean contains the information if the specie is migratory or not
	 *@param faunaType contains the type of fauna
	 *@param wetlandID contains the id of wetLand where the specie is located
	 *@return msg, a message of succes or fail
	 */
	
	public String createFauna (String specieName, String cientificName, boolean mig, int faunaType, String wetlandID) {
		
		boolean fin = false;
		String msg = "";
		
		for (int i = 0; i < wetlands.length && !fin; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].addFauna(specieName, cientificName, mig, faunaType, wetlandID);
					fin = true;
					
				} else {
					
					msg = "There is not a Wetland with that id";
					
				}
				
				
				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object flora
	 *pre: object wetlands have to be inicialiced and cant be null
	 *pos: a flora object is created at the array wetlands
	 * </pre>	 
	 *@param specieName String contains the name of each specie 
	 *@param cientificName String contains the cientific name of each specie 
	 *@param mig boolean contains the information if the specie is migratory or not
	 *@param floraType int contains the type of flora
	 *@param wetlandID String contains the id of wetLand where the specie is located
	 *@return msg String a message of succes or fail
	 */
	
	public String createFlora (String specieName, String cientificName, boolean mig, int floraType, String wetlandID) {
		
		boolean fin = false;
		String msg = "";
		
		for (int i = 0; i < wetlands.length && !fin; i++) {
			
			if (wetlands[i] != null) {
				
				if (wetlandID.equals(wetlands[i].getWetlandID())) {
					
					msg = wetlands[i].addFlora(specieName, cientificName, mig, floraType, wetlandID);
					fin = true;
					
				} else {
					
					msg = "There is not a Wetland with that id";
					
				}
				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method creates the object Event
	 *pre: object wetlands have to be inicialiced and cant be null
	 *pos: a event object is created at the array wetlands
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
					
				}
				
			}
			
		}
		
		return msg;
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the actual wetlands
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of created wetlands 
	 */
	
	public String showWetlands () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toString();				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the actual plants objects
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of created plants
	 */
	
	public String showPlants () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringPlants();				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the actual animals objects
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of created animals
	 */
	
	public String showAnimals () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringAnimals();				
			}
			
		}
		
		return msg;
		
	}
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the actual events objects
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of created events
	 */
	
	public String showEvents () {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				msg += "\n" + wetlands[i].toStringEvents();				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show all the events maintenance in a wetland by a year
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of how many maintenance events do the wetland have for a given year
	 *@param wetlandID contains the id of the wetland who is evaluated
	 *@param year contains the year evaluated 
	 */
	
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
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show witch wetlands have the given specie
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of wetlands who have the specie
	 *@param checkSpecie contains the name of the searched specie
	 */
	
	public String wetBySpecie (String checkSpecie) {
		
		String msg = "";
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null ) {
				
				msg += wetlands[i].searchSpecie(checkSpecie);
				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the wetland who have more fauna objects
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of wetlands who have more fauna objects
	 */
	
	public String moreFaunaControll () {
		
		String msg = "";
		int actualCounter = 1;
		int newCounter = 0;
		
		for (int i = 0; i < wetlands.length; i++) {
			
			if (wetlands[i] != null) {
				
				newCounter = wetlands[i].moreFaunaWetland();
				
				if (newCounter >= actualCounter) {
					
					msg += wetlands[i].toString();
					
					if (newCounter > actualCounter) {
					
						newCounter = actualCounter;
						msg = wetlands[i].toString();
						
					}
					
				} 
				
				
				
			}
			
			
			
		}
		
		if (msg == "") {
			
			msg = "there is no fauna objects";
			
		}
		
		return msg;
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method create a String variable to show the wetland who have the minor quantity of flora objects 
	 *pre: object wetlands have to be inicialiced and cant be null
	 * </pre>
	 *@return msg String who contains a list of wetlands who have the minor quantity of flora objects 
	 */
	
	public String lessFloraControll () {
		
		String msg = ""; 
		int actualCounter = 0;
		int newCounter = 0;
		
		for (int i = 0; i < wetlands.length; i ++ ) {
			
			if (wetlands[i] != null) {
				
				newCounter = wetlands[i].lessFloraWetland();
				
				if (newCounter <= actualCounter) {
					
					msg += wetlands[i].toString();
					
					if (newCounter < actualCounter) {
					
						newCounter = actualCounter;
						msg = wetlands[i].toString();
						
					}
					
				}
				
				
				
			}
			
		}
		
		if (msg == "") {
			
			msg = "there is no flora objects";
			
		}
		
		return msg; 
		
	}

}
