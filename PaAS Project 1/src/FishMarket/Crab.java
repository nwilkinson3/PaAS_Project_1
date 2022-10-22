package FishMarket;

import java.util.Random;

public class Crab extends Seafood {
	
	private Random rng;
	
	/*
	 * Constructor for Crab where weight is given.
	 */
	Crab(double weight){
		super("Crab", weight);
	}
	
	/*
	 * Constructor for Crab where weight is not given. Randomly generates the weight.
	 */
	Crab(){
		super("Crab", 0);
		rng = new Random();
		this.setWeight(Math.round(1+rng.nextDouble()*4*100.0)/100.0);		//'1+' min, '*4' max
	}
	
}
