/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package projetoPOO.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import projetoPOO.dados.*;
import projetoPOO.dados.DadosAlunos;


/**
 * Contém a estrutura de implementação da aplicação.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 * 
 *  */


public class App {
    
    public static void main(String[] args) throws IOException{
        Aluno alunoLogado = AutenticarAluno.login("joao@email.com", "237");
        if(alunoLogado != null){
            System.out.println(alunoLogado.getNome());
        }
    } 
}
