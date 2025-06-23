package projetoPOO.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

import javafx.scene.control.ChoiceBox;
import net.bytebuddy.dynamic.NexusAccessor;
import projetoPOO.dados.DadosAlunos;
import projetoPOO.model.*;





/**
 * Contém a estrutura de implementação de um controller para a tela de disciplina
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaDisciplinaController implements Initializable {

    @FXML 
    private Spinner<Integer> faltasAtuais;

    @FXML
    private MenuButton mediaFinal;

    @FXML
    private Label resultadoMedia;

    @FXML
    private Node botaoVoltar;

    @FXML
    private Label labelDisciplina;

    @FXML 
    private Button addAvaliacao;

    @FXML
    private TextField campoNomeAvaliacao;

    @FXML
    private TextField campoPeso;

    @FXML
    private DatePicker campoData;

    @FXML
    private ChoiceBox<String> choiceTipo;




    private Disciplina disciplina;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        campoPeso.textProperty().addListener((obs, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            campoPeso.setText(oldValue);
        }
        });

        choiceTipo.getItems().addAll("Prova", "Trabalho", "Seminário", "Atividade");

        faltasAtuais.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
        );

        faltasAtuais.valueProperty().addListener((obs, oldV, newV) -> {
            if (disciplina != null) {
                disciplina.setFaltasAtuais(newV);
            }
        });
        
    }

    /**
     * COMENTAR!!!!!!!!!!!!!!
     * @param disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;

        labelDisciplina.setText(disciplina.getNomeDisciplina());

        int limite = disciplina.getNumeroLimiteFaltas();
        int faltas = disciplina.getFaltasAtuais();

        faltasAtuais.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, limite, faltas)
        );

        mediaFinal.getItems().clear();
        for (Avaliacao a : disciplina.getAvaliacoes()) {
            MenuItem item = new MenuItem(a.getnomeAvaliacao());
            item.setOnAction(e -> {
                double nota = a.getNota();
                resultadoMedia.setText(String.format("%s: %.1f", a.getnomeAvaliacao(), nota));
            });

            mediaFinal.getItems().add(item);
        }

        MenuItem mediaFinalItem = new MenuItem("Média final");
        mediaFinalItem.setOnAction(e -> {
            double media = disciplina.calcularMedia();
            resultadoMedia.setText(String.format("Média final: %.1f", media));
        });
        mediaFinal.getItems().add(new SeparatorMenuItem());
        mediaFinal.getItems().add(mediaFinalItem);
    }


    /**
     * COMENTAR!!!!!!!!!!!!!
     * @param event
     */
    @FXML
    private void botaoVoltar(ActionEvent event) {
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

    @FXML
    private void addAvaliacao(){
        String nomeAvaliacao = campoNomeAvaliacao.getText();
        int pesoSelecionado = Integer.parseInt(campoPeso.getText());
        LocalDate dataSelecionada = campoData.getValue();
        String tipoSelecionado = choiceTipo.getValue();

        Avaliacao novaAvaliacao;

        switch(tipoSelecionado){
            case "Prova":
                novaAvaliacao = new Prova(nomeAvaliacao, dataSelecionada, this.disciplina, pesoSelecionado);
                break;
            case "Trabalho":
                novaAvaliacao = new Trabalho(nomeAvaliacao, dataSelecionada, this.disciplina, pesoSelecionado);
                break;
            case "Seminário":
                novaAvaliacao = new Seminario(nomeAvaliacao, dataSelecionada, this.disciplina, pesoSelecionado);
                break;
            case "Atividade":
                novaAvaliacao = new Atividade(nomeAvaliacao, dataSelecionada, this.disciplina, pesoSelecionado);
                break;
            default:
                novaAvaliacao = null;
                break;
        }
        if(novaAvaliacao != null){
            this.disciplina.adicionarAvaliacao(novaAvaliacao);
            DadosAlunos.getInstancia().salvar();
            exibirAlertaDeSucesso("Avaliação " + novaAvaliacao.getnomeAvaliacao() + " adicionada com sucesso");
        }
        campoNomeAvaliacao.clear();
        campoPeso.clear();
        campoData.setValue(null);
        choiceTipo.setValue(null);
    }

    public void exibirAlertaDeSucesso(String mensagem){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucessos");
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
    }



        
    }


