package projetoPOO.model;

import java.time.LocalDate;

public class Prova extends Avaliacao {

    public Prova(String nomeAvaliacao, LocalDate dataEntrega, Disciplina disciplina, double peso) {
        super(nomeAvaliacao, dataEntrega, disciplina, peso);
    }

}
