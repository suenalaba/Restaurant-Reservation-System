package restaurant_application;

import java.util.InputMismatchException;
import java.util.Scanner;

import restaurant_manager.TableLayoutManager;

public class TableApp {
	public static void createTableQuery() { //creates table with tableID and pax of 2 increment
		Scanner sc=new Scanner(System.in);
		int tableID, tableCapacity; 
		System.out.println("Enter table ID of new table: ");
		tableID = sc.nextInt(); 
		sc.nextLine();
		if(TableLayoutManager.findTableIndex(tableID) == -1) { //if no existing tableID
			System.out.println("Select desired table capacity: ");
			System.out.println("2/4/6/8/10");
			try {
			tableCapacity = sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input");
				return;
			}
			if(tableCapacity == 2 || tableCapacity == 4 || tableCapacity == 6 || tableCapacity == 8 || tableCapacity ==10) {
				TableLayoutManager.createTable(tableID, tableCapacity); 
				System.out.println("Table " + tableID + " with table capacity of " + tableCapacity + " created");
				return;
			}
			else {
				System.out.println("Invalid table capacity");
				return;
			}
		}
		else{
			System.out.println("Table already exists!");
		}
	} 
	
	public static void removeTableQuery() {
		Scanner sc = new Scanner(System.in); 
		int tableID; 
		System.out.println("Enter table ID of table to be removed");
		try {
			tableID = sc.nextInt();
			sc.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input");
			return;
		}
		TableLayoutManager.removeTable(tableID);
		
	}
	
}