package BirthdayProgram;

import java.util.ArrayList;

public class BirthdayProgram {
	
	private int popSize;
	private ArrayList<Person> pop;
	
	/*
	 * The constructor for BirthdayProgram.
	 */
	public BirthdayProgram(int popi){
		popSize = popi;
	}
	
	/*
	 * Helper method for run method to create a new pop (population).
	 * 
	 * All populations have the same number of Persons (people).
	 */
	public void createPop() {
		pop = new ArrayList<>();
		for(int i = 0; i < popSize; i++) {
			pop.add(new Person());
		}
	}
	
	/*
	 * Helper method for run method to find a shared birthday in a the pop (population).
	 * Returns 0 if there is no match, returns 1 if there is at least one match.
	 */
	public int searchPop() {
		for(int i = 0; i < pop.size()-1; i++) {
			for(int j = i+1; j < pop.size(); j++) {
				if(pop.get(i).sameBirth(pop.get(j))) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	/*
	 * Method to create and check an inputed number of pops (populations) to check for matching
	 * birthdays. Outputs the rate that there was a shared birthday.
	 * 
	 * Uses the createPop and searchPop helper methods.
	 */
	public double run(int runs) {
		int count = 0;
		for(int i = 0; i < runs; i++) {
			createPop();
			count += searchPop();
		}
		return (count+0.0)/runs;
	}
	
}
