package FishMarket;

import java.util.Random;

public class Shrimp extends Seafood {
	
	private Random rng;
	
	/*
	 * Constructor for Shrimp where weight is given.
	 */
	Shrimp(double weight){
		super("Shrimp", weight);
	}
	
	/*
	 * Constructor for Shrimp where weight is not given. Randomly generates the weight.
	 */
	Shrimp(){
		super("Shrimp", 0);
		rng = new Random();
		this.setWeight(Math.round(1+rng.nextDouble()*4*100.0)/100.0);		//'1+' min, '*4' max
	}
}
