package projetoPOO.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um filtro por nome da disciplina.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorDisciplina implements FiltroPesquisa {

    @Override
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes) {
        List<Avaliacoes> disciplinas = new ArrayList<>();

        for (Avaliacoes avaliacao : avaliacoes){
            if(avaliacao.getDisciplina().equals(avaliacao)){
                disciplinas.add(avaliacao);
            }
        }
        return disciplinas;
    }

}
