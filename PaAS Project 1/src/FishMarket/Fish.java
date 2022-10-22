package FishMarket;

import java.util.Random;

public class Fish extends Seafood {
	
	private Random rng;
	
	/*
	 * Constructor for Fish where weight is given.
	 */
	Fish(double weight) {
		super("Fish", weight);
	}
	
	/*
	 * Constructor for Fish where weight is not given. Randomly generates the weight.
	 */
	Fish(){
		super("Fish", 0);
		rng = new Random();
		this.setWeight(Math.round(1+rng.nextDouble()*4*100.0)/100.0);		//'1+' min, '*4' max
	}
	
}
