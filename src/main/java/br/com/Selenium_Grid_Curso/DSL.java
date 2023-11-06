package br.com.Selenium_Grid_Curso;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/** Classe java, que reutiliza métodos que usam a mesma execuçaõ de teste*/

public class DSL {

    /**Instanciando uma variável global*/
    private WebDriver driver;

    /**Contrutor do Driver*/
    public DSL(WebDriver driver) {
        this.driver = driver;
    }


    //Métodos para escrever textos
    public void escreve(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }// fim do método escreve da DSl

    //Métodos para Asserção do escrever textos
    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicaRadio(String id) {
        driver.findElement(By.id(id)).click();
    }
    public boolean isRadioMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor){
        //Buscar os elementos
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element); //Seleciono um elemento

        //combo.selectByIndex(5); //Seleciona o elemento 3
        combo.selectByValue(valor); // Seleciona pelo valor
        //combo.selectByVisibleText("Superior"); // (IDEAL) Valida se valor do campo é mesmo que usuário visualiza
    }


}
