Algoritmo "Questao 2 - TP3"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Elberth Moraes
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Viktor Maximiliam Oleksiuk Pires
// Data atual  : 12/3/2022
Var
   idade: inteiro
   sair: caractere
Inicio
      idade <- 0
      sair <- ""

      enquanto (sair <> "s") e (sair <> "S") faca
             escreva("Informe a idade: ")
              leia(idade)
                     se (idade > 0) e (idade < 16) entao
                        escreval("Não tem direito a voto")
                     senao
                          se (idade >= 16) e (idade < 18) ou (idade >= 70) entao
                             escreval("Eleitor Facultativo")
                          senao
                               se (idade >= 18) e (idade < 70) entao
                                  escreval("Eleitor Obrigatório")
                               senao
                                    se idade = 0 entao
                                       escreval("Idade deve ser maior que 0")
                                    fimse
                               fimse
                          fimse
                     fimse
              escreva("Deseja sair? S/N: ")
              leia(sair)
      fimenquanto
Fimalgoritmo
