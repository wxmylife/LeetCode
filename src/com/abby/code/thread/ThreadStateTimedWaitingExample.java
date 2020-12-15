package com.abby.code.thread;

/**
 * @author wxmylife
 */
public class ThreadStateTimedWaitingExample {

  private static final Object LOCKER = new Object();

  public static void main(String[] args) {

    Runnable waiting = () -> {
      System.out.println("whoWillWait 开始等待 2秒钟");
      waiting();
      System.out.println("whoWillWait 等待转台结束");
    };
    Thread thread = new Thread(waiting);
    thread.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("whoWillWait当前的线程状态：" + thread.getState().toString());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("whoWillWait当前的线程状态：" + thread.getState().toString());
    System.exit(1);

  }

  private static void waiting() {
    synchronized (LOCKER) {
      try {
        LOCKER.wait(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
