import java.util.Date;

/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ahmad Muhyiddin
 * Student ID: 20019812
 * Class: W64C
 * Date/Time created: Monday 09-08-2021 16:47
 */
import java.time.LocalDate;

public class Order {
	
	private int id;
	private double price;
	private LocalDate orderdate;
	
	
	public Order(int id, double price, LocalDate orderdate) {
		this.id = id;
		this.price = price;
		this.orderdate = orderdate;
	}

	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

}
