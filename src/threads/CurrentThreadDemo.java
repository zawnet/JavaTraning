package threads;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Aktywny wątek: "+t);

        //Change name of thread
        t.setName("My thread");
        System.out.println("Po zmianie nazwy: "+t);
        try {
        for(int n = 5; n > 0; n--){
            System.out.println(n);
            Thread.sleep(1000);
        }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
