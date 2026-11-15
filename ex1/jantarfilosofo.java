package ex1;

public class jantarfilosofo {

    // vetor simples: false = garfo livre na mesa, true = garfo ocupado na mao de
    // alguem
    static boolean[] garfoOcupado = new boolean[5];

    public static void main(String[] args) {

        // mude para false se quiser ver o deadlock (todo mundo travado)
        // mude para true se quiser ver funcionando sem travar (hierarquia)
        boolean deadlock = true;

        for (int i = 0; i < 5; i++) {
            int id = i;
            thread t = new thread(id, deadlock);
            t.start();
        }
    }
}
