package ex3;

public class thread extends Thread {

    int id;
    boolean hierarquia;

    public thread(int id, boolean hierarquia) {
        this.id = id;
        this.hierarquia = hierarquia;
    }

    @Override 
    public void run() {
        try {
            // se hierarquia for true, as duas threads entram aqui e pegam A antes de B
            // isso quebra a espera circular de coffman e nao deixa travar
            if (id == 1 || hierarquia) {
                deadlock.lockA.lock();
                System.out.println("t" + id + " pegou lock A");

                Thread.sleep(50);

                System.out.println("t" + id + " esperando lock B");
                deadlock.lockB.lock();
                System.out.println("t" + id + " pegou lock B");

                System.out.println("T" + id + " concluiu");

                deadlock.lockB.unlock();
                deadlock.lockA.unlock();
            } else {
                // jeito que trava: a t2 pega o B primeiro e depois tenta pegar o A
                deadlock.lockB.lock();
                System.out.println("t" + id + " pegou lock B");

                Thread.sleep(50);

                System.out.println("t" + id + " esperando lock A");
                deadlock.lockA.lock();
                System.out.println("t" + id + " pegou lock A");

                System.out.println("T" + id + " concluiu");

                deadlock.lockA.unlock();
                deadlock.lockB.unlock();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
