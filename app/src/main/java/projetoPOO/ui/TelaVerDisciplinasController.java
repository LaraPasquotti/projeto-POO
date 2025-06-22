package projetoPOO.ui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import projetoPOO.dados.DadosAlunos;
import projetoPOO.model.Disciplina;

/**
 * Contém a estrutura de implementação de um controller para a tela de disciplinas
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaVerDisciplinasController {

    /**
     * Botão para adicionar disciplina
     */
    @FXML
    private Button btnAdicionarDisciplina;

    /**
     * Campo de texto para o nome da nova disciplina
     */
    @FXML 
    private TextField campoNomeNovaDisciplina;  

    /**
     * Campo de texto para o numero limites de falta
     */
    @FXML
    private TextField campoNumeroLimiteFaltas;

    /**
     * Campo de texto para as faltas atuais
     */
    @FXML
    private TextField campoNumeroFaltasAtuais;

    @FXML 
    private ListView<Disciplina> listaDisciplinas;

    private ObservableList<Disciplina> obsDisciplinas;

    /**
     * Método inicializador do controller
     */
    @FXML
    public void initialize() {
        mostrarDisciplinasAluno();

        campoNumeroLimiteFaltas.textProperty().addListener((obs, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            campoNumeroLimiteFaltas.setText(oldValue);
        }
        });

        campoNumeroFaltasAtuais.textProperty().addListener((obs, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            campoNumeroFaltasAtuais.setText(oldValue);
        }
        });

        listaDisciplinas.setCellFactory(d -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Disciplina disciplina, boolean empty) {
                super.updateItem(disciplina, empty);
                if (empty || disciplina == null) {
                    setGraphic(null);
                } else {
                    Label nomeLabel = new Label(disciplina.getNomeDisciplina());
                    nomeLabel.setStyle("-fx-font-weight: bold;");

                    Label faltasLabel = new Label(disciplina.getFaltasAtuais() + "/" + disciplina.getNumeroLimiteFaltas() + " faltas");
                    faltasLabel.setStyle("-fx-text-fill: #666;");

                    HBox box = new HBox(10, nomeLabel, faltasLabel);
                    HBox.setHgrow(nomeLabel, Priority.ALWAYS);
                    setGraphic(box);
                }
            }
        });
    }

    /**
     * Método de adicionar disciplinas
     */
    @FXML
    private void adicionarDisciplina() {
        String nomeDisciplina = campoNomeNovaDisciplina.getText();
        int numeroLimiteFaltas = Integer.parseInt(campoNumeroLimiteFaltas.getText());
        int numeroFaltasAtuais = Integer.parseInt(campoNumeroFaltasAtuais.getText());
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, numeroLimiteFaltas, numeroFaltasAtuais);
        TelaLoginController.alunoLogado.adicionarDisciplina(novaDisciplina);
        this.obsDisciplinas.add(novaDisciplina);
        DadosAlunos.getInstancia().salvar();
        System.out.println(novaDisciplina.getNomeDisciplina() + " " + novaDisciplina.getNumeroLimiteFaltas() + " " + novaDisciplina.getFaltasAtuais());
    }

    public void mostrarDisciplinasAluno() {
        List<Disciplina> disciplinas = TelaLoginController.alunoLogado.getDisciplinasAluno();
        this.obsDisciplinas = FXCollections.observableArrayList(disciplinas);
        listaDisciplinas.setItems(obsDisciplinas);
    }

}

