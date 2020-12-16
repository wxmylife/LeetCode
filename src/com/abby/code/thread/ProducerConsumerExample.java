package com.abby.code.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wxmylife
 */
public class ProducerConsumerExample {

  public static void main(String[] args) throws InterruptedException {

    int numProducers = 4;
    int numConsumers = 3;

    BlockingDeque<Object> myQueue = new LinkedBlockingDeque<>(5);

    for (int i = 0; i < numProducers; i++) {
      new Thread(new Producer(myQueue)).start();
    }

    for (int i = 0; i < numConsumers; i++) {
      new Thread(new Consumer(myQueue)).start();
    }

    Thread.sleep(1000);
    System.exit(0);

  }
}
