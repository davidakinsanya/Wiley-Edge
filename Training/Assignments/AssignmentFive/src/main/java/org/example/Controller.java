package org.example;

import org.example.dao.VendingView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * This class kicks of the vending machine now implementing DI.
 *
 * @author david
 */
public class Controller {

  public static void main(String[] args) {
    try {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      VendingView view = applicationContext.getBean("view", VendingView.class);
      view.run();
    } catch (IOException e) {
      System.out.println(-1);
    }
  }
}