Algoritmo "Questao 3 - TP3"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Elberth Moraes
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Viktor Maximiliam Oleksiuk Pires
// Data atual  : 3/4/2022

procedimento impressao(aNota: real)
inicio
se (aNota >=0) e (aNota <= 10) entao
    escreva("O(A) vencedor(a) foi ",participanteVencedor," com nota",maiorNota)
senao
    interrompa
fimse
fimProcedimento

Var
   nota: real
   participante: caractere
   maiorNota: real
   participanteVencedor: caractere
   numeroParticipantes: inteiro
   totalParticipantes: inteiro

Inicio
      nota <- 0
      maiorNota <- 0
      participante <- ""
      participanteVencedor <- ""
      numeroParticipantes <- 0
      totalParticipantes <- 0
      totalParticipantes <- totalParticipantes + 1

      escreva("Informe o número de participantes: ")
      leia(numeroParticipantes)

      para totalParticipantes de 1 ate numeroParticipantes faca
         escreva("Informe o nome do",totalParticipantes,"º participante: ")
         leia(participante)

         escreva("Informe a nota do",totalParticipantes,"º do participante: ")
         leia(nota)

         se (nota < 0) ou (nota > 10) entao
            escreval("Nota deve estar entre 0 a 10")
            interrompa
         senao
            se nota >= maiorNota entao
               participanteVencedor <- participante
               maiorNota <- nota
            fimse
         fimse
      fimpara

impressao(nota)
Fimalgoritmo
