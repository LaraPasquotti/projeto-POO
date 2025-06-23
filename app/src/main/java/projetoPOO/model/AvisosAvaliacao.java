package projetoPOO.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de uma classe Avisos de avalicao
 *
 * @author Lara Pasquotti, Isabel Cristina e Lucas Nunes
 */
public class AvisosAvaliacao implements Avisos {

    @Override
    public void ntoficacoes(String mensagem) {
    }

    /**
     * Método para mostrar um aviso se uma avaliação está próxima
     *
     * @param avaliacoes lista completa de avaliações do aluno
     * @return mensagem de alerta ou null se não houver avisos
     */
    public static String verificarPrazos(List<Avaliacao> avaliacoes) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.plusDays(5);

        List<Avaliacao> avaliacoesProximas = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacoes) {
            LocalDate dataEntrega = avaliacao.getDataEntrega();

            if (dataEntrega.isAfter(hoje.minusDays(1)) && dataEntrega.isBefore(dataLimite)) {
                avaliacoesProximas.add(avaliacao);
            }
        }

        if (!avaliacoesProximas.isEmpty()) {
            StringBuilder mensagem = new StringBuilder();

            for (Avaliacao avaliacaoProxima : avaliacoesProximas) {
                mensagem.append("- ").append(avaliacaoProxima.toString()).append("\n");
            }
            return mensagem.toString();
        }
        return null;
    }
}
