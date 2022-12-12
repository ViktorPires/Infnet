package domain;

import exceptions.NomeIncompletoException;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String nomeDoMeio;
    private String ultimoNome;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, int idade) throws NomeIncompletoException {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public StringBuilder getNomeCompleto() {
        StringBuilder nomeCompleto = new StringBuilder();

        if(nomeDoMeio == null || nomeDoMeio.isEmpty()) {
            nomeCompleto.append(nome);
            nomeCompleto.append(" ");
            nomeCompleto.append(ultimoNome);
        } else {
            nomeCompleto.append(nome);
            nomeCompleto.append(" ");
            nomeCompleto.append(nomeDoMeio);
            nomeCompleto.append(" ");
            nomeCompleto.append(ultimoNome);
        }

        return nomeCompleto;
    }

    public StringBuilder imprimir() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\tID: ");
        sb.append(id);
        sb.append(" Nome: ");
        sb.append(nome);

        return sb;
    }

    public void setNomeCompleto(String nome) throws NomeIncompletoException {
        if (nome.indexOf(" ") <= 0 || nome == null){
            throw new NomeIncompletoException("\n\tO nome da pessoa precisa ter ao menos 1 sobrenome.\n\t");
        }

        this.nome = nome.substring(0, nome.indexOf(" "));
        this.nomeDoMeio = nome.substring(nome.indexOf(" "), nome.lastIndexOf(" ")).trim();
        this.ultimoNome = nome.substring(nome.lastIndexOf(" ")).trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
