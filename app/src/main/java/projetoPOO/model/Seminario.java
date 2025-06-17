package projetoPOO.model;

import java.time.LocalDate;

public class Seminario extends Avaliacao {

    public Seminario(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }
}
