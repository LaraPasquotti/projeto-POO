package projetoPOO.filter;

import java.util.List;
import projetoPOO.model.*;

/**
 * Contém a estrutura de implementação de uma interface de filtro de pesquisa para as avaliações.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public interface Filter {

    /**
     * Contrutor da interface de filtro de pesquisas.
     * @param avaliacoes avaliações que serão filtrados
     * @return as avaliações que serão pesquisadas
     */
    public List<Avaliacoes> meetCriteria(List<Avaliacoes> avaliacoes);

}
