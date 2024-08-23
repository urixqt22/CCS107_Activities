package exercise1;

import java.util.Scanner; //import user input

public class PrelimExercise1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Create Scanner object
		boolean continueRunning = true; // argument that controls the loop

		while (continueRunning) {
			String input = getUserInput(scanner); // Get user input
			int[] vowelCounts = countVowels(input); // Calls the countVowels method, then Count vowels in the input
			int totalConsonant = countConsonants(input); // Calls the countConsonants method, then Count consonants in
															// the input
			displayTotalCounts(vowelCounts, totalConsonant); // Calling the method to display the vowel counts and total
																// consonants

			// Ask user if they want to continue
			System.out.print("Do you want to enter another string? (yes/no): "); // Prompt user
			String response = scanner.nextLine().toLowerCase(); // convert the user answer into lower case

			if (response.equals("no")) { // Check if user wants to stop
				continueRunning = false; // Exit the loop if user chooses not to continue
			}
		}

		System.out.println("Program has ended."); // Indicate the program has ended
		scanner.close(); // Close Scanner
	}

	// Get user input
	public static String getUserInput(Scanner scanner) {
		String input;

		// Loop until a valid input is provided
		do {
			System.out.print("Enter a string (max 20 characters): "); // Ask user
			input = scanner.nextLine(); // Read input

			if (input.length() > 20) { // Check if input exceeds 20 characters
				System.out.println("Input exceeds 20 characters. Please try again."); // Display error message
			}
		} while (input.length() > 20); // Repeat if input is invalid

		return input; // Return valid input
	}

	// Count vowels in the input string
	public static int[] countVowels(String input) {
		int[] counts = new int[5]; // Array to store counts for vowels 'a', 'e', 'i', 'o', 'u'
		input = input.toLowerCase(); // Convert the entire input to lowercase

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i); // Get the character at the current index
			switch (ch) {
			case 'a':
				counts[0]++;
				break;

			case 'e':
				counts[1]++;
				break;

			case 'i':
				counts[2]++;
				break;

			case 'o':
				counts[3]++;
				break;

			case 'u':
				counts[4]++;
				break;
			}
		}
		return counts; // Return the array containing vowel counts
	}

	// Count total consonants in the input string
	public static int countConsonants(String input) {
		int consonantCount = 0; // Variable to store the total number of consonants

		// Convert the entire input string to lowercase to handle case-insensitivity
		input = input.toLowerCase();

		// Array to store the vowel characters
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		// Iterate through each character in the input string
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i); // Get the character at the current index

			// Check if the character is a letter (between 'a' and 'z')
			if (ch >= 'a' && ch <= 'z') {
				boolean isVowel = false; // argument to check if the character is a vowel
  
				// Iterate through the array of vowel characters to see if the current character
				// is a vowel
				for (char vowel : vowels) {
					if (ch == vowel) {
						isVowel = true; // Set the argument to true if the character is a vowel
						break; // Exit the loop as we found the character in the vowels array
					}
				}

				// If the character is not a vowel, then it must be a consonant
				if (!isVowel) {
					consonantCount++; // Increment the consonant count
				}
			}
		}

		// Return the total count of consonants found in the input string
		return consonantCount;
	}

	// Display the counts of each vowel and total consonants
	public static void displayTotalCounts(int[] vowelCounts, int totalConsonants) {
		System.out.println("Vowel counts:"); // Print heading

		// Print the counts of each vowel
		System.out.println("a: " + vowelCounts[0]);
		System.out.println("e: " + vowelCounts[1]);
		System.out.println("i: " + vowelCounts[2]);
		System.out.println("o: " + vowelCounts[3]);
		System.out.println("u: " + vowelCounts[4]);

		// Print the total number of consonants
		System.out.println("Total consonants: " + totalConsonants);
	}
}

