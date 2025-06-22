package projetoPOO.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Contém a estrutura de implementação de um controller para a tela principal
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaPrincipalController {

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
