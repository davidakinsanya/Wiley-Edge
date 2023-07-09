package org.example;

import java.util.Scanner;

public class HealthyHearts {

  public static void main(String[] args) {
    int age;
    int maxHeartRate;
    double minBPM;
    double maxBPM;

    Scanner getAge = new Scanner(System.in);

    System.out.print("Enter your age: ");
    age = getAge.nextInt();

    maxHeartRate = 220 - age;
    minBPM = maxHeartRate * 0.5; // 50% of maxHeartRate
    maxBPM = maxHeartRate * 0.85; // 75% of maxHeartRate

    System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
    System.out.println("Your target HR zone should be " + Math.round(minBPM) +  " - " +  Math.round(maxBPM) + " beats per minute");
  }
}
