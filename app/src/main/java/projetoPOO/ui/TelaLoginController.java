package projetoPOO.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projetoPOO.model.Aluno;
import projetoPOO.model.AutenticarAluno;

public class TelaLoginController {

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private void loginAluno(){
        String emailDigitado = campoEmail.getText();
        String senhaDigitada = campoSenha.getText();

        Aluno logarAluno = AutenticarAluno.login(emailDigitado, senhaDigitada);

        if (logarAluno != null){
            System.out.println("O login funcionou");            
        } else{
            exibirAlertaDeErro("A senha ou o email estão incorretos.");
        }
    }

    private void exibirAlertaDeErro(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de Login");
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
