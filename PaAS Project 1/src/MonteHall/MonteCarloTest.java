package MonteHall;

/*
 * Test method for MonteCarlo.
 */
public class MonteCarloTest {
	
	/*
	 * Main method to test MonteCarlo.
	 */
	public static void main(String[] args) {
		MonteCarlo test = new MonteCarlo();
		System.out.println("Keeps Choice: " + test.carlo(10000,false) + "%");
		System.out.println("Changes Choice: " + test.carlo(10000,true) + "%");
	}
}
