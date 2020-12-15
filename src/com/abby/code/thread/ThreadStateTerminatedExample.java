package com.abby.code.thread;

/**
 * @author wxmylife
 */
public class ThreadStateTerminatedExample {

  public static void main(String[] args) {
    Runnable runnable = () -> {
      System.out.println("随便执行，线程状态变为Terminated");
    };
    Thread thread = new Thread(runnable);
    thread.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("线程状态：" + thread.getState().toString());
    System.exit(1);
  }
}
