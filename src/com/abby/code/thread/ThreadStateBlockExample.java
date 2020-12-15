package com.abby.code.thread;

/**
 * @author wxmylife
 */
public class ThreadStateBlockExample {

  private static boolean LOCK_FLAG = true;

  public static void main(String[] args) {
    Runnable locker=ThreadStateBlockExample::locker;

    Thread whoWillLockOthers=new Thread(locker);
    whoWillLockOthers.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Thread whoWillBeLocked=new Thread(locker);
    whoWillBeLocked.start();
    try {
      Thread.sleep(3000);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.printf("WhoWillBeLocked status="+whoWillBeLocked.getState().toString());
    System.exit(1);
  }

  private static synchronized void locker(){
    do {

    }while (LOCK_FLAG);
  }
}
