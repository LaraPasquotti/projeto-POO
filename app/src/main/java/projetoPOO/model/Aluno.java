package projetoPOO.model;
import java.util.ArrayList;

/**
 * Contém a implementação de Aluno.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */

public class Aluno {
    String nomeAluno; 
    String email;
    String senha;
    List<Disciplina> disciplinasAluno = new ArrayList<>;

    /**
     * Construtor da classe Aluno
     *
     * @param nome nome do aluno
     * @param email email do aluno
     * @param senha senha do aluno
     */
    public Aluno(String nome, String email, String senha){
        this.nomeAluno = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Cria uma disciplina e adiciona a lista de disciplinas do aluno
     *
     * @param nomeDisciplina nome da disciplina
     * @param numeroLimiteFaltas numero limite de faltas da disciplina
     * @param faltasAtuais faltas atuais do aluno
     */
    public void adicionarDisciplina(String nomeDisciplina, int numeroLimiteFaltas, int faltasAtuais){
        Disciplinas novaDisciplina = new Disciplinas(nomeDisciplina, numeroLimiteFaltas, faltasAtuais);
        this.disciplinasAluno.add(novaDisciplina);
    }

    /**
     * Busca na lista de disciplinas do aluno uma disciplina pelo nome;
     *
     * @param nomeDisciplina nome da disciplina buscada
     * @return disciplina encontrada com o nomeDisciplina
     */
    private Disciplinas buscarDisciplina (String nomeDisciplina){
        for(Disciplinas disciplina : this.disciplinasAluno){
            if(disciplina.nomeDisciplina.equals(nomeDisciplina)){
                return disciplina;
            }
        }
        return;
    }



    /**
     * Remove a disciplina da lista de disciplinas do aluno
     *
     * @param nomeDisciplinaRemover nome da disciplina a ser removida
     */
    public void removerDisciplina(String nomeDisciplinaRemover){
        Disciplina disciplinaRemover = buscarDisciplina(nomeDisciplinaRemover);
        this.disciplinaRemover.remove(disciplinaRemover);
    }
}
