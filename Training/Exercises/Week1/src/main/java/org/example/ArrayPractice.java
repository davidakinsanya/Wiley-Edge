package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

  public static void main(String[] args) {

    String[] names = {"Ian", "Jameson", "Anna", "Linda"};

/*     int arr[];
     Scanner x = new Scanner(System.in);
     System.out.println("Enter array size ...");
     int arrSize = x.nextInt();

     arr = new int[arrSize];
     for(int i = 0; i < arr.length; i++)
     {
         arr[i] = i*10; // Loads the array index at point i
         System.out.println(arr[i]); // Printing the individual array values
     }
     System.out.println(Arrays.toString(arr));*/


    /*
    String nameLookingFor = "Anna";
    System.out.println(Arrays.toString(names));
    names[0] = "John";
    System.out.println(Arrays.toString(names));
    for(int i = 0; i < names.length; i++)
    {
      //System.out.println(names[i]);
      if (names[i].equals(nameLookingFor))
      {
        System.out.println("Found at index " +i);
      }
    } */

    /*
     1. Declare an int array of 5 elements
     2. Find the average and sum of this array
     3. Using the names array, find the min and max length name(you CANNOT use Sorting!)
    */


    String min = names[0];
    String max = names[0];

    for (String name: names) {
      if (name.length() > max.length()) max = name;
      if (name.length() <= min.length()) min = name;
    }

    System.out.println(max + " " + min + "\n");

    int[] intArray = new int[5];
    int i = 0;
    int average = 0;
    int sum = 0;

    while (i != 5) {
      Scanner enterInt = new Scanner(System.in);
      System.out.print("Enter an integer: ");
      intArray[i] = enterInt.nextInt();
      i++;
    }

    for (int value : intArray) sum += value;
    average = sum / intArray.length;
    System.out.println(sum + " " + average);
  }

  int random = (int) (Math.random()*42)+1;
}
