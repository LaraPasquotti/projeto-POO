package projetoPOO.model;

import java.time.LocalDate;

public class Atividade extends Avaliacao {

    public Atividade(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

    public Atividade(){
    }

}
