Algoritmo "Questao 1 - TP3"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Elberth Moraes
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Viktor Pires
// Data atual  : 3/4/2022

funcao calcularValorIndividual(): real
inicio
  retorne valorFinal / pessoasTotal
fimFuncao

funcao calcularValorFinal(): real
inicio
  retorne consumoTotal + (consumoTotal * taxa / 100)
fimFuncao

procedimento impressao()
inicio
    valorFinal <- calcularValorFinal()

    escreval("O valor total da conta, com a taxa de serviço, será de R$",valorFinal)

    valorIndividual <- calcularValorIndividual()

    escreval("Dividindo a conta por",pessoasTotal, " pessoa(s), cada pessoa deverá pagar R$",valorIndividual)
fimProcedimento

Var
   consumoTotal: real
   pessoasTotal: inteiro
   taxa: real
   valorFinal: real
   valorIndividual: real
   sair: caractere

Inicio
      consumoTotal <- 0
      pessoasTotal <- 0
      taxa <- 0
      valorFinal <- 0
      valorIndividual <- 0
      sair <- ""

enquanto (sair <> "s") e (sair <> "S") faca
      escreva("Informe o valor total do consumo: ")
      leia(consumoTotal)
      
           se consumoTotal <= 0 entao
              escreval("Valor de consumo inválido!!! Repita o procedimento!!!")
           senao
               escreva("Informe o total de pessoas: ")
               leia (pessoasTotal)
                    se pessoasTotal <= 0 entao
                       escreval("Número de pessoas inválido!!! Repita o procedimento!!!")
                    senao
                       escreva("Informe o percentual do serviço, entre 0 e 100: ")
                       leia(taxa)
                            se (taxa < 0) ou (taxa > 100) entao
                               escreval("Valor de taxa é inválido!!! Repita o procedimento!!!")
                            senao
                               impressao()
                            fimse
                    fimse
           fimse
             
        escreva("Deseja sair? S/N: ")
        leia(sair)
fimEnquanto
Fimalgoritmo
