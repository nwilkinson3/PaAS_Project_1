package BirthdayProgram;

import java.util.Random;

public class Person {
	
	private int birthMonth;
	private int birthDay;
	private Random rng;
	
	/*
	 * Constructor for Person where there is an inputed birth month and day.
	 */
	public Person(int month, int day) {
		birthMonth = month;
		birthDay = day;
	}
	
	/*
	 * Constructor for Person where there is no input. Randomly creates birthMonth and birthDay.
	 * 
	 * Leap years are not considered.
	 */
	public Person() {
		rng = new Random();
		birthMonth = rng.nextInt(12)+1;
		if(birthMonth == 2) {
			birthDay = rng.nextInt(28)+1;
		} else if(birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) {
			birthDay = rng.nextInt(30)+1;
		} else {
			birthDay = rng.nextInt(31)+1;
		}
	}
	
	/*
	 * Compared this Person's birth month and day to the inputed Person's birthMonth and birthDday.
	 * Returns true if they share a birthday, and false if they do not.
	 */
	public boolean sameBirth(Person compare) {
		if(birthMonth == compare.getBMonth() && birthDay == compare.getBDay()) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Fetch method for birthMonth.
	 */
	public int getBMonth() {
		return birthMonth;
	}
	
	/*
	 * Fetch method for birthDay.
	 */
	public int getBDay() {
		return birthDay;
	}
	
}
