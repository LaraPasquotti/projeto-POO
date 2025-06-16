package projetoPOO.filter;

import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.Avaliacoes;

/**
 * Contém a estrutura de implementação de um filtro por nome da disciplina.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorDisciplinaFilter implements Filter {

    @Override
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes) {
        List<Avaliacoes> disciplinas = new ArrayList<>();

        for (Avaliacoes avaliacao : avaliacoes){
            if(avaliacao.getDisciplina().equals(avaliacao.getDisciplina())){
                disciplinas.add(avaliacao);
            }
        }
        return disciplinas;
    }

}
