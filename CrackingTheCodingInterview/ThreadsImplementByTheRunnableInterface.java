public class ThreadsImplementByTheRunnableInterface{
    public static void main(String[] args){
        RunnableTread threadInstance = new RunnableTread(); //创建thread object.
        Thread thread = new Thread(threadInstance);
        thread.start();

        while (threadInstance.count != 5){
            try{
                Thread.sleep(250);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

 class RunnableTread implements Runnable{
    public int count = 0;

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