package threads;

import java.util.concurrent.Semaphore;

public class Semaphore1 implements Runnable{
    int i=0;

    Semaphore semaphore=new Semaphore(0);
    Semaphore semaphore1=new Semaphore(0);

    Semaphore semaphore2=new Semaphore(0);

    @Override
    public void run() {
        Thread thread1=new Thread(new PringNumeric());
        Thread thread2=new Thread(new PringCapital());
        Thread thread3=new Thread(new PringSmall());
        try {
            semaphore.acquire(0);
            thread1.start();
            semaphore.release(0);
            semaphore1.acquire(0);
            thread2.start();
            semaphore1.release(0);
            semaphore2.acquire(0);
            thread3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
            semaphore1.release();

            semaphore2.release();

        }


        Runnable runnable=new Thread(new PringNumeric());


    }

public static void main(String[] asd){
    Semaphore1 semaphore=new Semaphore1();
    Thread thread1=new Thread(new Semaphore1());
    thread1.start();


}
    class PringNumeric implements Runnable{


        public int getNumber() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();

            }

            System.out.println("PringNumeric");

            return i++;
        }

        @Override
        public void run() {

                getNumber();

        }
    }

    class PringCapital implements Runnable{

        public String getCapital() throws InterruptedException {
            semaphore.acquire();

            System.out.println("PringCapital");
            return "A";
        }

        @Override
        public void run() {
            try {
                getCapital();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();

            }
        }
    }

    class PringSmall implements Runnable{
        public String getSmall() throws InterruptedException {

            semaphore.acquire();

            System.out.println("PringSmall");

            return "a";
        }

        @Override
        public void run() {
            try {
                getSmall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }



}
