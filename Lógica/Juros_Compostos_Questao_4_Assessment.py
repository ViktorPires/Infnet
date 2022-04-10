import matplotlib.pyplot as plt

def rndmJurosCompostos(valorInicial):
    montanteAcumulado = []
    montanteMensal = []

    for periodo in range(totalPeriodos):
        valorInicial = valorInicial + valorInicial * (rendimento/100) + aporte
        valor = valorInicial
        montanteMensal.append(valor)
        montanteAcumulado.append(periodo)
        
        print(f"Após {periodo + 1} período(s), o montante será de R$ {valor:.2f}")

    plt.xlabel("Meses")
    plt.ylabel("Valor")
    plt.plot(montanteMensal,montanteAcumulado) #Definindo X e Y no Gráfico 
    plt.show()

valorInicial = float(input("Informe o valor inicial: R$"))
rendimento = float(input("Informe o rendimento por período (%): "))
aporte = float(input("Informe o valor de aporte a cada período: "))
totalPeriodos = int(input("Informe o total de períodos: "))

rndmJurosCompostos(valorInicial)