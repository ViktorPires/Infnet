package domain;

import exceptions.NomeIncompletoException;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor() {
        super();
    }

    public Professor(int id, String nome, int idade, String disciplina) throws NomeIncompletoException {
        super(id, nome, idade);
        this.disciplina = disciplina;
    }

    @Override
    public StringBuilder imprimir() {

        StringBuilder sb = new StringBuilder();

        sb.append("\t\tID: ");
        sb.append(super.getId());
        sb.append("; Professor: ");
        sb.append(super.getNomeCompleto());
        sb.append("; Matéria: ");
        sb.append(disciplina);

        return sb;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
