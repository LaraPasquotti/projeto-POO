package projetoPOO.model;

import java.util.ArrayList;

/**
 * Contém a implementação da estrutura de uma classe Disciplina.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Disciplina {

    private String nomeDisciplina;
    private int numeroLimiteFaltas;
    private int faltasAtuais;
    private ArrayList<Avaliacao> avaliacoes;

    /**
     * Construtor da classe Disciplina
     * @param nomeDisciplina
     * @param numeroLimiteFaltas
     * @param faltasAtuais
     */
    public Disciplina(String nomeDisciplina, int numeroLimiteFaltas, int faltasAtuais){
        this.nomeDisciplina = nomeDisciplina;
        this.numeroLimiteFaltas = numeroLimiteFaltas;
        this.faltasAtuais = faltasAtuais; 
        this.avaliacoes = new ArrayList<>();
    }

    public Disciplina(){}

    /**
     * Método de adicionar faltas
     * @param faltasAtuais
     */
    public void adicionarFaltas(int faltasAtuais){
        this.faltasAtuais ++;
    }

    /**
     * Método de calculo da média
     * @return a média das notas 
     */
    public double calcularMedia(){
        if (this.avaliacoes.isEmpty()){
            return 0.0;
        }

        double somaNotasPonderadas = 0.0;
        double somaPesos = 0.0;

        for (Avaliacao avaliacao : this.avaliacoes){
            somaNotasPonderadas += avaliacao.getNota() * avaliacao.getPeso();
            somaPesos += avaliacao.getPeso();
        }

        if (somaPesos == 0){
            return 0.0;
        }

        return somaNotasPonderadas / somaPesos;

    }


    public void removerFaltas(){
        this.faltasAtuais --;

    }

    /**
     * Método para adicionar uma avaliação na lista de avaliações
     * @param avaliacao nova avaliação a ser adicionada
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    /**
     * Método para remover uma avaliação na lista de avaliações
     * @param avaliacao a avaliação a ser removida
     */
    public void removerAvaliacao(Avaliacao avaliacao) {
        avaliacoes.remove(avaliacao);
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
     * Retorna a lista de avaliacoes
     * @return a lista de avaliacoes
     */
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Altera a lista de avaliacoes
     * @param avaliacoes nova lista de avaliacoes
     */
    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    

}
