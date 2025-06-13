package projetoPOO;

import java.util.ArrayList;

/**
 * Contém a implementação da estrutura de uma classe Disciplina.
 * 
 * @author Lara Pasquotti, Isabel 
 */
public class Disciplinas {

    private String nomeDisciplina;
    private int numeroLimiteFaltas;
    private int faltasAtuais;
    private ArrayList<Avaliacoes> avaliacoes;

    /**
     * 
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

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getNumeroLimiteFaltas() {
        return numeroLimiteFaltas;
    }

    public void setNumeroLimiteFaltas(int numeroLimiteFaltas) {
        this.numeroLimiteFaltas = numeroLimiteFaltas;
    }

    public int getFaltasAtuais() {
        return faltasAtuais;
    }

    public void setFaltasAtuais(int faltasAtuais) {
        this.faltasAtuais = faltasAtuais;
    }

    public ArrayList<Avaliacoes> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacoes> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    

}
