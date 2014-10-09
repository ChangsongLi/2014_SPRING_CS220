/**
 * This program is to get the Currency and amount US dollar they want to exchange
 * from the user. Then, the program will print out how much that type currency they 
 * can exchange by those US dollars.
 * 
 * Last date edit: Mar 14th
 * 
 *  @ changsong Li
 * 
 */

import java.util.Scanner;
import java.io.*;

public class Currency {
	public static void main(String[] args) {
		new Currency(args[0]);
	}

	@SuppressWarnings("resource")
	public Currency(String s) {
		try {
			System.out
					.println("Please enter the currency you would like to change your US Dollar to");
			Scanner scan = new Scanner(System.in);
			String country = scan.nextLine();
			BufferedReader read = new BufferedReader(new FileReader(s));
			String line = read.readLine();
			double rate = 0;
			int check = 0;
			while (line != null) {
				Scanner scanC = new Scanner(line);
				String findCountry = scanC.next();
				if (findCountry.equals(country)) {
					rate = scanC.nextDouble();
					check = 1;
				}
				line = read.readLine();
			}
			if (check == 0) {
				System.out.println("Invalid Input");
			} else {
				System.out
						.println("Please enter the US Dollar amount you would like to change");
				if(scan.hasNextDouble()){
					double mount = scan.nextDouble();
					double total = mount * rate;
					System.out.println("\nThe US Dollar " + mount + " is the "
							+ country + " amount " + total);
				}
				else if(scan.hasNext()){
					System.out.println("Invalid input.");
				}
			}

		} catch (IOException e) {
			System.out.println("IOException");
		}

	}
}
