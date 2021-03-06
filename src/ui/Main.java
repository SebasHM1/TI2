package ui;

import model.Controller;
import java.util.Scanner;

public class Main {

	public static Scanner sc; 
	public static Controller controller; 
	
	public static void main (String args[]) {
		
		init();
		menu();
		
	}
	
	/**
	 <pre>
	 *<strong>Descripcion:</strong> This method inicialices the global variables
	 *pre: sc and controller should be declared 
	 *pos: sc and controller are inicialiced 
	 </pre>
	 */
	
	public static void init () {
		
		sc = new Scanner(System.in);
		controller = new Controller(); 
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong>  This method shows the program's menu 
	 *pre: global variables sould be inicialiced
	 *pos: no
	 * </pre>
	 */
	
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
			System.out.println("8) Show the Wetlan with more fauna");
			System.out.println("9) Show the Wetlan with less flora");
			System.out.println("10) Exit");
			
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
				check();

				break;	
					
				case 7: 
				showAll();
				
				break;
		
				case 8:
				moreFauna();
				
				break;
				
				case 9: 
				lessFlora();
				
				break;
				
				case 10: 
					
					System.out.println("Thanks for using");
					fin = true;
					break;
					
				default: 
				
				System.out.println("Your must type a valid option");
				break;
				
			}
			
		}
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method allows the user to create a wetland object by show a menu to thisone. 
	 *pre: global variables sould be inicialiced
	 *pos: Call the method createWetland at Controller 
	 * </pre>
	 */

	
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
		
		while (goalPercentage > 100 || goalPercentage < 0) {
			
			System.out.println("You must type a valid option");
			goalPercentage = sc.nextDouble();
			
		} 
		
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
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method allows the user to create a fauna object by show a menu to thisone. 
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: Call the method createFauna at Controller 
	 * </pre>
	 */

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
			
			System.out.println("Type the Specie\n1) Bird\n2) Mamal\n3) Acuatic");
			
			int faunaType = sc.nextInt();
			
			System.out.println("Type the ID of the wetland");
			
			String wetlandID = sc.next();
			
			String msg = controller.createFauna(specieName, cientificName, mig, faunaType, wetlandID);
			
			System.out.println(msg);
			
		}
		
		
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method allows the user to create a flora object by show a menu to thisone. 
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: Call the method createFlora at Controller 
	 * </pre>
	 */
	
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
			
			System.out.println("Type the Specie\n1) Acuatic\n2) Ground");
			
			int floraType = sc.nextInt();
			
			System.out.println("Type the ID of the wetland");
			
			String wetlandID = sc.next();
			
			String msg = controller.createFlora(specieName, cientificName, mig, floraType, wetlandID);
			
			System.out.println(msg);
			
		}
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method allows the user to create a event object by show a menu to thisone. 
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: Call the method createEvent at Controller 
	 * </pre>
	 */
	
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
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method shows the user all the objects created except by the event's 
	 pre: Object wetland should be created and global variables must be inicialiced
	 pos: Shows the methods showWetlands, showAnimals and showPlants at Controller 
	 * </pre>
	 */
	
	public static void showAll () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println(controller.showWetlands());
			System.out.println(controller.showAnimals());
			System.out.println(controller.showPlants());	
			
		}
		
		
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method shows the total maintenance of a wetland in a year 
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: Shows the method maintenance at Controller 
	 * </pre>
	 */
	
	public static void maintenance () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("Type the id of the wetland");
			String wetlandID = sc.next();
			
			System.out.println("Type the year");
			int year = sc.nextInt();
			
			String msg = controller.maintenance(wetlandID, year);
			
			System.out.println(msg);
			
		}
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method shows the wetland who have a specie given for the user 
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: shows the method wetBySpecie at Controller
	 * </pre>
	 */
	
	public static void check () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else {
			
			System.out.println("Type the name of the Specie");
			String checkSpecie = sc.next();
			
			String msg = controller.wetBySpecie(checkSpecie);
			
			System.out.println(msg);
			
			
		}
		
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method shows the object wetland who has the most fauna objects
	 *pre: Object wetland should be created and global variables must be inicialiced
	 *pos: Shows the method moreFaunaControll at Controll
	 * </pre>
	 */
	
	public static void moreFauna () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else if (controller.moreFaunaControll().equals("")){
			
			System.out.println("There's no Animals");
			
		} else if (controller.moreFaunaControll() != "") {
			
			String msg = controller.moreFaunaControll();
			
			System.out.println(msg);
			
		}
		
	}
	
	/**
	 * <pre>
	 *<strong>Descripcion:</strong> This method shows the object wetland who has the fewest flora objects
	 pre: Object wetland should be created and global variables must be inicialiced
	 pos: Show thec method lessFloraControll at Controll
	 * </pre>
	 */
	
	public static void lessFlora () {
		
		if (controller.showWetlands().equals("") ) {
			
			System.out.println("There aren't any wetlands registered.");
			
		} else  if (controller.lessFloraControll().equals("")) { 
			
			System.out.println("There's no Plants");
			
		} else if (controller.lessFloraControll() != ("")) {
			
			String msg = controller.lessFloraControll();
			
			System.out.println(msg);
			
			
		}
		
	}
	
	
}