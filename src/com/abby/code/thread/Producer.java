package com.abby.code.thread;

import java.util.concurrent.BlockingDeque;

/**
 * @author wxmylife
 */
public class Producer implements Runnable {

  protected BlockingDeque<Object> queue;

  public Producer(BlockingDeque<Object> queue) {
    this.queue = queue;
  }

  @Override public void run() {
    try {
      while (true) {
        Object justProduced = getResource();
        queue.put(justProduced);
        System.out.println("生产者资源队列大小= " + queue.size());
      }

    } catch (InterruptedException e) {
      System.out.println("生产者 中断");
    }
  }

  Object getResource() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("生产者 读 中断");
    }
    return new Object();
  }

}
