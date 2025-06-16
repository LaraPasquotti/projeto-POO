package projetoPOO.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um filtro por data.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorData implements FiltroPesquisa {

    @Override
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes) {
        List<Avaliacoes> dataAvalicaoes = new ArrayList<>();

        for (Avaliacoes avaliacao : avaliacoes){
            if(avaliacao.getDataEntrega().equals(avaliacao)){
                dataAvalicaoes.add(avaliacao);
            }
        }
        return dataAvalicaoes;
    }

}
