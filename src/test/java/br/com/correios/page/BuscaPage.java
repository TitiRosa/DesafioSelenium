package br.com.correios.page;

import br.com.correios.core.BasePage;
import br.com.correios.core.DriverFactory;
import org.openqa.selenium.By;

public class BuscaPage extends BasePage{

    public void setEndereco(String endereco){

        escrever("endereco", endereco);
    }

    public void buscar(){

        clicarBotao(By.id("btn_pesquisar"));
    }
    public void novaBusca(){

        clicarBotao(By.id("btn_voltar"));
    }

    public String obterMensagemBusca() throws InterruptedException {
    buscar();
    Thread.sleep(5000);
    return DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"mensagem-resultado\"]")).getText();
    }

    public String obterMensagemErro(){
    buscar();
    return DriverFactory.driver.findElement(By.xpath("//div[@id=\"alerta\"]")).getText();
    }
}
