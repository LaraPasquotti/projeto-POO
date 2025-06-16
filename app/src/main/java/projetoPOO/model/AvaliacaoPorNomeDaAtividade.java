package projetoPOO.model;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoPorNomeDaAtividade implements FiltroPesquisa {

    @Override
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes){
        List<Avaliacoes> nomeAtividade = new ArrayList<>();

        for (Avaliacoes avaliacao : avaliacoes){
            if(avaliacao.getNomeAtividade().equals(avaliacao.getNomeAtividade())){
                nomeAtividade.add(avaliacao);
            }
        }
        return nomeAtividade;
    }

}
