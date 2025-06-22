package projetoPOO.ui;

import java.io.IOException;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetoPOO.model.Aluno;
import projetoPOO.model.Avaliacao;
import projetoPOO.model.Disciplina;

/**
 * Contém a estrutura de implementação de um controller para a tela principal
 * * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */

public class TelaPrincipalController {

    /**
     * Botão para ver as disciplinas
     */
    @FXML
    private Button botaoVerDisciplinas;

    /**
     * TableView para as avaliações
     */
    @FXML
    private TableView<Avaliacao> tabelaAvaliacoes;

    /**
     * TableColumn para as avaliaçõces
     */
    @FXML
    private TableColumn<Avaliacao, String> colunaAvaliacoes;

    /**
     * Campo de pesquisa para filtrar uma avaliação
     */
    @FXML
    private TextField campoPesquisa;


    private ObservableList<Avaliacao> listaDeAvaliacoes = FXCollections.observableArrayList();
    private Aluno alunoLogado;

   
    /**
     * Método inizilizador do controller
     */
    @FXML
    private void initialize() {
       
        colunaAvaliacoes.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().toString())
        );
        
    }

    /**
     * Método de setar o aluno que está logado, assim como suas avaliações
     * @param aluno
     */
    public void setAlunoLogado(Aluno aluno) {
        this.alunoLogado = aluno;
        carregarAvaliacoesDoAluno();
    }

    /**
     * Método para carregar as avaliações do aluno
     */
    private void carregarAvaliacoesDoAluno() {
        if (alunoLogado == null) {
            return;
        }

        for (Disciplina disciplina : alunoLogado.getDisciplinasAluno()) {
            
            for (Avaliacao avaliacao : disciplina.getAvaliacoes()) {
                avaliacao.setDisciplina(disciplina);
                listaDeAvaliacoes.add(avaliacao);
            }
        }
        
        Collections.sort(listaDeAvaliacoes);
        tabelaAvaliacoes.setItems(listaDeAvaliacoes);
    }
    
    /**
     * Método para ver as disciplinas
     * @param event evento de ver as disciplinas 
     */
    @FXML
    private void verDisciplinas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaVerDisciplinas.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 335, 600));
            stage.setTitle("Suas Disciplinas");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}