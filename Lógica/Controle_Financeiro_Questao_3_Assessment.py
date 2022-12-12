def calcPercentual(gastoTotal, renda):
    return gastoTotal * 100 / renda

def gastoMaximo(renda, porcentagemMax):
    return renda * porcentagemMax / 100
           
def impressao(tipo, porcentagemMax, gastoTotal):
     porcentagem = calcPercentual(gastoTotal, rendaMensal)
     print(f"Seus gastos totais com {tipo} comprometem {porcentagem:.2f}% de sua renda total. O máximo recomendado é de {porcentagemMax}%. {obterMensagem(tipo, porcentagemMax, porcentagem)}")


def obterMensagem(tipo, porcentagemMax, porcentagem):
    mensagem = "Seus gastos estão dentro da margem recomendada"
     
    if porcentagem > porcentagemMax:
        if tipo == "moradia":
             mensagem = (f"Portanto, idealmente, o máximo de sua renda comprometida com moradia deveria ser de R${gastoMaximo(rendaMensal, 30)}")
        elif tipo == "educação":
             mensagem = (f"Portanto, idealmente, o máximo de sua renda comprometida com educação deveria ser de R${gastoMaximo(rendaMensal, 20)}")
        elif tipo == "transporte":
             mensagem = (f"Portanto, idealmente, o máximo de sua renda comprometida com transporte deveria ser de R${gastoMaximo(rendaMensal, 15)}")

    return mensagem
    
rendaMesal = 0
gastoTotalMoradia = 0
gastoTotalEducacao = 0
gastoTotalTransporte = 0

rendaMensal = float(input("Informe sua Renda Mensal Total: R$"))
                    
gastoTotalMoradia = float(input("Informe seu Gasto Total com Moradia: R$"))
                          
gastoTotalEducacao = float(input("Informe seu Gasto Total com Educação: R$"))

gastoTotalTransporte = float(input("Informe seu Gasto Total com Transporte: R$"))

impressao("moradia", 30, gastoTotalMoradia)

impressao("educação", 20, gastoTotalEducacao)

impressao("transporte", 15, gastoTotalTransporte)

