package MonteHall;

import java.util.Random;

/*
 * Initiates a number of run of a Monte Carlo simulation.
 */
public class MonteCarlo {
	
	/*
	 * Runs the Monte Carlo simulation. First input is number of rounds, second
	 * is if the simulation will change the selected door when given the option to.
	 */
	public double carlo(int rounds, boolean change) {
		int count = 0;
		int choice = 0;
		int prize = 0;
		Random rng = new Random();
		for(int i = 0; i < rounds; i++) {
			prize = rng.nextInt(3);
			choice = rng.nextInt(3);
			if(!change) {
				if(choice == prize) {
					count++;
				}
			} else {
				if(choice != prize) {
					count++;
				}
				
			}
		}
		return count/(rounds+0.0);
	}
	
}