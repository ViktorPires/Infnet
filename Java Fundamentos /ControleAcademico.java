import java.util.Scanner;

public class ControleAcademico {
    private static Scanner in;
    private static String[] nomes;
    private static float[] notasAV1;
    private static float[] notasAV2;
    private static final int QTDALUNOS = 100;
    private static String opcao;
    private static int indexAluno = 0;

    private static void exibirMenu() {
        System.out.println("Sistema de controle acadêmico");
        System.out.println("---------------------------------------");
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("[1] Registrar as notas de um novo aluno.");
        System.out.println("[2] Consultar boletim de um aluno.");
        System.out.println("[3] Consultar notas da turma.");
        System.out.println("[4] Sair");
        
        System.out.print("Informe a opção desejada: ");
    }

    private static float verificarNota() {
        float nota = in.nextFloat();
        while (nota > 10 || nota < 0) {
            if(nota == Float.NaN ) {
                System.out.println("Nota inválida - A nota deve ser um número real!");
                }
            System.out.println("Nota inválida - A nota deve ser um número entre 0 a 10!");
            System.out.print("Digite uma nota entre 0 a 10: ");
            nota = in.nextFloat();
            }
        return nota;
    }

    private static void registrarNotas() {
        if (indexAluno < QTDALUNOS) {
            System.out.println("-----------------------------------");
            System.out.println("Opção 1 - Selecionado");
            System.out.println("Registrar as notas de um novo aluno");
            System.out.println("---------------------------------------");
            System.out.print("Informe o nome do aluno: ");
            nomes[indexAluno] = in.next();

            System.out.print("Nota da avaliação 1: ");
            notasAV1[indexAluno] = verificarNota();

            System.out.print("Nota da avaliação 2: ");
            notasAV2[indexAluno] = verificarNota();
            System.out.println("---------------------------------------");

            
            imprimirAluno(indexAluno);
            
            System.out.println("Dados registrados!");
            System.out.println("---------------------------------------");

            indexAluno++;
        } else {
            System.out.println("Quantidade máxima de cadastramento esgotado");
        }
    }

    private static void consultarNotasAluno() {
        System.out.println("-----------------------------------");
        System.out.println("Opção 2 - Selecionado");
        System.out.println("Consultar boletim de um aluno");
        System.out.println("---------------------------------------");
        System.out.print("Informe o número de registro do aluno: ");
        int registroAluno = in.nextInt();
        if(indexAluno != 0) {
            while(indexAluno != 0) {
                if(registroAluno > indexAluno) {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("O registro do aluno deve ser um número inteiro entre 0 a" + (indexAluno - 1));
                    System.out.println("-------------------------------------------------------------------");

                } else {
                    imprimirAluno(registroAluno);
                    break;
                }
            }
        } else {
            System.out.println("---------------------------------------");
            System.out.println("Não há aluno registrado!");
            System.out.println("---------------------------------------");
        }
    }

    private static void consultarNotasTurma() {
        System.out.println("-----------------------------------");
        System.out.println("Opção 3 - Selecionado");
        System.out.println("Consultar notas da Turma");
        System.out.println("---------------------------------------");
        if (indexAluno == 0) {
            System.out.println("---------------------------------------");
            System.out.println("Não há alunos cadastrados!");
            System.out.println("---------------------------------------");
        } else {
            for (int i = 0; i < indexAluno; i++) {
                imprimirAluno(i);
            }
        }
    }

    private static float calcularMedia(int registroDoAluno) {
        float mediaAluno = (notasAV1[registroDoAluno] + notasAV2[registroDoAluno]) / 2;
        return mediaAluno;
    }

    private static String verificarAprovacao(float mediaDoAluno) {
        if(mediaDoAluno >= 7) {
            return "Aprovado";
        } else if(mediaDoAluno >= 4 && mediaDoAluno < 7) {
            return "Prova Final";
        } else {
            return "Reprovado";
        }
    }

    private static void imprimirAluno(int posicaoAluno) {
        float media = calcularMedia(posicaoAluno);
        String resultado = verificarAprovacao(media);
        System.out.println("Registro: " + posicaoAluno);
        System.out.println("Nome do aluno: " + nomes[posicaoAluno]);
        System.out.println("Nota da Avaliação 1: " + notasAV1[posicaoAluno]);
        System.out.println("Nota da Avaliação 2: " + notasAV2[posicaoAluno]);
        System.out.println("Média das notas: " + media);
        System.out.println("Resultado final: " + resultado);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);

        nomes = new String[QTDALUNOS];
        notasAV1 = new float[QTDALUNOS];
        notasAV2 = new float[QTDALUNOS];

        do {
            exibirMenu();

            opcao = in.next();

            switch (opcao) {
                case "1":
                    registrarNotas();
                    break;
                case "2":
                    consultarNotasAluno();
                    break;
                case "3":
                    consultarNotasTurma();
                    break;
                case "4":
                    System.out.println("---------------------------------------");
                    System.out.println("Sistema Finalizado!");
                    System.out.println("---------------------------------------");
                    break;
                default:
                    System.out.println("---------------------------------------");
                    System.out.println("Opção inválida");
                    System.out.println("---------------------------------------");
                    break;
            }
        } while (!"4".equals(opcao));

        in.close();
    }
}
