package projetoPOO.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    /**
     * Método inicializador do controller
     */
    @FXML
    public void initialize() {

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
        System.out.println("Tela carregada com sucesso!");
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
        System.out.println(novaDisciplina.getNomeDisciplina() + " " + novaDisciplina.getNumeroLimiteFaltas() + " " + novaDisciplina.getFaltasAtuais());

    }
}

