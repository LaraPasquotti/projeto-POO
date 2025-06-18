package projetoPOO.dados;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import projetoPOO.model.*;


public abstract class Dados<T> {
    protected List<T> lista;
    protected final ObjectMapper mapper = new ObjectMapper();

    public Dados(){
    }

    public void adicionar(T t){
        lista.add(t);
        salvarNoJson(lista);
    }

    public List<T> getLista(){
        return this.lista;
    }

    protected abstract void salvarNoJson(List<T> lista);


    public abstract List<T> carregarDoJson();

}


