# EXPLICACAO DO PROBLEMA 3:


Nessa parte 3 a ideia era criar um deadlock de propósito com 2 threads e 2 locks (A e B) e depois arrumar. Eu fiz igual no exercicio 1, deixei o main limpo no deadlock.java e criei a classe thread.java p fazer o trabalho.

Quando o boolean hierarquia ta false, a thread 1 pega o lock A, dorme 50ms e tenta pegar o B. Enquanto isso a thread 2 pega o lock B, dorme 50ms e tenta pegar o A. Como cada uma já pegou um lock e fica esperando o que ta na mao da outra, o programa trava ali mesmo e nao termina nunca.

Isso acontece pq bateu as 4 condições de Coffman ao mesmo tempo: exclusão mútua (só uma thread pode pegar cada lock por vez), manter e esperar (cada thread segura o lock que pegou e fica esperando o outro), não preempção (uma thread nao consegue tomar o lock da outra a força) e espera circular (a t1 espera a t2 soltar o B e a t2 espera a t1 soltar o A).

Quando trava (hierarquia = false), o console para aqui e nao sai mais disso:

t1 pegou lock A
t2 pegou lock B
t1 esperando lock B
t2 esperando lock A

Pra resolver isso é só mudar o boolean hierarquia p true. Aí as duas threads entram no mesmo if e são obrigadas a pegar sempre o lock A primeiro e o lock B depois. Fazendo essa hierarquia de recursos eu quebro a condição de espera circular de Coffman, pq quem pegar o lock A primeiro já consegue pegar o B livre, termina e solta os dois p outra thread usar.

Saída quando funciona (hierarquia = true):

t1 pegou lock A
t1 esperando lock B
t1 pegou lock B
T1 concluiu
t2 pegou lock A
t2 esperando lock B
t2 pegou lock B
T2 concluiu
