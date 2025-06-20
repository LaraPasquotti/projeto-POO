package projetoPOO.exceptions;

/**
 * Contém a estrutura de implementação de um tratamento de erro de UsuarioNaoEncontrado.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class UsuarioNaoEncontradoException extends Exception {
    
    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
