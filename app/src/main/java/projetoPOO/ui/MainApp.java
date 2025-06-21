package projetoPOO.ui;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainApp extends Application {

    /** 
    @Override
    public void start(Stage primaryStage) throws Exception {

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaVerDisciplinas.fxml"));
        Scene scene = new Scene(loader.load(), 335, 600);
        primaryStage.setTitle("teste");
        primaryStage.setScene(scene);
        primaryStage.show();

    } */

    @FXML
    private TextField email;
    private TextField senha;

    
    @Override
    public void start(Stage loginStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaLogin.fxml"));
        Scene scene = new Scene(loader.load(), 335, 600);
        loginStage.setTitle("Tela Login");
        loginStage.setScene(scene);
        loginStage.show();

    }

    @FXML
    public void onBotaoLogin(ActionEvent e){
        String emailDigitado = email.getText();
        String senhaDigitada = senha.getText();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
