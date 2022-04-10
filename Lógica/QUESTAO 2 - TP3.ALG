Algoritmo "Questao 2 - TP3"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Elberth Moraes
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Viktor Pires
// Data atual  : 3/4/2022

Funcao obterDireito(aIdade: inteiro): caractere
inicio
se (aIdade > 0) e (aIdade < 16) entao
   retorne "Não tem direito a voto"
senao
   se (aIdade >= 16) e (aIdade < 18) ou (aIdade >= 70) entao
      retorne "Eleitor Facultativo"
   senao
      se (aIdade >= 18) e (aIdade < 70) entao
         retorne "Eleitor Obrigatório"
      senao
         se aIdade = 0 entao
            retorne "Idade deve ser maior que 0"
         fimse
      fimse
   fimse
fimse
fimFuncao

Procedimento impressao()
inicio
  direitoFinal <- obterDireito(idade)

  escreval(direitoFinal)
fimProcedimento

Var
   sair: caractere
   idade: inteiro
   direitoFinal: caractere
Inicio
sair <- ""

enquanto (sair <> "s") e (sair <> "S") faca

  escreva("Informe a idade: ")
  leia(idade)

  impressao()
   
   escreva("Deseja sair? S/N: ")
   leia(sair)
   
fimEnquanto

Fimalgoritmo
