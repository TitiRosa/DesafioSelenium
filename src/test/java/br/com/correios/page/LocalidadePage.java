package br.com.correios.page;

import br.com.correios.core.BasePage;
import br.com.correios.core.DriverFactory;
import org.openqa.selenium.By;

public class LocalidadePage extends BasePage {

    public void selecionarUf(){

        selecionarCombo("uf", "RS");
    }

    public void setLocalidade(String localidade){

        escrever("localidade", localidade);
    }
   public void setSelecionarLetraLocalidade() throws InterruptedException {
       DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"div_modal_letra_localidade\"]/a[@onclick=\"pesquisar_localidade('', 'A', '', '')\"]")).click();
       Thread.sleep(5000);
       DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"resultado-DNEC-localidade\"]/tbody/tr[23]/td[1]/a")).click();

   }
    public void setLogadouro(String logadouro){

        escrever("logradouro", logadouro);
    }

    public void ajuda(){

        clicarBotao(By.id("ajuda_pesq_localidade"));

    }
    public void buscar(){

        clicarBotao(By.id("btn_pesquisar"));
    }

    public void novaBusca(){

        clicarBotao(By.id("btn_nbusca"));
    }

    public String obterMensagemErro(){
        return DriverFactory.driver.findElement(By.xpath("//div[@id=\"alerta\"]")).getText();
    }

    public String obterMensagemSucesso() throws InterruptedException {
        selecionarUf();
        setLocalidade("Alvorada");
        setLogadouro("Rua Manoel Marinho da Cunha");
        buscar();
        Thread.sleep(5000);
        return DriverFactory.driver.findElement(By.xpath("//div[@id=\"mensagem-resultado\"]/h4")).getText();
                //DriverFactory.driver.findElement(By.id("mensagem-resultado")).getText();;
    }
}
