package com.abby.code.thread;

/**
 * @author wxmylife
 */
public class ThreadStateRunnableExample {
  private static boolean flag = true;

  public static void main(String[] args) {
    Runnable waiting = () -> {
      do {
      } while (flag);
    };
    Thread thread = new Thread(waiting);
    thread.start();
    try {
      Thread.sleep(5000);
      System.out.printf(thread.getState().toString());
      flag = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.exit(1);
  }
}
