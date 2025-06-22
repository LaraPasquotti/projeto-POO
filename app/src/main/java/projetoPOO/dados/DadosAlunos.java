package projetoPOO.dados;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import projetoPOO.model.Aluno;

/**
 * Classe responsável por gerenciar a persistência dos dados dos alunos em arquivo JSON.
 * 
 * Utiliza o padrão Singleton para garantir que haja apenas uma instância ativa.
 *  @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class DadosAlunos extends Dados<Aluno>{
    private static DadosAlunos instancia;
    private File arquivoAlunos = new File("app/src/main/resources/alunos.json");


    
    /**
     * Construtor privado para garantir o padrão Singleton.
     * Inicializa a lista de alunos carregando os dados do JSON.
     */
    private DadosAlunos(){
        this.lista = carregarDoJson();
    }

    /**
     * Retorna a instância única da classe DadosAlunos
     * Caso ainda não exista, ela é criada.
     *
     * @return Instância única de DadosAlunos
     */
    public static DadosAlunos getInstancia(){
        if(instancia == null){
            instancia = new DadosAlunos();
        }
        return instancia;
    }

    /**
     * Salva a lista de alunos no arquivo JSON.
     *
     * @param listaAlunos Lista de alunos a ser persistida
     */
    @Override
    protected void salvarNoJson(List<Aluno> listaAlunos) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivoAlunos, listaAlunos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Carrega a lista de alunos a partir do arquivo JSON.
     * 
     * @return Lista de alunos carregada do JSON. Retorna lista vazia se o arquivo não existir ou ocorrer erro de leitura.
     */
    @Override
    public List<Aluno> carregarDoJson(){
        try {
            var inputStream = getClass().getClassLoader().getResourceAsStream("alunos.json");
            if (inputStream == null) return new ArrayList<>();
            return new ArrayList<>(Arrays.asList(mapper.readValue(inputStream, Aluno[].class)));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

