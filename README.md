# TDE 2, PERFORMANCE EM SISTEMAS CIBERFÍSICOS
## por Francisco Medeiros, aluno PUCPR 
## 15/11/2026

## 1. por que Java ao em vez de Python?

Eu escolhi usar Java principalmente por ser muito mais fácil de organizar o código em classes, 
onde eu fiz por exemplo no exercício 1 uma package com uma classe só pra thread, e outro arquivo pra poder
implementar a classe thread e resolver o problema. No Python também dá pra fazer isso, mas o interpretador do Python tem o GIL, entao ele nao roda as threads ao mesmo tempo de verdade nos núcleos do processador, enquanto o Java roda em cima da JVM e usa threads reais do sistema operacional.

## 2. Parte 3 - Deadlock (package ex3)

Na pasta ex3 eu fiz no mesmo esquema do ex1, com o arquivo deadlock.java p rodar o main e a classe thread.java extendendo a Thread do Java.

Deixando a variável hierarquia como false, a thread 1 pega o lock A e espera o B, enquanto a thread 2 pega o lock B e espera o A. Aí acontecem as 4 condições de Coffman juntas (exclusão mútua, manter e esperar, não preempção e espera circular) e o programa trava sem terminar:

t1 pegou lock A
t2 pegou lock B
t1 esperando lock B
t2 esperando lock A

Mudando hierarquia pra true, as duas threads seguem a mesma ordem global e pegam sempre o lock A antes do lock B. Isso quebra a condição de espera circular de Coffman e o código roda até o fim normal:

t1 pegou lock A
t1 esperando lock B
t1 pegou lock B
T1 concluiu
t2 pegou lock A
t2 esperando lock B
t2 pegou lock B
T2 concluiu
