package projetoPOO.model;

import java.util.ArrayList;

/**
 * Contém a implementação da estrutura de uma classe Disciplina.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Disciplinas {

    private String nomeDisciplina;
    private int numeroLimiteFaltas;
    private int faltasAtuais;
    private ArrayList<Avaliacoes> avaliacoes;

    /**
     * Construtor da classe Disciplina
     * @param nomeDisciplina
     * @param numeroLimiteFaltas
     * @param faltasAtuais
     */
    public Disciplinas(String nomeDisciplina, int numeroLimiteFaltas, int faltasAtuais){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroLimiteFaltas = numeroLimiteFaltas;
        this.faltasAtuais = faltasAtuais; 
        this.avaliacoes = new ArrayList<>();

    }

    /**
     * Método de adicionar faltas
     * @param faltasAtuais
     */
    public void adicionarFaltas(int faltasAtuais){
        faltasAtuais ++;
    }

    public void calcularMedia(){

    }

    
    public void removerFaltas(){

    }

    /**
     * Retorna o nome da disciplina.
     * @return o nome da disciplina
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * Altera o nome da disciplina.
     * @param nomeDisciplina o novo nome da disciplina
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Retoena o número limites de faltas da disciplina
     * @return o número limeites de faltas
     */
    public int getNumeroLimiteFaltas() {
        return numeroLimiteFaltas;
    }

    /**
     * Altera o numero limite de faltas da disciplina
     * @param numeroLimiteFaltas o novo numero limtite de faltas
     */
    public void setNumeroLimiteFaltas(int numeroLimiteFaltas) {
        this.numeroLimiteFaltas = numeroLimiteFaltas;
    }

    /**
     * Retorna as faltas atuais do aluno
     * @return as faltas atuais do aluno
     */
    public int getFaltasAtuais() {
        return faltasAtuais;
    }

    /**
     * Altera as faltas atuais do aluno
     * @param faltasAtuais as novas faltas atuais do aluno
     */
    public void setFaltasAtuais(int faltasAtuais) {
        this.faltasAtuais = faltasAtuais;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Avaliacoes> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * 
     * @param avaliacoes
     */
    public void setAvaliacoes(ArrayList<Avaliacoes> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    

}
