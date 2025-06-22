package projetoPOO.filter;

import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.Avaliacao;

/**
 * Contém a estrutura de implementação de um filtro por nome.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */

public class AvaliacaoPorNomeFilter implements Filter {
    private String nomeFiltrar;

    /**
     * Construtor da classe AvaliacaoPorNomeFilter
     *
     * @param nomeFiltrar o nome da avaliacao a ser filtrada
     */
    public AvaliacaoPorNomeFilter(String nomeFiltrar){
        this.nomeFiltrar = nomeFiltrar;
    }

    /**
     * Filtra as avaliações com base no nome especificado.
     *
     * @param avaliacoes a lista de avaliacoes a ser filtrada
     * @return a lista de avaliacoes que possuem o nome igual ao especificado
     */
    @Override
    public List<Avaliacao> meetCriteria(List<Avaliacao> avaliacoes){
        List<Avaliacao> listaFiltrados = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacoes){
            if(avaliacao.getnomeAvaliacao().equals(this.nomeFiltrar)){
                listaFiltrados.add(avaliacao);
            }
        }
        return listaFiltrados;
    }

}
