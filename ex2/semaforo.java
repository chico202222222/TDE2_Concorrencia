package ex2;

import java.util.concurrent.Semaphore;

public class semaforo {

    static int count = 0;
    // semaforo binario com fila justa (algortimo fifo)
    static Semaphore sem = new Semaphore(1, true);

    public static void main(String[] args) throws Exception {
        int T = 8;
        int M = 250000;
        Thread[] threads = new Thread[T];

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < T; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < M; j++) {
                    try {
                        sem.acquire();
                        count = count + 1;
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        sem.release();
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < T; i++) {
            threads[i].join();
        }

        long fim = System.currentTimeMillis();

        System.out.println("modo: com semaforo (correto)");
        System.out.println("valor esperado: " + (T * M));
        System.out.println("valor obtido:   " + count);
        System.out.println("tempo gasto:    " + (fim - inicio) + " ms");
    }
}