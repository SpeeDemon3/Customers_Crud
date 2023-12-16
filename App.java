package customerDatabaseManager;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		System.out.println("***Customer database manager***\n");
		
		boolean control = false;
		
		
		do {
			
			Scanner sc = new Scanner(System.in);
			
			Tool.showMenu();
			
//			System.out.println("Menu:");
//			System.out.println("\tPress[0] - Exit");
//			System.out.println("\tPress[1] - Insert Customer");
//			System.out.println("\tPress[2] - Show Customers");
//			System.out.println("\tPress[3] - Update Customer");
//			System.out.println("\tPress[4] - Delete Customer");
//			System.out.println("\tPress[5] - Search Customer");
			
			
			try {
				
				int opcUser = sc.nextInt();
				
				if (opcUser >= 0 && opcUser <= 5) {
					
					// Aqui ejecutaria la funcion que contiene el switch con todas la operaciones
					// pasando como parametro a la funcion la variable opcUser
					
					DataManager dm = new DataManager();

					
					switch (opcUser) {
					
						case 0:
							System.out.println("Thanks for using the app.");
							control = true;
							break;
						case 1:
							
							System.out.println("Introduce your name:");
							
							String nameUser = sc.nextLine();
							
							System.out.println("Introduce your address:");
							
							String addressUser = sc.nextLine();
							
							try {
								dm.insertCustomer(nameUser, addressUser);
							} catch (SQLException e) {
								System.err.println("SQL error when executing an INSERT " + e.getMessage());
								
								e.printStackTrace();
							}
							
							break;
							
						case 2:
							try {
								dm.showCustomers("customer");
							} catch (SQLException e) {
								System.err.println("SQL error when executing an SELECT " + e.getMessage());
								e.printStackTrace();
							}
							break;
							
						case 3:
							
							System.out.println("Enter the ID of the user you want to modify:");
							int idUser = sc.nextInt();

							System.out.println("Enter the name of the user you want to modify:");
							String updateName = sc.nextLine();
							
							System.out.println("Enter the address of the user you want to modify:");
							String updateAddress = sc.nextLine();
							
							try {
								dm.updateCustomer(idUser, updateName, updateAddress);
							} catch (SQLException e) {
								System.err.println("SQL error when executing an UPDATE " + e.getMessage());
								e.printStackTrace();
							}
							
							break;
							
						case 4:
							
							System.out.println("Enter the ID of the customer you want to delete:");
							
							int idDelete = sc.nextInt();
							
							try {
								dm.deleteCustomer(idDelete);
							} catch (SQLException e) {
								System.err.println("SQL error when executing an DELETE " + e.getMessage());
								e.printStackTrace();
							}
							
							break;
							
						case 5:
							
							System.out.println("Enter the ID of the customer you want to search for:");
							
							int idCustomer = sc.nextInt();
							
							try {
								dm.searchCustomer(idCustomer);
							} catch (SQLException e) {
								System.err.println("SQL error when executing an SELECT " + e.getMessage());
								e.printStackTrace();
							}
							
							break;
							
					
					}
					
					
				} else {
					
					System.out.println("Select a correct option...");
					
				}
				
				
			} catch(InputMismatchException ime) {
				System.out.println("Please, You must enter a numerical value within the range of options!!!");
			}
			


			
		} while(!control);
		
		
	}

}
