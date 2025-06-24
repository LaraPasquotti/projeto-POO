package projetoPOO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoPOO.filter.AvaliacaoPorNomeFilter;
import projetoPOO.model.Atividade;
import projetoPOO.model.Avaliacao;
import projetoPOO.model.Disciplina;
import projetoPOO.model.Prova;

public class projetoPOOTest {

    private Disciplina disciplina;

    @BeforeEach
    void setup() {
        disciplina = new Disciplina("Cálculo", 10, 0);
    }

    /**
     * Testa o método calcularMedia() quando não tem avaliações existentes
     */
    @Test
    void calculaMediaSemAvaliacao() {
        assertEquals(0.0, disciplina.calcularMedia());
    }

    /**
     * Testa o método calcularMedia() quando tem avaliações existentes
     */
    @Test
    void calculaMediaComAvaliacao() {
        Atividade a1 = new Atividade("Atividade1", LocalDate.now(), disciplina, 2.0);
        a1.setNota(8.0);
        Prova p1 = new Prova("Prova1", LocalDate.now(), disciplina, 3.0);
        p1.setNota(6.0);

        disciplina.adicionarAvaliacao(p1);
        disciplina.adicionarAvaliacao(a1);

        assertEquals(6.8, disciplina.calcularMedia(), 1e-9, "Cálculo incorreto");
    }

    /**
     * Testa os métodos de adicionar e remover faltas
     */
    @Test
    void adicionarERemoverFaltas() {
        assertEquals(0, disciplina.getFaltasAtuais());
        disciplina.adicionarFaltas(1);
        assertEquals(1, disciplina.getFaltasAtuais());
        disciplina.removerFaltas();
        assertEquals(0, disciplina.getFaltasAtuais());
    }

    /**
     * Testa os métodos de adicionar e remover avaliação
     */
    @Test
    void adicionarERemoverAvaliacao() {
        Atividade a2 = new Atividade("Atividade2", LocalDate.now(), disciplina, 1.0);
        assertTrue(disciplina.getAvaliacoes().isEmpty());
        disciplina.adicionarAvaliacao(a2);
        assertEquals(1, disciplina.getAvaliacoes().size());
        disciplina.removerAvaliacao(a2);
        assertTrue(disciplina.getAvaliacoes().isEmpty());
    }

    /**
     * Testa o método compareTo() para ordenar avaliações por data de entrega
     */
    @Test
    void compareToPorData() {
        Atividade atvAntiga = new Atividade("Atividade Antiga", LocalDate.of(2022, 8, 1), disciplina, 1.0);
        Atividade atvNova = new Atividade("Nova Atividade", LocalDate.of(2025, 6, 25), disciplina, 1.0);
        assertTrue(atvNova.compareTo(atvAntiga) > 0);
        assertTrue(atvAntiga.compareTo(atvNova) < 0);
    }

    /**
     * Testa o formato da String no método toString
     */
    @Test
    void toStringTest() {
        Prova p2 = new Prova("P2", LocalDate.of(2025, 7, 3), disciplina, 2.5);
        assertEquals("P2 - Entrega: 2025-07-03", p2.toString());
    }

    /**
     * Testa o filtro AvaliacaoPorNomeFilter()
     */
    @Test
    void AvaliacaoPorNomeFilterTest() {
        Disciplina d = new Disciplina("Álgebra Linear", 10, 0);
        Avaliacao a1 = new Atividade("Atividade 1", LocalDate.now(), d, 1);
        Avaliacao a2 = new Atividade("Atividade 2", LocalDate.now(), d, 1);
        Avaliacao a3 = new Atividade("Atividade 3", LocalDate.now(), d, 1);

        AvaliacaoPorNomeFilter filter = new AvaliacaoPorNomeFilter("Atividade 1");
        List<Avaliacao> resultado = filter.meetCriteria(Arrays.asList(a1, a2, a3));

        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(a1));
        assertFalse(resultado.contains(a3));
        assertFalse(resultado.contains(a2));
    }

}
