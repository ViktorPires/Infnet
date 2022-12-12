package domain;

import exceptions.NomeIncompletoException;

public class Aluno extends Pessoa {
    private String curso;
    private String grauEscolar;
    private String anoEscolar;

    public Aluno() {
        super();
    }

    public Aluno(int id, String nome, int idade, String curso, String grauEscolar, String anoEscolar) throws NomeIncompletoException {
        super(id, nome, idade);
        this.curso = curso;
        this.grauEscolar = grauEscolar;
        this.anoEscolar = anoEscolar;
    }

    @Override
    public StringBuilder imprimir() {

        StringBuilder sb = new StringBuilder();

        sb.append("\t\tID: ");
        sb.append(super.getId());
        sb.append("; Aluno: ");
        sb.append(getNomeCompleto());
        sb.append("; Curso: ");
        sb.append(curso);
        sb.append("; Ensino: ");
        sb.append(grauEscolar);
        sb.append("; Ano: ");
        sb.append(anoEscolar);

        return sb;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrauEscolar() {
        return grauEscolar;
    }

    public void setGrauEscolar(String grauEscolar) {
        this.grauEscolar = grauEscolar;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }
}
