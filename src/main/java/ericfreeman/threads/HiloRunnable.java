package ericfreeman.threads;

public class HiloRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("HiloRunnable " + Thread.currentThread().getName() + " is running" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error al sleep");
            }
        }
    }
    public static void main(String[] args) {
        HiloRunnable hiloRunnable1 = new HiloRunnable();
        HiloRunnable hiloRunnable2 = new HiloRunnable();
        Thread hiloThread1 = new Thread(hiloRunnable1);
        Thread hiloThread2 = new Thread(hiloRunnable2);
        hiloThread1.start();
        hiloThread2.start();

    }
}
