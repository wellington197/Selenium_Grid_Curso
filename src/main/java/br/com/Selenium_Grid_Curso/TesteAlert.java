package br.com.Selenium_Grid_Curso;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {

    @Test
    public void deveInteragirComAlertSimples() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto


        driver.findElement(By.id("alert")).click();

        //Alert fica externo a página. Pedir selenium para trocar foco para alerta
        Alert alert=driver.switchTo().alert();
        String texto=alert.getText();
        Assert.assertEquals("Alert Simples",texto);

        //Aceita alerta para fechar modal
        alert.accept();

        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

        driver.quit();


    }
    @Test
    public void deveInteragirComAlertConfirma() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto


        driver.findElement(By.id("confirm")).click();

        //Alert fica externo a página. Pedir selenium para trocar foco para alerta
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples",alert.getText());

        //Aceita alerta para fechar modal
        alert.accept();
        Assert.assertEquals("Confirmado",alert.getText());
        alert.accept();







        driver.findElement(By.id("confirm")).click();
        //Alert fica externo a página. Pedir selenium para trocar foco para alerta
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples",alerta.getText());

        //Aceita alerta para fechar modal
        alert.dismiss();
        Assert.assertEquals("Negado",alerta.getText());
        alert.dismiss();
        driver.quit();



    }



    @Test
    public void deveInteragirComPrompt() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto


        driver.findElement(By.id("confirm")).click();


}
