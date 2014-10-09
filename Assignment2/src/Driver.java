/**
 * This program is to get the names from user and check the names whether is valid 
 * If they are valid, print the names. If they are not, print the error message.
 * 
 * Last date edit: Feb 22th
 * 
 *  @ changsong Li
 * 
 */

import java.util.Scanner;

public class Driver {

	/*
	 * main method, the program starts doing things from here.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			System.out.print("Type your name: ");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			Scanner scan2 = new Scanner(name);
			String firstName = "";
			String lastName = "";
			if (scan2.hasNext()) {
				firstName = scan2.next();
				if (firstName.length() < 2)
					throw new NameException(
							"Less than two characters in FirstNames.");
				for (int i = 0; i < firstName.length(); i++) {
					if (!Character.isLetter(firstName.charAt(i))) {
						throw new NameException("The first name (" + firstName
								+ ") has Non-alphabetic characters.");
					}
				}

				if (scan2.hasNext()) {
					lastName = scan2.next();
					if (lastName.length() < 2)
						throw new NameException(
								"Less than two characters in LastNames.");
					for (int i = 0; i < lastName.length(); i++) {
						if (!Character.isLetter(lastName.charAt(i))) {
							throw new NameException("The last name ("
									+ lastName
									+ ") has Non-alphabetic characters.");
						}
					}
				} else {
					throw new NameException(
							"No blanks between names firstName and lastName.");
				}

				System.out.println(firstName + " " + lastName);

			}

		} catch (NameException e) {
			System.out.println(e.getMessage());

		}

	}
}
