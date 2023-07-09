package com.sg.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

  @Override
  public void print(String msg) {
    System.out.println(msg);
  }

  @Override
  public double readDouble(String prompt, double min, double max) {
    return 0;
  }

  @Override
  public float readFloat(String prompt, float min, float max) {
    return 0;
  }

  @Override
  public int readInt(String prompt) {
    return 0;
  }

  @Override
  public int readInt(String prompt, int min, int max) {
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    int num = sc.nextInt();
    if (num >= min || num <= max) {
      return num;
    }
    return -1;
  }

  @Override
  public long readLong(String prompt) {
    return 0;
  }

  @Override
  public long readLong(String prompt, long min, long max) {
    return 0;
  }

  @Override
  public String readString(String prompt) {
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    return sc.nextLine();
  }
}
