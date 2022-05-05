package br.com.correios.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    private DriverFactory() {
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (Propriedades.browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
            return driver;
        }

        public static void killDriver(){
            if (driver != null) {
                driver.quit();
                driver = null;
            }


        }
    }