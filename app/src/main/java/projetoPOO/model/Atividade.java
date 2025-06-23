package projetoPOO.model;

import java.time.LocalDate;

/**
 * Contém a implementação de uma subclasse Atividade.
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class Atividade extends Avaliacao {
    
    private String nomeAtividade;

    /**
     * Construtor da classe Atividade
     * @param nomeAvaliacao o nome da atividade
     * @param dataEntrega a data de entrega
     * @param disciplina a disciplina da atividade
     * @param peso o peso da atividade
     */
    public Atividade(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    /**
     * Construtor default da classe Atividade caso seja necessário para o Json
     */
    public Atividade(){
    }

    @Override
    public String descricaoAvaliacao(){
        return "Tipo de Avaliação: " + this.nomeAtividade;
    }

}
