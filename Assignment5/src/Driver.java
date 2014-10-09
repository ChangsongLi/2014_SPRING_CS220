/**
 * This program is to check the user's input string whether it is a palindrome
 * by ignoring the case of the letters and punctuation marks. Then it prints the
 * string and the result from the non-recursive method and the recursive method.
 * 
 * Apr 11 2014
 * 
 * @ Changsong Li
 * 
 */

public class Driver {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			new Driver(args[i]);
		}
	}

	public Driver(String s) {

		System.out.println("the input string is " + s);
		System.out.println("the result from the recursive method is "
				+ recurPalCheck2(s));
		System.out.println("the result from non-recursive method is "
				+ loopPalCheck(s));
		System.out.println();
	}

	public boolean recurPalCheck(String s) {

		String sNew = "";
		char first, last;
		int length;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				sNew = sNew + s.charAt(i);
			}
		}

		if (s.length() <= 1) {
			return true;
		}

		length = sNew.length();
		first = sNew.charAt(0);
		last = sNew.charAt(length - 1);

		if (Character.toUpperCase(first) == Character.toUpperCase(last)) {
			return recurPalCheck(sNew.substring(1, length - 1));
		}

		return false;

	}

	public boolean recurPalCheck2(String s) {

		if (s.length() <= 1) {
			return true;
		}

		int first = 0, last = s.length() - 1;

		while (!Character.isLetter(s.charAt(first))) {
			first++;

			if (first == s.length())
				return true;

		}

		while (!Character.isLetter(s.charAt(last))) {
			last--;
		}

		if (first == last)
			return true;

		if (Character.toUpperCase(s.charAt(first)) == Character.toUpperCase(s
				.charAt(last)))
			return recurPalCheck2(s.substring(first + 1, last));

		return false;

	}

	public boolean loopPalCheck(String s) {
		String noPun = "";

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				noPun = noPun + Character.toUpperCase(s.charAt(i));
			}
		}

		for (int i = 0; i < noPun.length() / 2; i++) {
			if (noPun.charAt(i) != noPun.charAt(noPun.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}
}
