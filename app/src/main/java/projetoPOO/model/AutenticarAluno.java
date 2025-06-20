package projetoPOO.model;

import projetoPOO.exceptions.*;
import projetoPOO.dados.DadosAlunos;

/**
 * Contém a estrutura de implementação da classe AutenticarAluno
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AutenticarAluno {
    
    /**
     * Método para buscar o email do aluno
     * @param email o email do aluno
     * @return retorna o email do aluno, caso encontrado
     * @throws UsuarioNaoEncontradoException
     */
    private static Aluno buscarEmail(String email) throws UsuarioNaoEncontradoException {
        for(Aluno aluno : DadosAlunos.getInstancia().getLista()){
            if(aluno.getEmail().equals(email)){
                return aluno;
            }
        }
        throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }

    /**
     * Método para verificar a senha do aluno
     * @param senha a senha do aluno
     * @param aluno o aluno
     * @throws SenhaIncorretaException
     */
    private static void verificarSenha(String senha, Aluno aluno) throws SenhaIncorretaException{
        if(aluno.getSenha().equals(senha)){

        }
        else{
            throw new SenhaIncorretaException("Senha incorreta");
        }
    }

    /**
     * Método para logar
     * @param email o email do aluno
     * @param senha a senha do aluno
     * @return retorna o login do aluno, caso tudo estiver correto
     */
    public static Aluno login(String email, String senha){
        try{
            Aluno aluno = buscarEmail(email);
            verificarSenha(senha, aluno);
            return aluno;

        } catch(UsuarioNaoEncontradoException | SenhaIncorretaException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
