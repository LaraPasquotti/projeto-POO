package projetoPOO.model;
import java.time.LocalDate;

/**
 * Contém a estrutura de implementação de Prova
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Trabalho extends Avaliacao {

    private String nomeTrabalho;

    /**
     * Constutor da subclasse Trabalho
     * @param nomeAvaliacao o nome 
     * @param dataEntrega a data de entrega
     * @param disciplina a disciplina do trabalho
     * @param peso o peso do trabalho
     */
    public Trabalho(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    /**
    * Construtor Default para uso do Json
    */
    public Trabalho(){
    }

    /**
     * Retorna uma descrição do trabalho
     */
    public String descricaoAvaliacao(){
        return "Nome do trabalho: " + this.nomeTrabalho;
    }

}
