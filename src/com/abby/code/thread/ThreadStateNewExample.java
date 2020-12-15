package com.abby.code.thread;

/**
 * @author wxmylife
 */
public class ThreadStateNewExample {
  private static final Object WAITER = new Object();

  public static void main(String[] args) {
    Runnable waiting = new Runnable() {
      @Override public void run() {
        try {
          WAITER.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    Thread whoWillWait = new Thread(waiting);
    System.out.print(whoWillWait.getState().toString());
  }
}
