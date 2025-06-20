package projetoPOO.model;
import java.time.LocalDate;

/**
 * Contém a estrutura de implementação de Prova
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Trabalho extends Avaliacao {


    /**
     * Construtor default da classe Trabalho caso seja necessário para o Json
     */
    public Trabalho(){
    }

    /**
     * Construtor classe Trabalho
     * @param nomeTrabalho nome do Trabalho
     * @param dataEntrega data de entrega do Trabalho
     * @param disciplina Disciplina do Trabalho
     * @param peso peso do Trabalho
     */ 
    public Trabalho(String nomeTrabalho, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeTrabalho, dataEntrega, disciplina, peso);
    }

}
