
/*
 * Andrew Calabro-Cavin
 * Application to translate a sentence to Pig Latin
 * Take user input
 * call a method to locate index of first vowel
 * call a method to collect parts of words, rearrange, add ending 
 */

import java.util.Scanner;

public class PigLatinSentence {

	public static void main(String[] args) {

		System.out.println("Welcome to the Pig Latin Translator!\n");

		Scanner scan = new Scanner(System.in);
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) { // as long as cont is y or Y, will exec. at least once

			System.out.println("Please enter a sentence to translate: ");
			String inputLine = scan.nextLine();

			String inputLineLC = inputLine.toLowerCase(); // First convert input word to lower case

			String[] inputWords = inputLineLC.split(" ");

			int length = inputWords.length; // length of the array, number of words

			System.out.println("\nTranslation: ");
			// use a for loop to do operation for each word
			// convert each word to StringBuffer
			// call method to find vowel
			// call method to return pig latin
			// print word plus space
			// loop

			for (int i = 0; i < inputWords.length; ++i) {

				StringBuffer buffWord = new StringBuffer(inputWords[i]);
				int vowelIndex = findVowelIndex(buffWord); // call method, store index of vowel
				System.out.print(makePigLatin(buffWord, vowelIndex) + " "); // pass index and buffWord to method, return
																			// pig latin word
			}

			System.out.println("\n\nDo you want to continue? (y/n)");
			cont = scan.nextLine();

		}

		// let the user know the program has closed
		System.out.println("Goodbye!");

		scan.close();

	}

	// method to find the index location of the first vowel, return the index int
	public static int findVowelIndex(StringBuffer buffWord) {

		int i = 0;
		while (i < buffWord.length()) {  // Question: This didn't work with for loop, for words like "goodness" - prob with two vowels?
			if (buffWord.charAt(i) == 'a') {
				break;
			}
			if (buffWord.charAt(i) == 'e') {
				break;
			}
			if (buffWord.charAt(i) == 'i') {
				break;
			}
			if (buffWord.charAt(i) == 'o') {
				break;
			}
			if (buffWord.charAt(i) == 'u') {
				break;
			}
			++i;
		}
		return i;
	}

	// method, take in buffWord and index of vowel, return pig latin as string
	public static String makePigLatin(StringBuffer buffWord, int vowelIndex) {

		String pigLatin;
		if (vowelIndex == 0) { // if the first letter is a vowel
			pigLatin = buffWord + "way";
		} else {
			String firstPart = buffWord.substring(0, vowelIndex);
			String lastPart = buffWord.substring(vowelIndex, buffWord.length());
			pigLatin = lastPart + firstPart + "ay";
		}
		return pigLatin;

	}

}
