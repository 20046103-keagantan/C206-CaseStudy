
public class Food {
	private int id;
	private String name; 
	private int price; 
	private String stallName;
	private boolean isAvailable;

	public Food(int id, String name, int price, String stallName) {
		this.id = id;
		this.name = name;
		this.price=price;
		this.stallName = stallName;
		this.isAvailable = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


}



