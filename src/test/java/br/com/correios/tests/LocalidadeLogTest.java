package br.com.correios.tests;

import br.com.correios.core.BaseTest;
import br.com.correios.core.DriverFactory;
import br.com.correios.page.LocalidadePage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalidadeLogTest extends BaseTest {


    private LocalidadePage page;


    public LocalidadeLogTest(){
        page = new LocalidadePage();
    }

    @Before
    public void acessarTela(){
        DriverFactory.getDriver().get("https://buscacepinter.correios.com.br/app/localidade_logradouro/index.php");

    }

    @Test
    public void testInserirBusca() throws InterruptedException {
        assertEquals("Resultado da Busca por Localidade/Logradouro", page.obterMensagemSucesso());
    }

    @Test
    public void testInserirNovaBusca() throws InterruptedException {
        assertEquals("Resultado da Busca por Localidade/Logradouro", page.obterMensagemSucesso());
        page.novaBusca();
    }

    @Test
    public void testNaoInserirUf(){
        page.buscar();
        page.obterMensagemErro();
        assertEquals("Selecione a UF!", page.obterMensagemErro());

    }

    @Test
    public void testNaoInserirLocalidade(){
        page.selecionarUf();
        page.buscar();
        page.obterMensagemErro();
        assertEquals("Informe o nome completo da Cidade/Município/Distrito/Povoado!", page.obterMensagemErro());

    }

    @Test
    public void testNaoInserirLogradouro(){
        page.selecionarUf();
        page.setLocalidade("Alvorada");
        page.buscar();
        page.obterMensagemErro();
        assertEquals("Informe o nome do Logradouro!", page.obterMensagemErro());

    }

    @Test
    public void testAjudaPesquisaLocalidade() throws InterruptedException {
        page.selecionarUf();
        page.ajuda();
        Thread.sleep(5000);
        page.setSelecionarLetraLocalidade();

    }
}
