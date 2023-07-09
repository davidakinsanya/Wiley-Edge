package org.example;
import java.util.Scanner;

public class MovieGame {
  public static void main(String[] args) {
    Scanner scanStr = new Scanner(System.in), scanInt = new Scanner(System.in);
    int age = 0, ageCheck = 0;
    String name;
    final int year2005 = 2005;
    final int year1995 = 1995;
    final int year1985 = 1985;
    final int year1975 = 1975;
    final int year1965 = 1965;

    System.out.print("Hi, let's play a game. What is your name?: ");
    name = scanStr.next();

    System.out.print("Okay " + name + ", What year where you born?: ");
    age = scanInt.nextInt();
    ageCheck =  Integer.toString(age).split("").length;

    if (ageCheck != 4) {
      System.out.println("your age is not valid buddy!");
    } else {
      if (age < year2005) {
        System.out.println("Did you know the movie 'Up' came out over a decade ago.");
      } if (age < year1995) {
        System.out.println("...And the first Harry Potter came out over 15 years ago!");
      } if (age < year1985) {
        System.out.println("...Also Space Jam came out not last decade, but the one before THAT.");
      } if (age < year1975) {
        System.out.println("The original Jurassic Park release is closer to the first lunar landing than it is to today.");
      } if (age < year1965) {
        System.out.println("The MASH TV series has been around for almost half a century!");
      } // End of if-else
    }
  }
}