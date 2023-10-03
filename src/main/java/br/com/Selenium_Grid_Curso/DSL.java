package br.com.Selenium_Grid_Curso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
    /**Ficar atento a 3 pontos importantes
     * Driver - Criar a instância do driver
     * */

    private WebDriver driver; //instância

    /**Construtor*/
    public DSL (WebDriver driver){
        this.driver = driver;
    }


    public void escreve(String id_campo, String texto){
        driver.findElement(By.id(id_campo)).sendKeys(texto);

    }
    public String obterValorCampo(String id_campo){
        return driver.findElement(By.id(id_campo)).getAttribute("value");

    }
}
