package com.abby.code.thread;

import java.util.concurrent.BlockingDeque;

/**
 * @author wxmylife
 */
public class Consumer implements Runnable {

  protected BlockingDeque<Object> queue;

  public Consumer(BlockingDeque<Object> queue) {
    this.queue = queue;
  }

  @Override public void run() {
    try {
      while (true) {
        Object obj = queue.take();
        System.out.println("消费者 资源 队列大小 " + queue.size());
        take(obj);
      }
    } catch (InterruptedException e) {
      System.out.println("消费者 中断");
    }
  }

  void take(Object obj) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("消费者 读 中断");
    }
    System.out.println("消费对象 " + obj);
  }
}
