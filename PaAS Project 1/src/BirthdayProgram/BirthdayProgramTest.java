package BirthdayProgram;

public class BirthdayProgramTest {
	
	/*
	 * Test method for BirthdayProgram
	 */
	public static void main(String[] args) {
		BirthdayProgram test = new BirthdayProgram(23);
		System.out.println("Number of people: 23");
		System.out.println("Number of runs: 1000");
		System.out.println("Probability of two sharing a birthday: " + test.run(1000));
	}
	
}
