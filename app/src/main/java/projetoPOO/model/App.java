/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package projetoPOO.model;

import java.io.IOException;
import java.util.Scanner;

import projetoPOO.dados.DadosAlunos;

/**
 * Contém a estrutura de implementação da aplicação.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 *
 *
 */
public class App {

    public static void main(String[] args) throws IOException {

        Aluno novoAluno = new Aluno("Joao", "joao@gmail.com", "123");
        DadosAlunos.getInstancia().adicionar(novoAluno);
        DadosAlunos.getInstancia().salvar();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        Aluno alunoLogado = AutenticarAluno.login(email, senha);
        if (alunoLogado != null) {
            System.out.println(alunoLogado.getNome());
        }
        
        Disciplina disciplinaPoo = new Disciplina("POO", 10, 2);
    }
}
