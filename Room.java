public class Room {
	private double price;  
	private String day;
	private String type;
	private String name;
	private int nights;
	private boolean breakfast;
	private int maxAdults, maxChildren, currentAdults, currentChildren;
	private double[] rates = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };     // stores rates for every particular day 
	private String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };  // different days
	private int num;   //number of rooms available
	

	Room(String type) {
		this.type = type;
	}

	/*
	 * Set the price for a particular day checks if the day exists or not
	 */
	public void setDayRate(int day, double price) {
		rates [day] = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}


	public double[] getRates() {
		return rates;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMaxChildren() {
		return maxChildren;
	}

	public void setMaxChildren(int maxChildren) {
		this.maxChildren = maxChildren;
	}

	public int getMaxAdults() {
		return maxAdults;
	}

	public void setMaxAdults(int maxAdults) {
		this.maxAdults = maxAdults;
	}
	public int getCurrentAdults() {
		return currentAdults;
	}

	public void setCurrentAdults(int currentAdults) {
		this.currentAdults = currentAdults;
	}

	public int getCurrentChildren() {
		return currentChildren;
	}

	public void setCurrentChildren(int currentChildren) {
		this.currentChildren = currentChildren;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	
}