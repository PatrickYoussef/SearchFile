package a4_comp249;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDictionaryCreator {

	public static void main(String[] args) {
		ArrayList<String> contains = new ArrayList<String>();
		Scanner key = new Scanner(System.in);
		String file = "", read = "";
		Scanner sc = null;
		PrintWriter pw = null;
		ArrayList<String> words = new ArrayList<String>();

		System.out.print("Enter the name of the file you want: ");
		file = key.nextLine();

		/**
		 * Opening the file so we can read it
		 */
		try {
			sc = new Scanner(new FileInputStream(file + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found. Program will terminate");
			System.exit(0);
		}

		/**
		 * Reading each word, putting them to capital letters, substring everything that
		 * has an "'", any char and adding the duplicated words in a new array
		 */
		while (sc.hasNext()) {
			read = sc.next();
			read = read.toUpperCase();
			if (read.contains(".") || read.contains("?") || read.contains("!") || read.contains(":")
					|| read.contains(";") || read.contains(","))
				read = read.substring(0, read.length() - 1);
			if (read.contains("’"))
				read = read.substring(0, read.indexOf("’"));

			if (words.contains(read))
				contains.add(read);

			words.add(read);

		}

		words.remove(" ");

		/**
		 * creating arraylists so every word that is one character or any word with a
		 * digit will be added in another array
		 */
		ArrayList<String> singleChar = new ArrayList<String>();
		ArrayList<String> digit = new ArrayList<String>();

		/**
		 * 
		 */
		for (String w : words) {

			if ((w.length() == 1) && !(w.equals("A")) && !(w.equals("I")))
				singleChar.add(w);

			for (int i = 0; i < w.length(); i++) {
				char ch = w.charAt(i);
				if (Character.isDigit(ch)) {
					digit.add(w);
					break;
				}
			}
		}

		/**
		 * Taking off each wrong word that we added in the arrays
		 */
		for (int i = 0; i < digit.size(); i++)
			words.remove(digit.get(i));
		for (int j = 0; j < singleChar.size(); j++)
			words.remove(singleChar.get(j));
		for (int k = 0; k < contains.size(); k++)
			words.remove(contains.get(k));

		/**
		 * Sorting the words in alphabetical number
		 */
		words.sort(null);

		/**
		 * Closing the files
		 */
		try {
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be found. Program will terminate");
			System.exit(0);
		}
		pw.println("The document produced this sub-dictionary, which includes " + words.size() + " entries.");
		pw.println();

		/**
		 * Printing each word in respect to their first letter using the static method
		 * below
		 */

		/*for (int i = 0; i < words.size(); i++) {
			if (words.get(i).trim().isEmpty())
				words.remove(i);
		}*/

		int ctr = 0;
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
			ctr++;
		}
		System.out.println(ctr);
		printing('A', pw, words);
		printing('B', pw, words);
		printing('C', pw, words);
		printing('D', pw, words);
		printing('E', pw, words);
		printing('F', pw, words);
		printing('G', pw, words);
		printing('H', pw, words);
		printing('I', pw, words);
		printing('J', pw, words);
		printing('K', pw, words);
		printing('L', pw, words);
		printing('M', pw, words);
		printing('N', pw, words);
		printing('O', pw, words);
		printing('P', pw, words);
		printing('Q', pw, words);
		printing('R', pw, words);
		printing('S', pw, words);
		printing('T', pw, words);
		printing('U', pw, words);
		printing('V', pw, words);
		printing('Y', pw, words);
		printing('X', pw, words);
		printing('Y', pw, words);
		printing('Z', pw, words);

		pw.close();
		sc.close();
		key.close();

	}

	/**
	 * Printing the words with each letter in respect to them
	 * 
	 * @param letter
	 * @param pw     printwriter
	 * @param words  array of words
	 */
	public static void printing(char letter, PrintWriter pw, ArrayList<String> words) {
		pw.println(letter);
		pw.println("==");
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).charAt(0) == letter)
				pw.println(words.get(i));
		}

		pw.println();

	}

}
