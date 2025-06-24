package projetoPOO.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    /**
     * Inicia a aplicação JavaFX com a tela de login
     */
    @Override
    public void start(Stage loginStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaLogin.fxml"));
        Scene scene = new Scene(loader.load(), 335, 600);
        loginStage.setTitle("Tela Login");
        loginStage.setScene(scene);
        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
