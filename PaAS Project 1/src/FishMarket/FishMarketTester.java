package FishMarket;

import java.io.IOException;

public class FishMarketTester {
	
	/*
	 * Tester method for FishMarket.
	 */
	public static void main(String[] args) throws IOException {
		
		FishMarket test = new FishMarket(40, 20, 15);
		test.genMarket(300);
		
	}
	
}
