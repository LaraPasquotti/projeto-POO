/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package projetoPOO.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


/**
 * Contém a estrutura de implementação da aplicação.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 * 
 *  */


public class App {
    
    public static void main(String[] args) throws IOException{
        Aluno alunoTeste = new Aluno();
        alunoTeste.setNomeAluno("joao");
        alunoTeste.setEmail("joao@gmail.com");
        alunoTeste.setSenha("joao123");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("usuarios.json"), alunoTeste);


        Aluno alunoTeste2 = new Aluno();
        alunoTeste2.setNomeAluno("maria");
        alunoTeste2.setEmail("maria@gmail.com");
        alunoTeste2.setSenha("maria123");

    } 
}
