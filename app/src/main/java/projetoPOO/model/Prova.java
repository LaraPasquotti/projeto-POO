package projetoPOO.model;
import java.time.LocalDate;

/**
 * Contém a estrutura de implementação de Prova
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Prova extends Avaliacao {

    /**
     * Contrutor da subclasse Prova
     * @param nomeAvaliacao o nome da prova
     * @param dataEntrega a data de entrega da prova
     * @param disciplina a disciplina da prova
     * @param peso o peso da prova
     */
    public Prova(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    /**
     * Construtor Default para uso do Json
     */
    public Prova(){
    }

}
