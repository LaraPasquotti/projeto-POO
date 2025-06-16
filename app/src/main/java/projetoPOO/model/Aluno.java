package projetoPOO.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Contém a implementação de Aluno.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */

public class Aluno {
    private String nomeAluno; 
    private String email;
    private String senha;
    private List<Disciplinas> disciplinasAluno = new ArrayList<>();

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
            if(disciplina.getNomeDisciplina().equals(nomeDisciplina)){
                return disciplina;
            }
        }
        return null;
    }

    /**
     * Remove a disciplina da lista de disciplinas do aluno
     *
     * @param nomeDisciplinaRemover nome da disciplina a ser removida
     */
    public void removerDisciplina(String nomeDisciplinaRemover){
        Disciplinas disciplinaRemover = buscarDisciplina(nomeDisciplinaRemover);
        this.disciplinaRemover.remove(disciplinaRemover);
    }

    /**
     * 
     * @return
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    /**
     * 
     * @param nomeAluno
     */
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    /**
     * 
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * 
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * 
     * @return
     */
    public List<Disciplinas> getDisciplinasAluno() {
        return disciplinasAluno;
    }

    /**
     * 
     * @param disciplinasAluno
     */
    public void setDisciplinasAluno(List<Disciplinas> disciplinasAluno) {
        this.disciplinasAluno = disciplinasAluno;
    }

    
}
