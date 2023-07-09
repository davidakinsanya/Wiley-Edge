package org.example;

import org.example.dao.VendingView;

import java.io.IOException;

public class Controller {
  public static void main(String[] args) {
    try {
      VendingView view = new VendingView();
      view.run();
    } catch (IOException e) {
      System.out.println(-1);
    }
  }
}