package projetoPOO.filter;

import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.Avaliacoes;

public class AvaliacaoPorNomeDaAtividadeFilter implements Filter {

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
