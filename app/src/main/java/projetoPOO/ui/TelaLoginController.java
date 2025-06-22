package projetoPOO.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projetoPOO.model.Aluno;
import projetoPOO.model.AutenticarAluno;

/**
 * Contém a estrutura de implementação de um controller para a tela de login
 * 
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class TelaLoginController {
    private Aluno alunoLogado;
    
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

    /**
     * Retorna o aluno que está logado
     * @return aluno logado
     */
    public Aluno getAlunoLogado(){
        return this.alunoLogado;
    }

}
