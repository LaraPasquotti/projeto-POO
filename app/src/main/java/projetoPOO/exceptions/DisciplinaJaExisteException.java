package projetoPOO.exceptions;

/**
 * Contém a estrutura de implementação de um tratamento de erro DisciplinaJaExisteException.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class DisciplinaJaExisteException extends Exception {
    
    public DisciplinaJaExisteException(String mensagem){
        super(mensagem);
    }

}
