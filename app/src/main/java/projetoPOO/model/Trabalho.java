package projetoPOO.model;

import java.time.LocalDate;

public class Trabalho extends Avaliacao {

    public Trabalho(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

}
