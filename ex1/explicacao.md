# EXPLICACAO DO PROBLEMA 1:


O problema dado foi o problema dos filósofos, que na teoria, diz que se 
todos os filósofos tentarem comer ao mesmo tempo, eles vao morrer de fome, literalmente isso.
Eu fiz ele na prática usando Java pq o Java roda na JVM, que usa threads reais do sistema operacional p rodar cada filósofo ao mesmo tempo de verdade no processador.

Já o interpretador padrão do Python nao usa threads reais rodando junto por causa do GIL (Global Interpreter Lock), que basicamente trava tudo p deixar só uma thread rodar código por vez e fica só alternando entre elas. Isso é um dos maiores problemas do Python, entao quis usar Java tambem por questao de aprendizado.

No código eu separei em dois arquivos dentro da package ex1, o jantarfilosofo.java e o thread.java. Se deixar o boolean deadlock como false, todo mundo pega o garfo da esquerda e fica esperando o da direita p sempre e o programa trava. Deixando como true, eu botei um Math.min e Math.max p ele sempre pegar o menor garfo primeiro e o maior depois, aí cria uma hierarquia e nao trava mais.

Fontes:
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html
https://docs.python.org/3/c-api/init.html#thread-states-and-the-global-interpreter-lock
https://en.wikipedia.org/wiki/Dining_philosophers_problem
