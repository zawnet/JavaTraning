package threads;

class NewThread implements  Runnable{

    Thread t;
    public NewThread(){
        //Utworzenie nowego, durgiedo wątku
        t = new Thread(this, "Sample thread");
        System.out.println("Child thread: "+ t);
    }

    @Override
    public void run() {
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Child thread: "+ i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println("thread interrupted");
        }

        System.out.println("Exit form child thread");
    }
}

public class ThreadDemo{
    public static void main(String[] args) {
        NewThread nt = new NewThread();
        nt.t.start();

        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Main thread: "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Exit form main thread");
    }
}
