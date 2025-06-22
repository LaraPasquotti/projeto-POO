/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package projetoPOO.model;

import java.io.IOException;
import java.util.Scanner;

/**
 * Contém a estrutura de implementação da aplicação.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 *
 *
 */
public class App {

    public static void teste(String email, String senha){
        System.out.println("Entrou na função");
        Aluno alunoLogado = AutenticarAluno.login(email, senha);
        if(alunoLogado != null){
            System.out.println("Logou " + alunoLogado.getNome());
        }
        return;
    }

    public static void main(String[] args) throws IOException {

        //Aluno novoAluno = new Aluno("Joao", "joao@gmail.com", "123");
        //DadosAlunos.getInstancia().adicionar(novoAluno);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        Aluno alunoLogado = AutenticarAluno.login(email, senha);
        if (alunoLogado != null) {
            System.out.println(alunoLogado.getNome());
        }
        
        /*Disciplina disciplinaPoo = new Disciplina("POO", 10, 2);

        LocalDate hoje = LocalDate.now();
        Seminario novaAvaliacao = new Seminario("seminario POO", hoje, disciplinaPoo, 3);

        Disciplina disciplinaAddAvaliacao = alunoLogado.buscarDisciplina(novaAvaliacao.getDisciplina().getNomeDisciplina());
        disciplinaAddAvaliacao.adicionarAvaliacao(novaAvaliacao);

        //alunoLogado.adicionarDisciplina(disciplinaPoo);
        DadosAlunos.getInstancia().salvar();*/
    }
}
