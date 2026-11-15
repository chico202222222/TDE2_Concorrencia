package ex1;

// extende a Thread nativa do java, p poder configurar as threads do meu programa manualmente (adicionar deadlock e id etc)
// herdando de java.lang.Thread e sobrescrever run(), cada instancia de "thread" ja e uma thread propria
// e pode ser iniciada direto com t.start() no Problema1.java, sem precisar implementar Runnable e passar para um new Thread(...).
// como esta classe nao precisa herdar de nenhuma outra classe pai, extends Thread deixa o codigo mais direto para este exercicio.
// fontes:
// - Stack Overflow: https://stackoverflow.com/questions/2782744/implementing-runnable-vs-extending-thread
// - Baeldung: https://www.baeldung.com/java-runnable-vs-extending-thread
// - GeeksforGeeks: https://www.geeksforgeeks.org/java/implement-runnable-vs-extend-thread-in-java/
public class thread extends Thread {

    int id;
    boolean deadlock;

    public thread(int id, boolean deadlock) {
        this.id = id;
        this.deadlock = deadlock;
    }

    @Override
    public void run() {
        // define qual eh o garfo da esquerda e o da direita na mesa redonda
        // o % 5 faz a volta na mesa (entao a direita do filosofo 4 volta a ser o garfo
        // 0)
        int esq = id;
        int dir = (id + 1) % 5;

        int primeiroGarfo;
        int segundoGarfo;

        if (deadlock) {
            // eu fiz aqui pra ele saqual eh o menor garfo e qual eh o maior
            primeiroGarfo = Math.min(esq, dir);
            segundoGarfo = Math.max(esq, dir);
        } else {
            // jeito ingenuo: todo mundo pega o da esquerda primeiro e depois o da direita
            // se todos pegarem o da esquerda juntos, ninguem solta e o programa trava
            // (deadlock)
            primeiroGarfo = esq;
            segundoGarfo = dir;
        }

        try {
            while (true) {
                System.out.println("filosofo " + id + " esta pensando");
                Thread.sleep(1000); // pode alterar o valor se quiser testar pensando por amis tempo ou sla

                System.out.println("filosofo " + id + " esta com fome");

                while (jantarfilosofo.garfoOcupado[primeiroGarfo]) {
                    Thread.sleep(10); // p n ficar batendo, esperar 10ms é mais seguro
                }
                // achou livre! marca como true pra avisar que pegou o primeiro garfo
                jantarfilosofo.garfoOcupado[primeiroGarfo] = true;
                Thread.sleep(100);
                while (jantarfilosofo.garfoOcupado[segundoGarfo]) {
                    Thread.sleep(10);
                }
                // pegou o segundo garfo tambem
                jantarfilosofo.garfoOcupado[segundoGarfo] = true;

                // agora que tem os dois garfos na mao, finalmente pode comer
                System.out.println("filosofo " + id + " esta comendo");
                Thread.sleep(300); // tempinho comendo

                // terminou de comer, entao devolve os garfos pra mesa (volta pra false)
                jantarfilosofo.garfoOcupado[segundoGarfo] = false;
                jantarfilosofo.garfoOcupado[primeiroGarfo] = false;
            }
        } catch (Exception e) {
            // testar
            throw new RuntimeException(e);
        }
    }
}
