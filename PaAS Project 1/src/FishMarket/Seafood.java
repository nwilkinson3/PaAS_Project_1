package FishMarket;

public class Seafood {
	
	private String type;
	private double weight;
	private double price;
	
	/*
	 * Constructor for Seafood.
	 */
	Seafood(String iType, double iWeight) {
		type = iType;
		weight = iWeight;
		price = Math.round(7.99*weight*100.0)/100.0;		// $7.99 per pound of anything
	}
	
	/*
	 * Fetch method for type.
	 */
	public String getType() {
		return type;
	}
	
	/*
	 * Fetch method for weight.
	 */
	public double getWeight() {
		return weight;
	}
	
	/*
	 * Set method for weight. Also changes price (price is based on weight).
	 */
	public void setWeight(double newW) {
		weight = newW;
		price = Math.round(7.99*weight*100.0)/100.0;
	}
	
	/*
	 * Fetch method for price.
	 */
	public double getPrice() {
		return price;
	}
	
}
