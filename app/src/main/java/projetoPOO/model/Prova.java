package projetoPOO.model;

import java.time.LocalDate;

public class Prova extends Avaliacao {

    /**
     * Construtor default da classe Prova caso seja necessário para o Json
     */
    public Prova(){

    }

    /**
     * Construtor classe Prova
     * @param nomeProva nome da prova
     * @param dataProva data da prova
     * @param disciplina Disciplina da prova
     * @param peso peso da prova
     */ 
    public Prova(String nomeProva, LocalDate dataProva, Disciplina disciplina, double peso) {
        super(nomeProva, dataProva, disciplina, peso);
    }

}
