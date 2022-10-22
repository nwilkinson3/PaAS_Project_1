package FishMarket;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FishMarket {
	
	private ArrayList<Seafood> stock;
	private int probFish;
	private int probShrimp;
	private int probScallop;
	private Random rng;
	private FileWriter writer;
	private File excel;
	
	/*
	 * Constructor for FishMarket. Inputs for the rate at which fish, shrimp, and scallop
	 * are caught. The rate of crab catches is not required, since the values should add
	 * up to 100 and can be determines without the rate at which crabs are caught.
	 */
	FishMarket(int fishRate, int shrimpRate, int scallopRate) throws IOException{	//Do not need crab
		probFish = fishRate;
		probShrimp = probFish + shrimpRate;
		probScallop = probShrimp + scallopRate;
		rng = new Random();
	}
	
	/*
	 * Helper method that generates a number of Seafood based on the input variable count,
	 * as well as adding them to stock. Overrides the previous stock.
	 */
	private void genCatch(int count) {
		stock = new ArrayList<Seafood>();
		int rNum = 0;
		for(int i = 0; i < count; i++) {
			rNum = rng.nextInt(100);
			if(rNum < probFish) {
				stock.add(new Fish());
			} else if(rNum < probShrimp) {
				stock.add(new Shrimp());
			} else if(rNum < probScallop) {
				stock.add(new Scallop());
			} else {
				stock.add(new Crab());
			}
		}
	}
	
	/*
	 * Helper method that creates a .csv file containing all of the Seafood in stock called
	 * "FishMarket.csv". Overrides the previous .csv file.
	 */
	private void excel() throws IOException {
		excel = new File("FishMarket.csv");
		writer = new FileWriter(excel);
		writer.write("ID, Type, Weight, Price");
		for(int i = 0; i < stock.size(); i++) {
			Seafood x = stock.get(i);
			writer.write("\n" + i + ", " + x.getType() + ", " + x.getWeight() + ", $" + x.getPrice());
		}
		writer.close();
	}
	
	/*
	 * Generates a new stock and then creates a .csv file.
	 * 
	 * Uses the genCatch and excel methods as helper methods.
	 */
	public void genMarket(int count) throws IOException {
		genCatch(count);
		excel();
	}
	
}
