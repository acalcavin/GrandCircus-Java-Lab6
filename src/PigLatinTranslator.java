
/*
 * Andrew Calabro-Cavin
 * Application to translate a word to Pig Latin
 * Take user input
 * call a method to locate index of first vowel
 * call a method to collect parts of words, rearrange, add ending 
 */

import java.util.Scanner;

public class PigLatinTranslator {

	public static void main(String[] args) {

		System.out.println("Welcome to the Pig Latin Translator!\n");

		Scanner scan = new Scanner(System.in);
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) { // as long as cont is y or Y, will exec. at least once

			System.out.println("Please enter a word to translate: ");
			String inputWord = scan.nextLine();

			String inputWordLC = inputWord.toLowerCase(); // First convert input word to lower case

			StringBuffer buffWord = new StringBuffer(inputWordLC); // convert string to StringBuffer

			int vowelIndex = findVowelIndex(buffWord); // call method, store index of vowel
			
			System.out.println("Translation: "+ makePigLatin(buffWord, vowelIndex)); // pass index and buffWord to method, return pig latin

			System.out.println("Do you want to continue? (y/n)");
			cont = scan.nextLine();

		}

		// let the user know the program has closed
		System.out.println("Goodbye!");

		scan.close();

	}

	// method to find the index location of the first vowel, return the index int
	public static int findVowelIndex(StringBuffer buffWord) {

		int i;
		for (i = 0; i <= buffWord.length(); ++i) {
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
		}
		return i;
	}

	// method, take in buffWord and index of vowel, return pig latin as string
	public static String makePigLatin(StringBuffer buffWord, int vowelIndex) {

		String pigLatin;
		if (vowelIndex == 0) {  // if the first letter is a vowel
			pigLatin = buffWord + "way";		
		} else {
			String firstPart = buffWord.substring(0, vowelIndex);
			String lastPart = buffWord.substring(vowelIndex, buffWord.length());
			pigLatin = lastPart + firstPart + "ay";
		}
		return pigLatin;

	}

}
