package projetoPOO.model;

import java.util.List;

/**
 * Contém a estrutura de implementação de uma interface de filtro de pesquisa para as avaliações.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public interface FiltroPesquisa {

    /**
     * Contrutor da interface de filtro de pesquisas.
     * @param avaliacoes avaliações que serão filtrados
     * @return as avaliações que serão pesquisadas
     */
    public List<Avalicoes> meetCriteria(List<Avalicoes> avaliacoes);

}
