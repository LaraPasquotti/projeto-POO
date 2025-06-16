package projetoPOO.filter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.Avaliacao;

/**
 * Contém a estrutura de implementação de um filtro por data.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorDataFilter implements Filter {
    private LocalDate dataFiltrar;

    /**
     * Construtor da classe AvaliacaoPorDataFilter
     *
     * @param dataFiltrar a data a ser usada de filtro
     */    
    public AvaliacaoPorDataFilter(LocalDate dataFiltrar){
        this.dataFiltrar = dataFiltrar;
    }


    /**
     * Filtra as avaliações com base na data especificada.
     *
     * @param avaliacoes a lista de avaliacoes a ser filtrada
     * @return a lista de avaliacoes que possuem a data igual a especificada
     */
    @Override
    public List<Avaliacao> meetCriteria(List<Avaliacao> avaliacoes) {
        List<Avaliacao> listaFiltrados = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacoes){
            if(avaliacao.getDataEntrega().equals(this.dataFiltrar)){
                listaFiltrados.add(avaliacao);
            }
        }
        return listaFiltrados;
    }

}
