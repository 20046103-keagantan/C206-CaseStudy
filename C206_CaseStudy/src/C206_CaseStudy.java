import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		int option = 0;

		while (option != 16) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items

			} else if (option == 2) {
				// Add a new item
				

			} else if (option == 3) {
				// Loan item
				

			} else if (option == 4) {
				// Return item
				

			} else if (option == 5) {
				// Return item
				

			} else if (option == 6) {
				// Return item
				

			} else if (option == 7) {
				// Return item
				

			} else if (option == 8) {
				// Return item
				

			} else if (option == 9) {
				// Return item
				

			} else if (option == 10) {
				// Return item
				

			} else if (option == 11) {
				// Return item
				

			} else if (option == 12) {
				// Return item
				

			} else if (option == 13) {
				// Return item
				

			} else if (option == 14) {
				// Return item
				

			} else if (option == 15) {
				// Return item
				

			} else if (option == 16) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Automation System (CAS)");
		System.out.println("1. Add new stall");
		System.out.println("2. View Stall");
		System.out.println("3. Delete Stall");
		System.out.println("4. Add new food items");
		System.out.println("5. View food items");
		System.out.println("6. Delete food items");
		System.out.println("7. Add new purchase orders of ingredients");
		System.out.println("8. View purchase orders of ingredients");
		System.out.println("9. Delete purchase orders of ingredients");
		System.out.println("10. Add new promotion offers");
		System.out.println("11. View promotion offers");
		System.out.println("12. Delete promotion offers");
		System.out.println("13. Add new orders by customer");
		System.out.println("14. View orders by customer");
		System.out.println("15. Delete orders by customer");
		System.out.println("16. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	

}

