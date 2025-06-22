package projetoPOO.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import projetoPOO.model.Avaliacao;
import projetoPOO.model.Disciplina;

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

    private Disciplina disciplina;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        faltasAtuais.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
        );

        faltasAtuais.valueProperty().addListener((obs, oldV, newV) -> {
            if (disciplina != null) {
                disciplina.setFaltasAtuais(newV);
            }
        });
        
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;

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

}
