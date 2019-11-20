package org.kd.jfugeexamples;

public class Worker implements Runnable
{
    public static void main (String[] args)
    {
        System.out.println("This is currently running on the main thread, " +
                "the id is: " + Thread.currentThread().getId());
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();

        Thread fugue = new Thread(new Typing());
        fugue.start();
    }

    public void run()
    {
        int cnt = 50;
        while (cnt > 0) {
            System.out.println("This is currently running on a separate thread, " +
                    "the id is: " + Thread.currentThread().getId());

            cnt --;
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){

            }
        }
    }
}