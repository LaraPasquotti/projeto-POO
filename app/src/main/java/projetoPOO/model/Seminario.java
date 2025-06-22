package projetoPOO.model;
import java.time.LocalDate;

/**
 * Contém a estrutura de implementação de Seminario
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Seminario extends Avaliacao {

    /**
     * Construtor da subclasse Seminario
     * @param nomeAvaliacao o nome 
     * @param dataEntrega a data de entrega
     * @param disciplina a disciplina do seminario
     * @param peso o peso do seminario
     */
    public Seminario(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    /**
    * Construtor Default para uso do Json
    */
    public Seminario(){
    }
}
