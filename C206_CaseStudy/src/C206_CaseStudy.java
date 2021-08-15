import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		int option = 0;

		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		promotionList.add(new Promotion(1, "Spaghetti", 5.00, 3.50, 6));
		promotionList.add(new Promotion(2, "Fries", 3.00, 1.00, 6));

		ArrayList<purchaseOrder> poList = new ArrayList<purchaseOrder>();
		poList.add(new purchaseOrder(1, "Spaghetti", 5.00, 20, "cash"));
		poList.add(new purchaseOrder(2, "Fries", 3.00, 50, "cash"));

		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new Food(01, "Bubble Tea", 3, "Drinks Stall"));
		foodList.add(new Food(02, "Mee Rebus", 4, "Noodle Stall"));
		foodList.add(new Food(03, "Kimchi Fried Rice", 4, "Korean Stall"));
		foodList.add(new Food(04, "Chicken Cutlet", 4, "Western Stall"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(1, 15.00, LocalDate.parse("04/02/2021", formatter)));
		orderList.add(new Order(2, 21.00, LocalDate.parse("17/05/2021", formatter)));
		orderList.add(new Order(3, 36.00, LocalDate.parse("26/06/2021", formatter)));
		orderList.add(new Order(4, 9.00, LocalDate.parse("18/10/2021", formatter)));

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<stalls> SList = new ArrayList<stalls>();
		SList.add(new stalls(1, "Western Stall", LocalDate.parse("22/02/2020", formatter1)));
		SList.add(new stalls(2, "Korean Stall", LocalDate.parse("01/04/2020", formatter1)));
		SList.add(new stalls(3, "Noodle Stall", LocalDate.parse("04/05/2019", formatter1)));
		SList.add(new stalls(4, "Drink Stall", LocalDate.parse("20/09/2020", formatter1)));

		while (option != 16) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add a new Stall
				stalls stall = inputStall();
				C206_CaseStudy.addStall(SList, stall);

			} else if (option == 2) {
				// View all Stalls
				C206_CaseStudy.viewStall(SList);

			} else if (option == 3) {
				// Delete a stall
				C206_CaseStudy.deleteStall(SList);

			} else if (option == 4) {
				// add food item
				Food f = inputFood();
				C206_CaseStudy.addFood(foodList, f);

			} else if (option == 5) {
				// view food item
				C206_CaseStudy.viewAllFood(foodList);

			} else if (option == 6) {
				// delete food item
				C206_CaseStudy.deleteFood(foodList);

			} else if (option == 7) {
				// Add new purchase orders of ingredients
				purchaseOrder npo = inputPo();
				C206_CaseStudy.addPo(poList, npo);
			} else if (option == 8) {
				// View purchase orders of ingredients
				C206_CaseStudy.viewAllPo(poList);
			} else if (option == 9) {
				// Delete purchase orders of ingredients
				C206_CaseStudy.deletePo(poList);
			} else if (option == 10) {
				// Add new promotion offers
				Promotion po = inputPromotion();
				C206_CaseStudy.addPromotion(promotionList, po);

			} else if (option == 11) {
				// View promotion offers
				C206_CaseStudy.viewAllPromotion(promotionList);

			} else if (option == 12) {
				// Delete promotion offers
				C206_CaseStudy.deletePromotion(promotionList);
			} else if (option == 13) {
				// Add orders
				Order or = inputOrder();
				C206_CaseStudy.addOrder(orderList, or);

			} else if (option == 14) {
				// View Orders
				C206_CaseStudy.viewOrder(orderList);

			} else if (option == 15) {
				// Delete Orders
				C206_CaseStudy.deleteOrder(orderList);

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

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	public static String retrieveAllPromotion(ArrayList<Promotion> promotionList) {
		String output = "";

		for (int i = 0; i < promotionList.size(); i++) {

			output += String.format("%-10d %-10s %-20.2f %-10s %-10.2f %-20d\n", promotionList.get(i).getId(),
					promotionList.get(i).getItem(), promotionList.get(i).getOldprice(),
					C206_CaseStudy.showAvailability(promotionList.get(i).getIsAvailable()),
					promotionList.get(i).getOfferprice(), promotionList.get(i).getDays());
		}
		return output;
	}

	public static void viewAllPromotion(ArrayList<Promotion> promotionList) {
		C206_CaseStudy.setHeader("PROMOTION LIST");
		String output = String.format("%-10s %-10s %-20s %-10s %-10s %-20s\n", "ID", "ITEM", "OLD PRICE", "AVAILABLE",
				"OFFER PRICE", "DAYS");
		output += retrieveAllPromotion(promotionList);
		System.out.println(output);
	}

	public static Promotion inputPromotion() {
		int id = Helper.readInt("Enter ID > ");
		String item = Helper.readString("Enter item > ");
		double oldprice = Helper.readDouble("Enter old price > ");
		double offerprice = Helper.readDouble("Enter offer price > ");
		int days = Helper.readInt("Enter days > ");

		Promotion po = new Promotion(id, item, oldprice, offerprice, days);
		return po;

	}

	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion po) {

		promotionList.add(po);
		System.out.println("Promotion added");
	}

	public static boolean findPromotion(ArrayList<Promotion> promotionList, int id) {
		for (int i = 0; i < promotionList.size(); i++) {
			if (id == promotionList.get(i).getId()) {
				return true;
			}

		}
		return false;
	}

	public static void deletePromotion(ArrayList<Promotion> promotionList) {
		boolean deleted = false;
		int id = Helper.readInt("Enter promotion ID > ");
		if (findPromotion(promotionList, id)) {
			for (int i = 0; i < promotionList.size(); i++) {
				if (id == promotionList.get(i).getId()) {
					promotionList.remove(i);
					deleted = true;
				}
			}
		}
		if (deleted == true) {
			System.out.println("Promotion Offer Deleted");
		} else {
			System.out.println("Promotion Offer Not Deleted");
		}
	}

	public static String retrieveAllPo(ArrayList<purchaseOrder> poList) {
		String output = "";

		for (int i = 0; i < poList.size(); i++) {

			output += String.format("%-10d %-10s %-20.2f %-10d %-20s\n", poList.get(i).getId(), poList.get(i).getName(),
					poList.get(i).getPrice(), poList.get(i).getQty(), poList.get(i).getPaymentType());
		}
		return output;
	}

	public static void viewAllPo(ArrayList<purchaseOrder> poList) {
		C206_CaseStudy.setHeader("PROMOTION LIST");
		String output = String.format("%-10s %-10s %-20s %-10s %-20s\n", "ID", "ITEM", "PRICE", "QUANTITY",
				"PAYMENT TYPE");
		output += retrieveAllPo(poList);
		System.out.println(output);
	}

	public static purchaseOrder inputPo() {
		int id = Helper.readInt("Enter ID > ");
		String item = Helper.readString("Enter item > ");
		double price = Helper.readDouble("Enter price > ");
		int qty = Helper.readInt("Enter quantity > ");
		String paymentType = Helper.readString("Enter payment type > ");

		purchaseOrder npo = new purchaseOrder(id, item, price, qty, paymentType);
		return npo;

	}

	public static void addPo(ArrayList<purchaseOrder> poList, purchaseOrder npo) {

		poList.add(npo);
		System.out.println("Purchase Order added");
	}

	public static boolean findPo(ArrayList<purchaseOrder> poList, int id) {
		for (int i = 0; i < poList.size(); i++) {
			if (id == poList.get(i).getId()) {
				return true;
			}

		}
		return false;
	}

	public static void deletePo(ArrayList<purchaseOrder> poList) {
		boolean deleted = false;
		int id = Helper.readInt("Enter promotion ID > ");
		if (findPo(poList, id)) {
			for (int i = 0; i < poList.size(); i++) {
				if (id == poList.get(i).getId()) {
					poList.remove(i);
					deleted = true;
				}
			}
		}
		if (deleted == true) {
			System.out.println("Purchase Order Deleted");
		} else {
			System.out.println("Purchase Order Not Deleted");
		}
	}

	public static Food inputFood() {
		// int id, String name, double price, String stallName
		int id = Helper.readInt("Enter id of new food  > ");
		String name = Helper.readString("Enter food name >");
		int price = Helper.readInt("Enter Price >");
		String stall = Helper.readString("Enter stall name > ");

		Food f = new Food(id, name, price, stall);
		return f;

	}

	public static void addFood(ArrayList<Food> foodList, Food f) {
		foodList.add(f);
		System.out.println("Food added!");
	}

	public static boolean findFood(ArrayList<Food> foodList, int id) {
		for (int i = 0; i < foodList.size(); i++) {
			if (id == foodList.get(i).getId()) {
				return true;
			}

		}
		return false;
	}

//================================= Option 5 View items (CRUD- Read) =================================
	public static String retrieveAllFood(ArrayList<Food> foodList) {
		String output = "";

		for (int i = 0; i < foodList.size(); i++) {

			output += String.format("%-10d %-30s %-10d %-10s %-20s\n", foodList.get(i).getId(),
					foodList.get(i).getName(), foodList.get(i).getPrice(), foodList.get(i).getStallName(),
					C206_CaseStudy.showAvailability(foodList.get(i).isAvailable()));
		}
		return output;
	}

	public static void viewAllFood(ArrayList<Food> foodList) {
		C206_CaseStudy.setHeader("FOOD MENU");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ID", "NAME", "PRICE", "STALL NAME",
				"AVAILABLE");
		output += retrieveAllFood(foodList);
		System.out.println(output);
	}

//================================= Option 6 Delete an item (CRUD - Create) =================================

	public static void deleteFood(ArrayList<Food> foodList) {
		boolean deleted = false;
		int id = Helper.readInt("Enter food ID > ");
		if (findFood(foodList, id)) {
			for (int i = 0; i < foodList.size(); i++) {
				if (id == foodList.get(i).getId()) {
					foodList.remove(i);
					deleted = true;
				}
			}
		}
		if (deleted == true) {
			System.out.println("Food Item Deleted!");
		} else {
			System.out.println("Food Item Not Deleted!");
		}
	}

	public static String retrieveAllOrder(ArrayList<Order> orderList) {
		String output = "";

		for (Order or : orderList) {
			output += String.format("%-5s %-10s %-10s\n", or.getId(), or.getPrice(), or.getOrderdate());
		}
		return output;
	}

	public static void viewOrder(ArrayList<Order> orderList) {
		String output = String.format("%-5s %-10s %-10s\n", "ID", "Price", "Order Date");
		output += retrieveAllOrder(orderList);
		System.out.println(output);
	}

	public static Order inputOrder() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id = Helper.readInt("Enter ID > ");
		double price = Helper.readDouble("Enter price > $");
		String orderdate = Helper.readString("Enter date (DD/MM/YYYY) > ");
		LocalDate orderdateLD = LocalDate.parse(orderdate, formatter);

		Order or = new Order(id, price, orderdateLD);
		return or;
	}

	public static void addOrder(ArrayList<Order> orderList, Order or) {
		orderList.add(or);
		System.out.println("Order added!");
	}

	public static boolean findOrder(ArrayList<Order> orderList, int id) {
		for (int i = 0; i < orderList.size(); i++) {
			if (id == orderList.get(i).getId()) {
				return true;
			}

		}
		return false;
	}

	public static void deleteOrder(ArrayList<Order> orderList) {
		boolean deleted = false;
		int id = Helper.readInt("Enter order ID > ");
		if (findOrder(orderList, id)) {
			for (int i = 0; i < orderList.size(); i++) {
				if (id == orderList.get(i).getId()) {
					orderList.remove(i);
					deleted = true;
				}
			}
		}
		if (deleted == true) {
			System.out.println("Order Deleted!");
		} else {
			System.out.println("Order Not Deleted");

		}

	}

	public static String retrieveAllStall(ArrayList<stalls> SList) {
		String output = "";
		// write your code here
		for (stalls Stall : SList) {
			output += String.format("%-5s %-20s %-10s\n", Stall.getId(), Stall.getName(), Stall.getOperationDate());
		}
		return output;
	}

	private static void viewStall(ArrayList<stalls> SList) {
		String output = String.format("%-5s %-20s %-10s\n", "ID", "Name", "Operation Date");
		output += retrieveAllStall(SList);
		System.out.println(output);
	}

	public static stalls inputStall() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id = Helper.readInt("Enter Stall ID > ");
		String name = Helper.readString("Enter Stall Name > ");
		String operationDate = Helper.readString("Enter Stall's Date of Operation (DD/MM/YYYY) > ");
		LocalDate operationDateLD = LocalDate.parse(operationDate, formatter1);

		stalls stall = new stalls(id, name, operationDateLD);
		return stall;
	}

	public static void addStall(ArrayList<stalls> SList, stalls stall) {
		// write your code here
		SList.add(stall);
		System.out.println("Stall added");
	}

	public static boolean findStall(ArrayList<stalls> SList, int id) {
		for (int i = 0; i < SList.size(); i++) {
			if (id == SList.get(i).getId()) {
				return true;
			}
		}
		return false;
	}

	public static void deleteStall(ArrayList<stalls> SList) {
		int id = Helper.readInt("Enter Stall's ID > ");
		boolean found = false;
		int r = 0;
		int stallID = 0;
		for (int i = 0; i < SList.size(); i++) {
			stallID = SList.get(i).getId();
			if (id == stallID) {
				found = true;
				r = i;
			}
		}
		if (found == true) {
			SList.remove(r);
			System.out.println("Stall ID " + id + " is removed!");
		} else {
			System.out.println("Invalid product ID");
		} // end if else
	}

}
