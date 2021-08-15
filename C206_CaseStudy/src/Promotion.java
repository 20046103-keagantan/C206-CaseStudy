
public class Promotion {

	private int id;
	private String item;
	private double oldprice;
	private double offerprice;
	private int days;
	private boolean isAvailable;
	public Promotion(int id, String item, double oldprice, double offerprice, int days) {
		super();
		this.id = id;
		this.item = item;
		this.oldprice = oldprice;
		this.offerprice = offerprice;
		this.days = days;
		this.isAvailable = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getOldprice() {
		return oldprice;
	}
	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}
	public double getOfferprice() {
		return offerprice;
	}
	public void setOfferprice(double offerprice) {
		this.offerprice = offerprice;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return isAvailable;
	}
	
	
	
	
	
	
}
