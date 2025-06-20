package projetoPOO.model;

import projetoPOO.exceptions.*;
import projetoPOO.dados.DadosAlunos;

public class AutenticarAluno {
    
    /**
     * busca um aluno no Json pelo email
     * @param email email do aluno a ser buscado
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
     * Verifica se a senha digitada é igual a do aluno
     * @param senha senha digitada
     * @param aluno aluno que quer ser logado
     */    
    private static void verificarSenha(String senha, Aluno aluno) throws SenhaIncorretaException{
        if(aluno.getSenha().equals(senha)){
            return;
        }
        else{
            throw new SenhaIncorretaException("Senha incorreta");
        }
    }

    /**
     * Realiza o login do aluno se o email estiver no json e se a senha for digitada corretamente
     * @param email email digitado a ser buscado no json
     * @param senha senha digitada
     */
    public static Aluno login(String email, String senha){
        try{
            Aluno aluno = buscarEmail(email);
            verificarSenha(senha, aluno);
            return aluno;

        } catch(UsuarioNaoEncontradoException e){
            System.out.println(e.getMessage());
        } catch (SenhaIncorretaException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
