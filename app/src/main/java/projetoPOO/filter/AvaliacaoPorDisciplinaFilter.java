package projetoPOO.filter;

import java.util.ArrayList;
import java.util.List;

import projetoPOO.model.*;

/**
 * Contém a estrutura de implementação de um filtro por nome da disciplina.
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvaliacaoPorDisciplinaFilter implements Filter {
    private Disciplina disciplinaFiltrar;

    /**
     * Construtor da classe AvaliacaoPorDisciplinaFilter
     *
     * @param disciplinaFiltrar a disciplina a ser usada de filtro
     */
    public AvaliacaoPorDisciplinaFilter(Disciplina disciplinaFiltrar){
        this.disciplinaFiltrar = disciplinaFiltrar;
    }

    /**
     * Filtra as avaliações com base na disciplina especificada.
     *
     * @param avaliacoes a lista de avaliacoes a ser filtrada
     * @return a lista de avaliacoes que possuem a disciplina igual a especificada
     */
    @Override
    public List<Avaliacao> meetCriteria(List<Avaliacao> avaliacoes) {
        List<Avaliacao> listaFiltrados = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacoes){
            if(avaliacao.getDisciplina().equals(this.disciplinaFiltrar)){
                listaFiltrados.add(avaliacao);
            }
        }
        return listaFiltrados;
    }

}
