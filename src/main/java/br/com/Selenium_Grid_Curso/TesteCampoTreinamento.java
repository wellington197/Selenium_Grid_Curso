package br.com.Selenium_Grid_Curso;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class TesteCampoTreinamento {
    @Test
    public void testeTextField() {

        //Caso não tenha configurado nas variáveis de ambiente, terá de colocar o caminho
        //System.setProperty("webdriver.gecko.driver", "/xampp/htdocs/CURSOS_WELLINGTON/CURSOS_UDEMY/Drivers/geckodriver.exe");


        /*-----Prepara Cenário necessário para executar os testes-----*/

        /*INSTANCIAR OS DRIVERS*/
        WebDriver driver=new FirefoxDriver(); //instanciar o driver do FIREFOX
        //WebDriver driver=new ChromeDriver(); //instanciar o driver do CHROME
        //WebDriver driver=new EdgeDriver(); //instanciar o driver do EDGE
        //WebDriver driver=new InternetExplorerDriver(); //instanciar o driver do IE


        //Abre a tela de acordo com essa dimensão
        driver.manage().window().setSize(new Dimension(1250,765));

        //Acesso ao site pelo protocolo
        // Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
        //System.out.println(driver.getTitle());


        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste de inserção de texto");
        //Pegar o texto do campo para validar
        Assert.assertEquals("Teste de inserção de texto", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
        /*--------Verificação--------*/
        //Assert.assertEquals("Google",driver.getTitle());

        //fechar browser ap&oacute;s os testes
        //driver.quit();
    }
    @Test
    public void InteracaoComTextArea() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver=new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250,765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de inserção de texto\n\nTeste de pular linha no campo");


        /*--------VERIFICAÇÃO--------*/
        Assert.assertEquals("Teste de inserção de texto\n\nTeste de pular linha no campo", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        //fechar browser ap&oacute;s os testes
        //driver.quit();
    }
    @Test
    public void DeveInteragirComRadioButton() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver=new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250,765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sexo:0")).click(); // Faz o clique no Radio Button


        /*--------VERIFICAÇÃO--------*/
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected()); //Verifica se está selecionado

        //fechar browser ap&oacute;s os testes
        //driver.quit();
    }
    @Test
    public void DeveInteragirComComboBox() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver=new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250,765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Buscar os elementos
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element); //Seleciono um elemento

        //combo.selectByIndex(3); //Seleciona o elemento 3
        //combo.selectByValue("superior"); // Seleciona pelo valor
        combo.selectByVisibleText("Superior"); // (IDEAL) Valida se valor do campo é mesmo que usuário visualiza


        /*--------VERIFICAÇÃO--------*/
        Assert.assertEquals("Superior",combo.getFirstSelectedOption().getText());


        //driver.quit(); //fechar browser ap&oacute;s os testes
    }

    @Test
    public void DeveVerificarValoresComboBox() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Buscar os elementos
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element); //Seleciono um elemento

        //cria uma lista
        List<WebElement> options = combo.getOptions();

        Assert.assertEquals(8,options.size());




    }// Fim da DeveVerificarValoresComboBox

} //Fim da classe teste de campo de treinamento
