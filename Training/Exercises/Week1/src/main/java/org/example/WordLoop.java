package org.example;
import java.util.Scanner;

public class WordLoop {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word;
    StringBuilder palindromeTest = new StringBuilder();
    System.out.print("Give me a word please: ");
    word = scanner.next().toLowerCase();

    String vowels = "aeiou";
    double count = 0;

    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      if (vowels.contains(Character.toString(letter))) count++;
    }
    double percentage = count / word.length() * 100;
    System.out.println(percentage + "% of characters in " + word + "are vowels");

    for (int i = word.length()-1; i >= 0; i--) {
      palindromeTest.append(word.charAt(i));
    }

    if (word.equals(palindromeTest.toString())) {
      System.out.println(word + " Is a palindrome by the way...");
    }
  }
}


