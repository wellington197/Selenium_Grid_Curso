package br.com.Selenium_Grid_Curso;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

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

        //combo.selectByIndex(5); //Seleciona o elemento 3
        combo.selectByValue("superior"); // Seleciona pelo valor
        //combo.selectByVisibleText("Superior"); // (IDEAL) Valida se valor do campo é mesmo que usuário visualiza


        /*--------VERIFICAÇÃO--------*/
        Assert.assertEquals("Superior",combo.getFirstSelectedOption().getText());


        //driver.quit(); //fechar browser ap&oacute;s os testes
    }

    @Test
    public void DeveVerificarValoresCombo() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Buscar os elementos
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element); //Seleciono um elemento

        //cria uma lista
        List<WebElement> options = combo.getOptions(); //Todas as opções para aquele select

        Assert.assertEquals(8,options.size()); //Verifica o tamanho das opções

        boolean encontrou=false;

        for(WebElement option: options){
            if (option.getText().equals("Mestrado")){
                encontrou=true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }// Fim da DeveVerificarValoresComboBox
    @Test
    public void DeveVerificarValoresComboMultiplo() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /*--------EXECUÇÃO--------*/

        //Buscar os elementos
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element); //Seleciono um elemento

        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");


        /*--------ASSERT--------*/

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3,allSelectedOptions.size()); // valida se foi selecionado os 3 itens do combo


        /*--------ASSERT--------*/ //Ao desmarcar um item
        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2,allSelectedOptions.size()); // valida se foi selecionado os 2 itens do combo

        }

    @Test
    public void deveInteragirComBotoes() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        WebElement botao= driver.findElement(By.id("buttonSimple"));

        botao.click();
        Assert.assertEquals("Obrigado!",botao.getAttribute("value"));


    }
    @Test
    @Ignore //Não execute assert
    public void deveInteragirComLinks() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

       driver.findElement(By.linkText("Voltar")).click();

       Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());
    }

    @Test
    public void deveBuscarTextoNaPágina() {
        /*-----PREPARAÇÃO-----*/
        WebDriver driver = new FirefoxDriver(); //instanciar o driver do FIREFOX
        driver.manage().window().setSize(new Dimension(1250, 765));//Abre a tela de acordo com essa dimensão
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");// Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto

        /**Opção tipo true para campo de texto não é ideal. Pois ela seleciona a primeira que aparecer*/
        //Assert.assertTrue(driver.findElement(By.tagName("body"))
            // .getText().contains("Campo de treinamentos"));


        /**Buscando pela Tag H3*/
        Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3"))
                .getText());

        /**Buscando pela class o span*/
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar"))
                .getText());
    }



} //Fim da classe teste de campo de treinamento
