public class ThreadImplementByExtendingThread{
    public static void main(String[] args){
        ThreadExample thread = new ThreadExample();
        thread.start();

        while (thread.count != 5){
            try{
                Thread.sleep(250);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class ThreadExample extends Thread{
    int count = 0;
    public void run(){
        System.out.println("Runnable thread starting...");

        try {
            int count = 0; 
            while (count < 5){
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e){
            System.out.println("Runnable thread interrupted...");
        }
        System.out.println("Runnable thread terminating...");
    }
}