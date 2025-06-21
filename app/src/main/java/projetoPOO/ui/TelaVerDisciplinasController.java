package projetoPOO.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import projetoPOO.model.*;
import javafx.scene.control.TextField;


public class TelaVerDisciplinasController {

    @FXML
    private Button btnAdicionarDisciplina;

    @FXML 
    private TextField campoNomeNovaDisciplina;  

    @FXML
    private TextField campoNumeroLimiteFaltas;

    @FXML
    private TextField campoNumeroFaltasAtuais;

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

    @FXML
    private void adicionarDisciplina() {
        String nomeDisciplina = campoNomeNovaDisciplina.getText();
        int numeroLimiteFaltas = Integer.parseInt(campoNumeroLimiteFaltas.getText());
        int numeroFaltasAtuais = Integer.parseInt(campoNumeroFaltasAtuais.getText());
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, numeroLimiteFaltas, numeroFaltasAtuais);
        System.out.println(novaDisciplina.getNomeDisciplina() + " " + novaDisciplina.getNumeroLimiteFaltas() + " " + novaDisciplina.getFaltasAtuais());

    }
}

