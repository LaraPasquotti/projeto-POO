package projetoPOO.ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetoPOO.dados.DadosAlunos;
import projetoPOO.model.Atividade;
import projetoPOO.model.Avaliacao;
import projetoPOO.model.Disciplina;
import projetoPOO.model.Prova;
import projetoPOO.model.Seminario;
import projetoPOO.model.Trabalho;
import java.util.List;
import java.util.ArrayList;

/**
 * Contém a estrutura de implementação de um controller para a tela de disciplina
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaDisciplinaController implements Initializable {

    @FXML
    /**
     * Spinner para ajustar as faltas do aluno
     */
    private Spinner<Integer> faltasAtuais;

    @FXML
    /**
     * Menu para exibir notas indiivduais ou a média final
     */
    private MenuButton mediaFinal;

    @FXML
    /**
     * Texto para exibir resultado da média final ou de uma nota específica
     */
    private Label resultadoMedia;

    @FXML
    /**
     * Botão de voltar para a tela anterior
     */
    private Node botaoVoltar;

    @FXML
    /**
     * Texto indicando a disciplina selecionada
     */
    private Label labelDisciplina;

    @FXML
    /**
     * Botão para adicionar uma nova avaliação
     */
    private Button addAvaliacao;

    @FXML
    /**
     * Campo de texto para inserir o nome da avaliação
     */
    private TextField campoNomeAvaliacao;

    @FXML
    /**
     * Campo de texto para inserir o peso da avaliação
     */
    private TextField campoPeso;

    @FXML
    /**
     * Campo para selecionar a data de entrega da avaliação
     */
    private DatePicker campoData;

    @FXML
    /**
     * Campo para selecionar o tipo de avaliação
     */
    private ChoiceBox<String> choiceTipo;

    @FXML
    /**
     * Menu para escolher uma das avaliações para remover
     */
    private MenuButton menuBtnRemoverAvaliacao;

    @FXML
    /**
     * Botão para adicionar nota à uma avaliação
     */
    private Button btnAdicionarNota;

    @FXML
    /**
     * Campo para selecionar qual avaliação receberá a nota
     */
    private ChoiceBox<String> choiceAvaliacaoNota;

    @FXML
    /**
     * Campo para inserir a nota
     */
    private TextField campoNota;

    private Disciplina disciplina;

    /**
     * Método inicializador do controller
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        campoPeso.textProperty().addListener((obs, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            campoPeso.setText(oldValue);
        }
        });

        campoNota.textProperty().addListener((obs, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            campoNota.setText(oldValue);
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
     * Método para inicializar a choiceAvaliacaoNota com as avaliações do aluno logado
     */
    private void inicializarChoiceAvaliacaoNota(){
        List<String> nomesAvaliacao = new ArrayList<>();
        for(Avaliacao avaliacao : this.disciplina.getAvaliacoes()){
            nomesAvaliacao.add(avaliacao.getnomeAvaliacao());
        }
        choiceAvaliacaoNota.getItems().addAll(nomesAvaliacao);

    }

    /**
     * Método para setar a disciplina do aluno logado
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
        atualizarMenuRemover();
        inicializarChoiceAvaliacaoNota();
    }

    /**
     * Botão para voltar para tela anterior
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

    /**
     * Método para adicionar uma nova avaliação
     */
    @FXML
    private void addAvaliacao(){
        if(choiceTipo.getValue() == null){
            TelaLoginController.exibirAlertaDeErro("É necessário escolher um tipo de avaliação.");
            return;
        } 
        if(campoData.getValue() == null){
            TelaLoginController.exibirAlertaDeErro("É necessário escolher uma data.");
            return;
        }

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
            exibirAlertaDeSucesso("Avaliação " + novaAvaliacao.getnomeAvaliacao() + " adicionada com sucesso.");
            choiceAvaliacaoNota.getItems().add(novaAvaliacao.getnomeAvaliacao());
        }
        campoNomeAvaliacao.clear();
        campoPeso.clear();
        campoData.setValue(null);
        choiceTipo.setValue(null);
    }

    /**
     * Método para exibir alerta de sucesso
     * @param mensagem mensagem a ser exibida no alerta
     */
    public void exibirAlertaDeSucesso(String mensagem){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucessos");
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    /**
     * Método para atualizar as opções do menu remover quando uma nova avaliação é adicionada
     */
    private void atualizarMenuRemover() {
    menuBtnRemoverAvaliacao.getItems().clear();

    for (Avaliacao d : this.disciplina.getAvaliacoes()) {
        MenuItem item = new MenuItem(d.getnomeAvaliacao());
        item.setOnAction(e -> confirmarRemocao(d));
        menuBtnRemoverAvaliacao.getItems().add(item);
    }
    }

    /**
     * Método para confirmar a remoção de uma disciplina
     * @param avaliacao
     */
    private void confirmarRemocao(Avaliacao avaliacao) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Remoção");
        alert.setHeaderText(null);
        alert.setContentText("Deseja realmente remover a avaliação \"" + avaliacao.getnomeAvaliacao() + "\"?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {
            this.disciplina.removerAvaliacao(avaliacao);
            DadosAlunos.getInstancia().salvar();
            exibirAlertaDeSucesso("Avaliação \"" + avaliacao.getnomeAvaliacao() + "\" removida.");
            atualizarMenuRemover();
        }
    }

    /**
     * Método auxiliar para buscar uma avalição por nome
     * @param nomeBuscar nome da avaliação a ser buscada
     */
    private Avaliacao buscarAvaliacao(String nomeBuscar){
        for(Avaliacao avaliacao : this.disciplina.getAvaliacoes()){
            if(avaliacao.getnomeAvaliacao().equalsIgnoreCase(nomeBuscar)){
                return avaliacao;
            }
        }
        return null;
    }

    /**
     * Método para atribuir uma nova nova a uma avalição existente
     */
    @FXML
    private void adicionarNota(){
        int novaNota = Integer.parseInt(campoNota.getText());
        if(choiceAvaliacaoNota.getValue() == null){
            TelaLoginController.exibirAlertaDeErro("É necessário escolher uma avaliação.");
            return;
        }
        Avaliacao avaliacaoAdd = buscarAvaliacao(choiceAvaliacaoNota.getValue());
        if(avaliacaoAdd != null){
            avaliacaoAdd.setNota(novaNota);
            DadosAlunos.getInstancia().salvar();
            exibirAlertaDeSucesso("Nova nova adicionada com sucesso a " + avaliacaoAdd.getnomeAvaliacao());
        } else{
            TelaLoginController.exibirAlertaDeErro("Avaliação não encontrada.");
        }
           
        campoNota.clear();
        choiceAvaliacaoNota.setValue(null);

    }
}



