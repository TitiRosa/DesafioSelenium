package br.com.correios.tests;

import br.com.correios.core.BaseTest;
import br.com.correios.core.DriverFactory;
import br.com.correios.page.BuscaPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.correios.core.DriverFactory.driver;
import static org.junit.Assert.assertEquals;

public class BuscaTest extends BaseTest {

    private BuscaPage page;

    public BuscaTest() {

        page = new BuscaPage();
    }

    @Before
    public void acessarTela() {
        DriverFactory.getDriver().get("https://buscacepinter.correios.com.br/app/endereco/index.php");
    }

    @Test
    public void testDeveBuscarPorEndereco() throws InterruptedException {
        page.setEndereco("Rua Manoel Marinho da Cunha");
        assertEquals("Resultado da Busca por Endereço ou CEP", page.obterMensagemBusca());
    }

    @Test
    public void testDeveBuscarPorCep() throws InterruptedException {
        page.setEndereco("94810360");
        assertEquals("Resultado da Busca por Endereço ou CEP", page.obterMensagemBusca());

    }

    @Test
    public void testNovaBusca() throws InterruptedException {
        page.setEndereco("Rua Manoel Marinho da Cunha");
        assertEquals("Resultado da Busca por Endereço ou CEP", page.obterMensagemBusca());
        page.novaBusca();

    }

    @Test
    public void testDeveBuscarSemInformacao() {
        page.obterMensagemErro();
        assertEquals("Informe o Endereço com no mínimo 2(dois) caracteres!", page.obterMensagemErro());
    }

    @Test
    public void testCepInvalido() throws InterruptedException {
        page.setEndereco("254160000");
        WebDriverWait Wait = new WebDriverWait(driver, 30);
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mensagem-resultado")));
        assertEquals("Não há dados a serem exibidos", page.obterMensagemBusca());

    }

}
