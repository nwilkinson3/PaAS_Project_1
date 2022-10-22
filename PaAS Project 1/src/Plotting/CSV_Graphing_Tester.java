package Plotting;

import java.io.IOException;

public class CSV_Graphing_Tester {
	
	public static void main(String[] args) throws IOException {
		
		CSV_Graphing test = new CSV_Graphing();
		
		test.plotter(0, 25, 3, 2, "P1");
		test.salter(3, "P1", "S1");
		test.smoother(2, "S1", "O1");
		
		test.plotter(-20, 300, 2, 5, "P2");
		test.salter(3, "P2", "S2");
		test.smoother(2, "S2", "O2");
		
		test.plotter(-456, 0, 1, 4, "P3");
		test.salter(3, "P3", "S3");
		test.smoother(2, "S3", "O3");
		
		test.plotter(-456, 456, 4, 10, "P4");
		test.salter(3, "P4", "S4");
		test.smoother(2, "S4", "O4");
		
		test.plotter(-500, 1000, 2, 20, "P5");
		test.salter(3, "P5", "S5");
		test.smoother(2, "S5", "O5");
		
		test.plotter(-2, 853, 3, 50, "P6");
		test.salter(3, "P6", "S6");
		test.smoother(2, "S6", "O6");
		
	}
	
}
