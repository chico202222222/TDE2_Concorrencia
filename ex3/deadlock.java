package ex3;

import java.util.concurrent.locks.ReentrantLock;

public class deadlock {

    static ReentrantLock lockA = new ReentrantLock();
    static ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) {

        // mude p false se quiser ver o programa travar no deadlock
        // mude p true se quiser ver funcionando com hierarquia
        boolean hierarquia = false;

        thread t1 = new thread(1, hierarquia);
        thread t2 = new thread(2, hierarquia);

        t1.start();
        t2.start();
    }
}
