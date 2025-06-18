package projetoPOO.model;

import projetoPOO.exceptions.*;
import projetoPOO.dados.DadosAlunos;

public class AutenticarAluno {
       
    private static Aluno buscarEmail(String email) throws UsuarioNaoEncontradoException {
        for(Aluno aluno : DadosAlunos.getInstancia().getLista()){
            if(aluno.getEmail().equals(email)){
                return aluno;
            }
        }
        throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }
    private static void verificarSenha(String senha, Aluno aluno) throws SenhaIncorretaException{
        if(aluno.getSenha().equals(senha)){
            return;
        }
        else{
            throw new SenhaIncorretaException("Senha incorreta");
        }
    }

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
