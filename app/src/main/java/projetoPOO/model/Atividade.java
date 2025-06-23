package projetoPOO.model;

import java.time.LocalDate;

public class Atividade extends Avaliacao {
    
    private String nomeAtividade;

    public Atividade(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    public Atividade(){
    }

    @Override
    public String descricaoAvaliacao(){
        return "Tipo de Avaliação: " + this.nomeAtividade;
    }

}
