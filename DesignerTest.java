package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DesignerTest {

    @Test
    void deveNotificarUmDesigner() {
        ProjetoDesign projeto = new ProjetoDesign("Logo Empresa X", "Empresa X");
        Designer designer = new Designer("Designer 1");
        designer.inscrever(projeto);
        projeto.publicarFeedback();
        assertEquals("Designer 1, novo feedback publicado no ProjetoDesign{nome='Logo Empresa X', cliente='Empresa X'}", designer.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariosDesigners() {
        ProjetoDesign projeto = new ProjetoDesign("Identidade Visual", "Startup Y");
        Designer d1 = new Designer("Designer 1");
        Designer d2 = new Designer("Designer 2");
        d1.inscrever(projeto);
        d2.inscrever(projeto);
        projeto.publicarFeedback();
        assertEquals("Designer 1, novo feedback publicado no ProjetoDesign{nome='Identidade Visual', cliente='Startup Y'}", d1.getUltimaNotificacao());
        assertEquals("Designer 2, novo feedback publicado no ProjetoDesign{nome='Identidade Visual', cliente='Startup Y'}", d2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarDesignerNaoInscrito() {
        ProjetoDesign projeto = new ProjetoDesign("Redesign App", "Empresa Z");
        Designer d1 = new Designer("Designer 1");
        projeto.publicarFeedback();
        assertNull(d1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteDesignersInscritosNoProjetoCorreto() {
        ProjetoDesign projetoA = new ProjetoDesign("Landing Page", "Cliente A");
        ProjetoDesign projetoB = new ProjetoDesign("Catálogo Digital", "Cliente B");

        Designer d1 = new Designer("Designer 1");
        Designer d2 = new Designer("Designer 2");

        d1.inscrever(projetoA);
        d2.inscrever(projetoB);

        projetoA.publicarFeedback();

        assertEquals("Designer 1, novo feedback publicado no ProjetoDesign{nome='Landing Page', cliente='Cliente A'}", d1.getUltimaNotificacao());
        assertNull(d2.getUltimaNotificacao());
    }
}