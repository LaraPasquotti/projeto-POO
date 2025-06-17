package projetoPOO.model;

import java.time.LocalDate;

public abstract class Avaliacao implements Comparable<Avaliacao> {

    private String nomeAvaliacao;
    private LocalDate dataEntrega;
    private Disciplina disciplina;
    private double peso;

    public Avaliacao() {
        
    }

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
     * Método para comparar datas das avaliações
     * @param outraAvaliacao a outra avaliação a ser comparada
     * @return 
     */
    @Override 
    public int compareTo(Avaliacao outraAvaliacao) {
        return outraAvaliacao.dataEntrega.compareTo(this.dataEntrega);
    }


}

 