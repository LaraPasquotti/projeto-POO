package projetoPOO.model;
import java.util.ArrayList;
import java.util.List;


/**
 * Contém a implementação de Aluno.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */

public class Aluno {
    private String nome; 
    private String email;
    private String senha;
    private List<Disciplina> disciplinasAluno = new ArrayList<>();

    /**
     * Construtor da classe Aluno
     *
     * @param nome nome do aluno
     * @param email email do aluno
     * @param senha senha do aluno
     */
    public Aluno(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor default da classe Aluno caso seja necessário para o Json
     */
    public Aluno(){
    }

    /**
     * Adiciona uma disciplina a lista de disciplinas do aluno se ela ainda não existir
     *
     * @param disciplina disciplina a ser adicionada na lista de disciplinas do aluno;
     */
    public void adicionarDisciplina(Disciplina disciplina){
        if(buscarDisciplina(disciplina.getNomeDisciplina()) != null){
            return;
        }
        this.disciplinasAluno.add(disciplina);
    }

    /**
     * Busca na lista de disciplinas do aluno uma disciplina pelo nome;
     *
     * @param nomeDisciplina nome da disciplina buscada
     * @return disciplina encontrada com o nomeDisciplina
     */
    protected Disciplina buscarDisciplina (String nomeDisciplina){
        for(Disciplina disciplina : this.disciplinasAluno){
            if(disciplina.getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)){
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
        Disciplina disciplinaRemover = buscarDisciplina(nomeDisciplinaRemover);
        this.disciplinasAluno.remove(disciplinaRemover);
    }

    /**
     * Retorna o nome do aluno
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atuliza o nome do aluno para nome
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o email do aluno
     * @return email do aluno
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atualiza o email do aluno
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Atualiza a senha do aluno 
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna a lista de disciplinas do aluno
     * @return lista de disciplinas do aluno
     */
    public List<Disciplina> getDisciplinasAluno() {
        return disciplinasAluno;
    }

    /**
     * Atualiza a lista de disciplinas do aluno
     * @param disciplinasAluno
     */
    public void setDisciplinasAluno(List<Disciplina> disciplinasAluno) {
        this.disciplinasAluno = disciplinasAluno;
    }

    /**
     * Retorna a senha do aluno
     * @return senha Aluno
     */
    protected String getSenha(){
        return this.senha;
    }

    
}
