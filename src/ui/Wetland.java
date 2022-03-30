package ui;

import model.Controller;
import java.util.Scanner;

public class Wetland {

	public static Scanner sc; 
	public static Controller controller; 
	
	public static void main (String args[]) {
		
		init();
		menu();
		
	}
	
	public static void init () {
		
		sc = new Scanner(System.in);
		controller = new Controller(); 
		
	}
	
	public static void menu () {
		
		System.out.println("Welcome to the main menu");
		
		boolean fin = false; 
		int opt = 0;
		
		while (!fin) {
			
			System.out.println("Type an option");
			System.out.println("1) Register a wetland");
			System.out.println("2) Register a fauna specie");
			System.out.println("3) Register a flora specie");
			System.out.println("4) Register an Event");
			System.out.println("5) Check the number of maintenance in a year for each wetland");
			System.out.println("6) Check the wetland by specie");
			System.out.println("7) Show all the Wetlands, Species and Events");
			System.out.println("8) Exit");
			
			opt = sc.nextInt();
			
			switch(opt) {
				
				case 1: 
				registerWetland();
				
				break;
				
				case 2: 
				registerFauna();

				break;
				
				case 3: 
				registerFlora();
				
				break;
				
				case 4: 
				registerEvent();

				break;
					
				case 5: 
				maintenance();

				break;
					
				case 6: 
				registerFauna();

				break;	
					
				case 7: 
				showAll();
				
				break;
		
				case 8:
					
					System.out.println("Thanks for using");
					fin = true; 
					break;
					
				default: 
				
				System.out.println("Your must type a valid option");
				break;
				
			}
			
		}
		
	}
	
	public static void registerWetland() {
		
		boolean finComp = false; 
		boolean finCompUbi = false; 
		boolean finCompPriv = false;
		boolean protectedArea = false; 
		boolean priv = false; 
		String place = "";
		int wetUbiType = 0;
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("These are the Wetlands currently registered:" + controller.showWetlands());
			
		}
		
		System.out.println("Type the name of the Wetland");
		
		String wetName = sc.next();
		
		System.out.println("Type the area of the wetland");
		
		int wetArea = sc.nextInt();
		
		System.out.println("Type the URL of the photo");
		
		String wetPhoto = sc.next();
		
		System.out.println("Type the percentage of environmental management plan");
		
		Double goalPercentage = sc.nextDouble();
		
		while (!finCompPriv) {
			
			System.out.println("Type the 1 for private or 2 for public");
			
			int wetType = sc.nextInt();
			
			if (wetType == 1) {
			
				priv = true; 
				
				finCompPriv = true; 
				
			} else if (wetType == 2) {
				
				finCompPriv = true; 
				
			} else {
				
				System.out.println("You must type a valid option");
				
			}
			
			
		}
		
		while (!finComp) {
			
			System.out.println("If the wetland is protected, type 1, if it is not, type 2");
		
			int protectedAreaComp = sc.nextInt();
			
			if (protectedAreaComp == 1) {
			
				protectedArea = true; 
				
				finComp = true; 
				
			} else if (protectedAreaComp == 2) {
				
				finComp = true; 
				
			} else {
				
				System.out.println("You must type a valid option");
				
			}
			
			
		}
		
		while (!finCompUbi) {
			
			System.out.println("Type 1 for urban or 2 for rural");
			
			wetUbiType = sc.nextInt();
			
			if (wetUbiType == 1) {
			
				System.out.println("Type the name of the Town"); 
				place = sc.next();
				
				finCompUbi = true; 
				
			} else if (wetUbiType == 2) {
				
				System.out.println("Type the name of the neighborhood"); 
				place = sc.next();
				
				finCompUbi = true; 
				
			} else {
				
				System.out.println("You must type a valid option");
				
			}
			
			
		}
		
		System.out.println("Type the ID of the new wetland");
		
		String wetlandID = sc.next();
		
		String msg = controller.createWetland(wetUbiType, wetArea, wetName, wetlandID, wetPhoto, place, goalPercentage, priv, protectedArea);
		
		System.out.println(msg);
		
	}

	public static void registerFauna() {
		
		boolean migComp = false; 
		boolean mig = false; 
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("These are the Wetlands currently registered:" + controller.showWetlands());
			
			System.out.println("Type the name");
			
			String specieName = sc.next();
			
			System.out.println("Type the cientific name");
			
			String cientificName = sc.next();
			
			System.out.println("Type the cientific name");
			
			while (!migComp) {
				
				System.out.println("If is a migratory specie, type 1, if it is not, type 2");
			
				int migCompNum = sc.nextInt();
				
				if (migCompNum == 1) {
				
					mig = true; 
					
					migComp = true; 
					
				} else if (migCompNum == 2) {
					
					migComp = true; 
					
				} else {
					
					System.out.println("You must type a valid option");
					
				}	
				
			}
			
			System.out.println("Type the Specie\n1) Bird\n 2)Mamal\n3) Acuatic");
			
			int faunaType = sc.nextInt();
			
			System.out.println("Type the ID of the wetland");
			
			String wetlandID = sc.next();
			
			String msg = controller.createFauna(specieName, cientificName, mig, faunaType, wetlandID);
			
			System.out.println(msg);
			
		}
		
		
		
	}
	
	public static void registerFlora() {
		
		
		boolean migComp = false; 
		boolean mig = false; 
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("These are the Wetlands currently registered:" + controller.showWetlands());
			
			System.out.println("Type the name");
			
			String specieName = sc.next();
			
			System.out.println("Type the cientific name");
			
			String cientificName = sc.next();
			
			while (!migComp) {
				
				System.out.println("If is a migratory specie, type 1, if it is not, type 2");
			
				int migCompNum = sc.nextInt();
				
				if (migCompNum == 1) {
				
					mig = true; 
					
					migComp = true; 
					
				} else if (migCompNum == 2) {
					
					migComp = true; 
					
				} else {
					
					System.out.println("You must type a valid option");
					
				}	
				
			}
			
			System.out.println("Type the Specie\n1) Acuatic\n 2) Ground");
			
			int floraType = sc.nextInt();
			
			System.out.println("Type the ID of the wetland");
			
			String wetlandID = sc.next();
			
			String msg = controller.createFlora(specieName, cientificName, mig, floraType, wetlandID);
			
			System.out.println(msg);
			
		}
		
	}
	
	public static void registerEvent () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("These are the Wetlands currently registered:" + controller.showWetlands());
			
			System.out.println("Type the name of the host");
			
			String hostName = sc.next();
			
			System.out.println("Type the event value");
			
			double value = sc.nextDouble();
			
			System.out.println("Type the event description: ");
			
			String description = sc.next();
			
			System.out.println("Type the new Event date: ");
			System.out.println("Type the year: ");
			int year = sc.nextInt();
			System.out.println("Type the month: ");
			int month = sc.nextInt();
			System.out.println("Type the day");
			int day = sc.nextInt();
			
			System.out.println("Type the new Event type: \n1) MAINTENANCE \n2) SCHOOL VISITINGS \n3) UPGRADINGS \n4) CELEBRATIONS");
			
			int eventType = sc.nextInt();
			
			System.out.println("Type the ID of the wetland");
			String wetlandID = sc.next();
			
			String msg = controller.createEvent(hostName, value, description, year, month, day, eventType, wetlandID);
			
			System.out.println(msg);
			
		}
		
		
		
	}
	
	public static void showAll () {
		
		System.out.println(controller.showWetlands());
		System.out.println(controller.showAnimals());
		System.out.println(controller.showPlants());
		System.out.println(controller.showEvents());
		
	}
	
	public static void maintenance () {
		
		System.out.println("Type the id of the wetland");
		String wetlandID = sc.next();
		
		System.out.println("Type the year");
		int year = sc.nextInt();
		
		String msg = controller.maintenance(wetlandID, year);
		
		System.out.println(msg);
		
	}
	
}