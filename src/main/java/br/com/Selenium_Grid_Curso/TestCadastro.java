package br.com.Selenium_Grid_Curso;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastro {
    @Test
    public void deveInteragirComAlertPrompt() {

        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /**Preenchendo Formulário*/

        driver.findElement(By.id("ElementosForm:nome")).sendKeys("Wagner");
        driver.findElement(By.id("ElementosForm:sobrenome")).sendKeys("Costa");
        driver.findElement(By.id("ElementosForm:sexo:0")).click();
        driver.findElement(By.id("ElementosForm:comidaFavorita:2")).click();

        //selecionando campo de listbox de escolaridade
        new Select(driver.findElement(By.id("ElementosForm:escolaridade")))
                .selectByVisibleText("Mestrado");

        //selecionando campo de listbox de Pratica de esportes
        new Select(driver.findElement(By.id("ElementosForm:esportes")))
                .selectByVisibleText("Natacao");

        driver.findElement(By.id("ElementosForm:cadastrar")).click();


        //Validando se resultado é cadastrado
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
        Assert.assertEquals("Nome: Wagner",driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Costa",driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino",driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza",driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: mestrado",driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao",driver.findElement(By.id("descEsportes")).getText());

        //fechar browser após executar os testes
        driver.quit();
    }
}