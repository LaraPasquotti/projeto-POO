package projetoPOO.dados;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import projetoPOO.model.*;

public class DadosAlunos extends Dados<Aluno>{
    private static DadosAlunos instancia;
    private File arquivoAlunos = new File("app/src/main/java/projetoPOO/dados/alunos.json");

    private DadosAlunos(){
        this.lista = carregarDoJson();
    }

    public static DadosAlunos getInstancia(){
        if(instancia == null){
            instancia = new DadosAlunos();
        }
        return instancia;
    }

    @Override
    protected void salvarNoJson(List<Aluno> listaAlunos) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivoAlunos, listaAlunos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aluno> carregarDoJson(){
        try {
            if (!arquivoAlunos.exists()) return new ArrayList<>();
            return new ArrayList<>(Arrays.asList(mapper.readValue(arquivoAlunos, Aluno[].class)));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}

