package ex2;

public class thread {

    // contador compartilhado sem protecao
    static int count = 0;

    public static void main(String[] args) throws Exception {
        int T = 8;
        int M = 250000;
        Thread[] threads = new Thread[T];

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < T; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < M; j++) {
                    count = count + 1; // condicao de corrida
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < T; i++) {
            threads[i].join();
        }

        long fim = System.currentTimeMillis();

        System.out.println("modo: sem sincronizacao (corrida)");
        System.out.println("valor esperado: " + (T * M));
        System.out.println("valor obtido:   " + count);
        System.out.println("tempo gasto:    " + (fim - inicio) + " ms");
    }
}