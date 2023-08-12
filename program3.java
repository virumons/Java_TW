package practices.oop;

import java.io.*;

public class program3 {
	public static void main(String[] args) {
		createFile();
		parseFile();
	}

	static void createFile() {
		try {
			FileWriter writer = new FileWriter("letters.txt");
			writer.write("abcdefghijklmnopqrstuvwxyz");
			writer.close();
			System.out.println("File 'alphabets.txt' has been created successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file.");
			e.printStackTrace();
		}
	}

	static void parseFile() {
		try {
			FileReader reader = new FileReader("letters.txt");
			FileWriter consonantsWriter = new FileWriter("cons.txt");
			FileWriter vowelsWriter = new FileWriter("vowels.txt");

			int character;
			while ((character = reader.read()) != -1) {
				if (Character.isDigit(character)) 
				{
					throw new NumberFormatException("Numbers are not allowed in the file.");
				} 
				else if ("aeiou".contains(Character.toString((char) character)))
				{
					vowelsWriter.write(character);
				} 
				else 
				{
					consonantsWriter.write(character);
				}
			}

			reader.close();
			consonantsWriter.close();
			vowelsWriter.close();
			System.out.println("The file 'alphabets.txt' has been parsed successfully.");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An error occurred while reading or writing to the file.");
			e.printStackTrace();
		}
	}
}