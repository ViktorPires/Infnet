package app;

import java.util.Scanner;

import domain.Aluno;
import domain.Pessoa;
import domain.Professor;
import exceptions.LimitePessoasException;
import exceptions.NomeIncompletoException;

import static auxiliary.Constante.QTD;

public class ControleAcademico {
    private static Scanner in;

    public static Pessoa[] pessoas = new Pessoa[QTD];
    private static String opcao;
    private static int index = 0;

    private static void exibirMenu() {
        System.out.println("Sistema de controle acadêmico");
        System.out.println("---------------------------------------");
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("[1] Cadastrar professor");
        System.out.println("[2] Cadastrar aluno");
        System.out.println("[3] Consultar situação de um docente/discente");
        System.out.println("[4] Sair");

        System.out.print("Informe a opção desejada: ");
    }

    private static void cadastrarProfessor() throws NomeIncompletoException {
        Professor professor = new Professor();

        System.out.println("\nCadastrar Professor");
        System.out.println("-------------------\n");
        if (index < QTD) {
            System.out.println("Informe o nome do professor:");
            in.nextLine();
            professor.setNomeCompleto(in.nextLine());

            int idade = tratarVariavelInt("Informe a idade do professor:");
            professor.setIdade(idade);

            System.out.println("Informe a disciplina que o professor leciona:");
            professor.setDisciplina(in.next());

            professor.setId(index);

            pessoas[index] = professor;

            System.out.println("Cadastro realizado:");
            pessoas[index].imprimir();

            index++;
        }
    }

    private static void cadastrarAluno() throws NomeIncompletoException {
        Aluno aluno = new Aluno();

        System.out.println("\nCadastrar Aluno");
        System.out.println("-------------------\n");

        if (index < QTD) {
            System.out.println("Informe o nome do aluno:");
            in.nextLine();
            aluno.setNomeCompleto(in.nextLine());

            int idade = tratarVariavelInt("Informe a idade do aluno:");
            aluno.setIdade(idade);

            System.out.println("Informe o curso do aluno:");
            aluno.setCurso(in.next());

            System.out.println("Informe o grau escolar do aluno:");
            aluno.setGrauEscolar(in.next());

            System.out.println("Informe o ano escolar do aluno:");
            aluno.setAnoEscolar(in.next());

            aluno.setId(index);

            pessoas[index] = aluno;

            System.out.println("Cadastro realizado:");
            pessoas[index].imprimir();

            index++;
        }
    }

    private static void consultarDocenteDiscente() {
        int posicao = index + 1;
        if (posicao > index) {
            posicao = tratarVariavelInt("Informe o Id que deseja visualizar:");
        }

        try {
            System.out.println(pessoas[posicao].imprimir());
            System.out.println("---------------------------------------------");

        } catch (NullPointerException e) {
           System.err.println("Não há registro salvo com o Id informado!");
           System.out.println("---------------------------------------------");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("O Id informado ultrapassa a capacidade máxima de registro!");
            System.out.println("---------------------------------------------");
        }
    }

    private static int tratarVariavelInt(String texto) {
        String variavel;
        int variavelInt;
        while (true) {
            System.out.println(texto);
            variavel = in.next();
            try {
                variavelInt = Integer.parseInt(variavel);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Necessário digitar um número inteiro!!");
                System.out.println("---------------------------------------------");

            }
        }
        return variavelInt;
    }


    public static void main(String[] args) {
        in = new Scanner(System.in);

        try {
            do {
                exibirMenu();

                opcao = in.next();

                switch (opcao) {
                    case "1":
                        try {
                            if(index >= QTD){
                                throw new LimitePessoasException("Quantidade máxima de cadastramento de pessoas atingida!");
                            }
                            cadastrarProfessor();
                        } catch (NomeIncompletoException | LimitePessoasException e) {
                            System.err.println(e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            if(index >= QTD){
                                throw new LimitePessoasException("Quantidade máxima de cadastramento de pessoas atingida!");
                            }
                            cadastrarAluno();
                        } catch (NomeIncompletoException | LimitePessoasException e) {
                            System.err.println(e.getMessage());
                        }
                        break;
                    case "3":
                        consultarDocenteDiscente();
                        break;
                    case "4":
                        System.out.println("---------------------------------------");
                        System.out.println("Sistema Finalizado!");
                        System.out.println("---------------------------------------");
                        break;
                    default:
                        System.out.println("---------------------------------------");
                        System.err.println("Opção inválida");
                        System.out.println("---------------------------------------");
                        break;
                }
            } while (!"4".equals(opcao));
        } finally {
            in.close();
        }
    }
}