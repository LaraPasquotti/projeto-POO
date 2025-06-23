package projetoPOO.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "tipo"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Prova.class, name = "prova"),
    @JsonSubTypes.Type(value = Trabalho.class, name = "trabalho"),
    @JsonSubTypes.Type(value = Seminario.class, name = "seminario"),
    @JsonSubTypes.Type(value = Atividade.class, name = "atividade"),
    // coloque todas que existem no seu projeto
})

public abstract class Avaliacao implements Comparable<Avaliacao> {

    private String nomeAvaliacao;
    private LocalDate dataEntrega;
    @JsonIgnore
    private Disciplina disciplina;
    private double peso;
    private double nota;

    /**
     * Construtor da classe Avaliacoes
     * @param nomeAvaliacao o nome da atividade
     * @param dataEntrega a data de entrega da atividade
     * @param disciplina a disciplina associada à atividade
     * @param peso o peso da nota da atividade
     */
    public Avaliacao(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        this.nomeAvaliacao = nomeAvaliacao;
        this.dataEntrega = dataEntrega;
        this.disciplina = disciplina;
        this.peso = peso;
    }

    /**
     * Construtor default da classe Avaliacao caso seja necessário para o Json
     */
    public Avaliacao(){

    }

    /**
     * Retorna o nome da atividade
     * @return o nome da atividade
     */
    public String getnomeAvaliacao() {
        return nomeAvaliacao;
    }

    /**
     * Altera o nome da atividade para 'nomeAvaliacao'
     * @param nomeAvaliacao o novo nome da atividade
     */
    public void setnomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    /**
     * Retorna a data de entrega da atividade
     * @return a data de entrega da atividade
     */
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Altera a data de entrega da atividade para 'dataEntrega'
     * @param dataEntrega a nova data de entrega
     */
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * Retorna a disciplina referente à atividade
     * @return a disciplina referente à atividade
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Altera a disciplina para 'disciplina'
     * @param disciplina a nova disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Retorna o peso da nota da atividade
     * @return o peso da nota da atividade
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Altera o peso da nota da atividade para 'peso'
     * @param peso o novo peso da nota da atividade
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Método para comparar as avaliações por data de entrega (mais recente até a mais distante)
     */
    @Override 
    public int compareTo(Avaliacao outraAvaliacao) {
        return this.dataEntrega.compareTo(outraAvaliacao.getDataEntrega());
    }

    /**
     * Retorna a nota
     * @return a nota da avalicao
     */
    public double getNota() {
        return nota;
    }

    /**
     * Altera a nota
     * @param nota a nova nota da avaliacao
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("%s - Entrega: %s", 
        this.getnomeAvaliacao(), this.getDataEntrega().toString());
    }   

    

}

 