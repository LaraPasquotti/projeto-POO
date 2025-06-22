package projetoPOO.ui;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import projetoPOO.dados.DadosAlunos;
import projetoPOO.exceptions.DisciplinaJaExisteException;
import projetoPOO.exceptions.SenhaIncorretaException;
import projetoPOO.exceptions.UsuarioNaoEncontradoException;
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

    @FXML
    private Button btnVoltar;

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

    /**
     * Lista de disciplinas do aluno
     */
    @FXML 
    private ListView<Disciplina> listaDisciplinas;

    /**
     * ObservableList das disciplinas do aluno
     */
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
     * Caso a disciplina já exista, mostra a exceção de DisciplinaJaExiste
     */
    @FXML
    private void adicionarDisciplina() {
        String nomeDisciplina = campoNomeNovaDisciplina.getText();
        int numeroLimiteFaltas = Integer.parseInt(campoNumeroLimiteFaltas.getText());
        int numeroFaltasAtuais = Integer.parseInt(campoNumeroFaltasAtuais.getText());
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, numeroLimiteFaltas, numeroFaltasAtuais);
        
        
        try{TelaLoginController.alunoLogado.adicionarDisciplina(novaDisciplina);
        } catch(DisciplinaJaExisteException e){
            TelaLoginController.exibirAlertaDeErro(e.getMessage());
        }
        
        this.obsDisciplinas.add(novaDisciplina);
        DadosAlunos.getInstancia().salvar();
        System.out.println(novaDisciplina.getNomeDisciplina() + " " + novaDisciplina.getNumeroLimiteFaltas() + " " + novaDisciplina.getFaltasAtuais());
    }

    /**
    * Exibe as disciplinas do aluno no listView
    */
    public void mostrarDisciplinasAluno() {
        List<Disciplina> disciplinas = TelaLoginController.alunoLogado.getDisciplinasAluno();
        this.obsDisciplinas = FXCollections.observableArrayList(disciplinas);
        listaDisciplinas.setItems(obsDisciplinas);
    }

    @FXML
    private void voltarParaTelaPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaPrincipal.fxml"));
            Parent root = loader.load();

           
            TelaPrincipalController principalController = loader.getController();
            principalController.setAlunoLogado(TelaLoginController.alunoLogado);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 335, 600));
            stage.setTitle("Minhas Avaliações");
            stage.show();

        } catch (IOException e) {

        }
    }


}

