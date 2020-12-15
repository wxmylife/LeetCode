package com.abby.code.thread;

import sun.tools.jconsole.Worker;

/**
 * @author wxmylife
 */
public class ThreadStateWaitingExample {
  private static final Object LOCKER = new Object();

  public static void main(String[] args) {
    Runnable waiting = () -> {
      System.out.println("WhoWillWait 开始等待 whoWillNotify");
      waiting();
      System.out.println("WhoWillWait 等到了 whoWillNotify");
    };
    Thread whoWillWait=new Thread(waiting);
    whoWillWait.start();
    try {
      Thread.sleep(2000);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("whoWillWait当前的线程状态：" + whoWillWait.getState().toString());


    Runnable notify=()->{
      System.out.println("whoWillNotify 准备通知 whoWillWait");
      notifying();
    };

    Thread whoWillNotify=new Thread(notify);
    whoWillNotify.start();
    try {
      Thread.sleep(2000);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("唤醒后，whoWillWait当前的线程状态=" + whoWillWait.getState().toString());
    System.exit(1);
  }

  private static void waiting() {
    synchronized (LOCKER) {
      try {
        LOCKER.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static void notifying() {
    synchronized (LOCKER) {
      LOCKER.notify();
      System.out.println("WhoWillWait 已经通知，即将离开同步代码块");
    }
  }
}
