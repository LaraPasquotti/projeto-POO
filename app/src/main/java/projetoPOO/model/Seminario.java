package projetoPOO.model;
import java.time.LocalDate;

/**
 * Contém a estrutura de implementação de Seminario
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Seminario extends Avaliacao {



    /**
     * Construtor default da classe Seminario caso seja necessário para o Json
     */
    public Seminario(){  
    }


    /**
     * Construtor classe Seminario
     * @param nomeSeminario nome do seminario
     * @param dataApresentacao data da apresentação do seminario
     * @param disciplina Disciplina do Seminario
     * @param peso peso do Seminario
     */ 
    public Seminario(String nomeSeminario, LocalDate dataApresentacao, Disciplina disciplina, double peso) {
        super(nomeSeminario, dataApresentacao, disciplina, peso);
    }
}
