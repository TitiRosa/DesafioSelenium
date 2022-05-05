package br.com.correios.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BasePage {

    /************TextField e TextArea ******************/
    public void escrever(By by, String texto){
        DriverFactory.driver.findElement(by).clear();
        DriverFactory.driver.findElement(by).sendKeys(texto);
    }

    public void escrever(String id_campo, String texto){

        escrever(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo){
        return DriverFactory.driver.findElement(By.id(id_campo)).getAttribute("value");

    }

    /*********** Combo ************/

    public void selecionarCombo(String id, String valor){
        WebElement element = DriverFactory.driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

       /*************** Botao ****************/
    public void clicarBotao(By by){
        DriverFactory.driver.findElement(by).click();

    }


}



