package br.com.Selenium_Grid_Curso;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrame {


@Test
public void deveInteragirComAlertSimples() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        //Mudar foco, para pegar somente o frame. Pois ele não vai entender, pois está dentro do Frame.
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();

        //Identificar o alerta
        Alert alert= driver.switchTo().alert();
        String msg=alert.getText();
        Assert.assertEquals("Frame OK!",msg); //Valida se tem a messagem de OKK
        alert.accept(); //Confirma

        //Trazer de volta o foco para página inicial
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

        driver.quit();


}
} //Fim da Classe