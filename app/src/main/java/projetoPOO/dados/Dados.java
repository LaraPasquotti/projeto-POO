package projetoPOO.dados;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Classe abstrata genérica responsável por manipular dados persistentes em JSON.
 * 
 * @param <T> Tipo de elementos que serão armazenados e manipulados
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public abstract class Dados<T> {

    protected List<T> lista;
    protected final ObjectMapper mapper = new ObjectMapper();


    /**
     * Construtor classe abstrata Dados
     */ 
    public Dados() {
        mapper.registerModule(new JavaTimeModule());
    }

    /**
     * Adiciona novo elemento na lista e depois salva a alteração no json
     * @param t elemento a ser adicionado
     */ 
    public void adicionar(T t) {
        lista.add(t);
        salvarNoJson(lista);
    }

    /**
     * Retorna a lista de elementos atualmente carregada
     *
     * @return Lista contendo os elementos
     */
    public List<T> getLista() {
        return this.lista;
    }

    /**
     * Salva a lista fornecida no arquivo JSON correspondente.
     *
     * @param lista Lista que será persistida no JSON
     */
    protected abstract void salvarNoJson(List<T> lista);


    /**
     * Carrega os dados do arquivo JSON e retorna a lista correspondente.
     *
     * @return Lista com os elementos carregados do JSON
     */
    public abstract List<T> carregarDoJson();


    /**
     * Salva a lista atual no JSON.
     */
    public void salvar() {
        salvarNoJson(getLista());
    }
}

