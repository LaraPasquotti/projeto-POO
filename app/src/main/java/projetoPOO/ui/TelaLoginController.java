package projetoPOO.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetoPOO.model.Aluno;
import projetoPOO.model.AutenticarAluno;

/**
 * Contém a estrutura de implementação de um controller para a tela de login
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaLoginController {
    protected static Aluno alunoLogado;
    
    @FXML
    /**
     * Campo de texto para o email
     */
    private TextField campoEmail;

    /**
     * Campo de texto para a senha
     */
    @FXML
    private TextField campoSenha;

    /**
     * Botão para logar
     */
    @FXML
    private Button btnLogin;

    @FXML
    /**
     * Método de logar
     */
    private void loginAluno(ActionEvent event){
        String emailDigitado = campoEmail.getText().trim();
        String senhaDigitada = campoSenha.getText().trim();

        Aluno logarAluno = AutenticarAluno.login(emailDigitado, senhaDigitada);

        if (logarAluno != null){
            this.alunoLogado = logarAluno;
            System.out.println("O login funcionou");    
            
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        } else{
            exibirAlertaDeErro("A senha ou o email estão incorretos.");
        }
    }

    /**
     * Método de exibir um alerta de erro caso a senha e/ou o email estejam errados
     */
    private void exibirAlertaDeErro(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de Login");
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
