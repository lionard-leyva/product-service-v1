package ericfreeman.threads;

public class HiloThread extends Thread {

    public void run() {
       for(int i = 0; i < 5; i++) {
           System.out.println("HiloThread " + Thread.currentThread().getName() + " is running" + i);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
                System.out.println("Error al sleep");
           }
       }
    }

    public static void main(String[] args) {
        HiloThread hiloThread = new HiloThread();
        HiloThread hiloThread2 = new HiloThread();
        hiloThread.start();
        hiloThread2.start();
    }


}
