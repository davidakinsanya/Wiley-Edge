package org.example;

public class SummativeSums {
  public static int sumOfArray(int[] arr) {
    int count = 0;
    for (int i : arr) { count += i; }
    return count;
  } // End of method

  public static void main(String[] args) {
    int[] arrayOne = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
    int[] arrayTwo = { 999, -60, -77, 14, 160, 301 };
    int[] arrayThree = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99 };

    System.out.println("1. " + sumOfArray(arrayOne) +
            "\n2. " + sumOfArray(arrayTwo) +
            "\n3. " + sumOfArray(arrayThree));
  } // End of main
} // End of class
