package projetoPOO.filter;

import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.Avaliacoes;

/**
 * Contém a estrutura de implementação de um filtro por data.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorDataFilter implements Filter {

    @Override
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes) {
        List<Avaliacoes> dataAvalicaoes = new ArrayList<>();

        for (Avaliacoes avaliacao : avaliacoes){
            if(avaliacao.getDataEntrega().equals(avaliacao.getDataEntrega())){
                dataAvalicaoes.add(avaliacao);
            }
        }
        return dataAvalicaoes;
    }

}
