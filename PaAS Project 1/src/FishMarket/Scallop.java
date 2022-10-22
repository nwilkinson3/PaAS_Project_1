package FishMarket;

import java.util.Random;

public class Scallop extends Seafood {
	
	private Random rng;
	
	/*
	 * Constructor for Scallop where weight is given.
	 */
	Scallop(double weight){
		super("Scallop", weight);
	}
	
	/*
	 * Constructor for Scallop where weight is not given. Randomly generates the weight.
	 */
	Scallop(){
		super("Scallop", 0);
		rng = new Random();
		this.setWeight(Math.round(1+rng.nextDouble()*4*100.0)/100.0);		//'1+' min, '*4' max
	}
	
}
