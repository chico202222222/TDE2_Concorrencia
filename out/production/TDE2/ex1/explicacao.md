# EXPLICACAO DO PROBLEMA 1:


O problema dado foi o problema dos filósofos, que na teoria, diz que se 
todos os filósofos tentarem comer ao mesmo tempo, eles vao morrer de fome, literalmente isso.
Eu fiz ele na prática usando Java, porque o Java roda em cima da **JVM (Java Virtual Machine)**, que mapeia cada `Thread` criada no código diretamente para uma **thread real do sistema operacional**. Isso permite que os filósofos realmente rodem de forma concorrente e paralela em diferentes núcleos do processador.

Já no interpretador padrão do Python (CPython), mesmo usando a biblioteca de threads, ele **não executa threads reais em paralelo** por causa do **GIL (Global Interpreter Lock)**, sendo uma trava global que deixa apenas uma thread executar código Python por vez, alternando entre elas em vez de rodar tudo ao mesmo tempo de verdade. Isso é um dos maiores problemas do Python, entao quis usar Java tambem por questao de aprendizado.

Na implementação (dividida no package `ex1` entre `Problema1.java` e `thread.java`):
- Cada filósofo é uma instância da classe `thread` (que herda de `Thread`).
- Os 5 garfos da mesa são representados pelo vetor compartilhado `garfoOcupado`.
- Quando `deadlock = false`, todo filósofo tenta pegar primeiro o garfo da esquerda e depois o da direita; se todos pegarem o da esquerda juntos, ninguém consegue pegar o segundo e o programa trava (deadlock).
- Quando `deadlock = true`, aplicamos uma hierarquia de recursos: cada filósofo sempre pega primeiro o garfo de menor índice (`Math.min`) e depois o de maior índice (`Math.max`), quebrando o ciclo de espera e evitando que eles travem.

## Fontes

- [Documentação oficial do Java (`java.lang.Thread`) - Oracle](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html)
- [Documentação oficial do Python (Thread States and the Global Interpreter Lock) - Python.org](https://docs.python.org/3/c-api/init.html#thread-states-and-the-global-interpreter-lock)
- [Dining philosophers problem - Wikipedia](https://en.wikipedia.org/wiki/Dining_philosophers_problem)