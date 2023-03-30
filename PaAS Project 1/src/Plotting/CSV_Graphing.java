package Plotting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CSV_Graphing {
	
	/*
	 * Plots a linear equation (Y = mx+b) int a .csv file given int min, the minimum x value,
	 * int max, the maximum x value, int m, the slope, int b, the point where the line
	 * intersects the y access, and String fileName, the name of the .csv fine to be made.
	 * 
	 * The program automatically adds ".csv" to the filename.
	 */
	public void plotter(int min, int max, int m, int b, String fileName) throws IOException {
		FileWriter w = new FileWriter(fileName + ".csv");
		PrintWriter pw = new PrintWriter(w);
		int value;
		for(int i = min; i < max; i++) {
			value = i*m+b;
			pw.println(value);
		}
		pw.close();
		w.close();
	}
	
	/*
	 * Salts a .csv file's points into a new .csv file given int range by adding or subtracting
	 * a random value. Takes the range, the range that the random variable will be in to add or
	 * subtract from the points, String oldName, the name of the file to be salted, and newName,
	 * the name of the file that the salted data will go in.
	 * 
	 * The program automatically adds ".csv" to both file names.
	 */
	public void salter(int range, String oldName, String newName) throws IOException {
		Scanner scan = new Scanner(new File(oldName + ".csv"));
		FileWriter w = new FileWriter(newName + ".csv");
		PrintWriter pw = new PrintWriter(w);
		Random rng = new Random();
		while(scan.hasNextInt()) {
			pw.println(scan.nextInt() + (rng.nextInt((2*range)+1) - range));
		}
		pw.close();
		w.close();
		scan.close();
	}
	
	/*
	 * Smoothes a .csv file's points and makes a new .csv file with those values by taking
	 * the mean of nearby points to the left and right of each point (will keep the first
	 * and last points the same). Takes int scanRange, the range from which to check each
	 * point to smooth (higher numbers will result in fewer points at the beginning and end
	 * from being smoothed), the randString oldName, the name of the file to be smoothed,
	 * and newName, the name of the file that the smoothed data will go in.
	 * 
	 * The program automatically adds ".csv" to both file names.
	 * 
	 * Uses the mean method as a helper method.
	 */
	public void smoother(int scanRange, String oldName, String newName) throws IOException {
		Scanner scan = new Scanner(new File(oldName + ".csv"));
		ArrayList<Integer> data = new ArrayList<>();
		FileWriter w = new FileWriter(newName + ".csv");
		PrintWriter pw = new PrintWriter(w);
		while(scan.hasNextInt()) {
			data.add(scan.nextInt());		// transfer data from file to ArrayList
		}
		int size = data.size();
		int right;
		int left;
		ArrayList<Integer> smoothData;
		if(size % 2 == 1) {										// size of data is odd
			int mid = size/2;
			while(size-mid-1 < scanRange) {
				scanRange--;
			}
			smoothData = new ArrayList<>();
			for(int j = mid-scanRange; j <= mid+scanRange; j++) {		// smooth mid num
				if(j != mid) {
					smoothData.add(data.get(j));
				}
			}
			data.set(mid, mean(smoothData));
			right = mid+1;
			left = mid-1;
		} else {												// size of data is even
			right = size/2;
			left = right-1;
		}
		while(right < size-1) {		// size-1 to prevent from smoothing ends
			while(size-right-1 < scanRange) {
				scanRange--;
			}
			smoothData = new ArrayList<>();
			for(int j = left-scanRange; j <= left+scanRange; j++) {		// smooth left num
				if(j != left) {
					smoothData.add(data.get(j));
				}
			}
			data.set(left, mean(smoothData));
			smoothData = new ArrayList<>();
			for(int j = right-scanRange; j <= right+scanRange; j++) {	// smooth right num
				if(j != right) {
					smoothData.add(data.get(j));
				}
			}
			data.set(right, mean(smoothData));
			right++;
			left--;
		}
		for(int i = 0; i < size; i++) {
			pw.println(data.get(i));
		}
		pw.close();
		w.close();
		scan.close();
	}
	
	/*
	 * Find the mean of the given an ArrayList<Double> arr.
	 */
	private int mean(ArrayList<Integer> arr) {
		int sum = 0;
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			sum += arr.get(i);
		}
		return sum / size;
	}
	
}
