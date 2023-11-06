package br.com.Selenium_Grid_Curso;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class TesteCampoTreinamento {

    /**Instanciando uma variável global*/
    private WebDriver driver;
    private DSL dsl;

    @Before
    /**Inicia o drive*/
    public void inicializa(){

        //Caso não tenha configurado nas variáveis de ambiente, terá de colocar o caminho
        //System.setProperty("webdriver.gecko.driver", "/xampp/htdocs/CURSOS_WELLINGTON/CURSOS_UDEMY/Drivers/geckodriver.exe");
        /*-----Prepara Cenário necessário para executar os testes-----*/

        /*INSTANCIAR OS DRIVERS*/
        driver=new FirefoxDriver(); //instanciar o driver do FIREFOX
        //WebDriver driver=new ChromeDriver(); //instanciar o driver do CHROME
        //WebDriver driver=new EdgeDriver(); //instanciar o driver do EDGE
        //WebDriver driver=new InternetExplorerDriver(); //instanciar o driver do IE

        //Abre a tela de acordo com essa dimensão
        driver.manage().window().setSize(new Dimension(960,765));

        //Acesso ao site pelo protocolo
        // Usa um caminho dinâmico, onde busca software pela pasta raiz do projeto
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
        //System.out.println(driver.getTitle());

        /*Iniciar a DSL*/
        dsl = new DSL(driver);

    }
    @After
    /**Fechar o drive*/
    public void finalizar(){

        driver.quit();
    }

    @Test
    public void testeTextField() {
        /**Padrão DSL*/
        dsl.escreve("elementosForm:sobrenome","Teste de inserção de texto");
        Assert.assertEquals("Teste de inserção de texto",
                dsl.obterValorCampo("elementosForm:sobrenome"));

        /**Padrão sem reuso


        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste de inserção de texto");
        //Pegar o texto do campo para validar
        //--------Verificação--------
        Assert.assertEquals("Google",driver.getTitle());

        //fechar browser ap&oacute;s os testes
        driver.quit();

        */
    }
    @Test
    public void InteracaoComTextArea() {
        dsl.escreve("elementosForm:sugestoes","Teste de inserção de texto\n\nTeste de pular linha no campo");
        Assert.assertEquals("Teste de inserção de texto\n\nTeste de pular linha no campo",dsl.obterValorCampo("elementosForm:sugestoes"));


        /** Padrão sem reuso

        //EXECUÇÃO
        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de inserção de texto\n\nTeste de pular linha no campo");


        //VERIFICAÇÃo
        Assert.assertEquals("Teste de inserção de texto\n\nTeste de pular linha no campo", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        //fechar browser ap&oacute;s os testes
        //driver.quit();

         */
    }
    @Test
    public void DeveInteragirComRadioButton() {
       dsl.clicaRadio("elementosForm:sexo:0");
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        /**Padrão sem reuso
        //--------EXECUÇÃO--------/

        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:sexo:0")).click(); // Faz o clique no Radio Button


        //--------VERIFICAÇÃO--------/
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected()); //Verifica se está selecionado

        //fechar browser ap&oacute;s os testes
        //driver.quit();
        */
    }

    @Test
    public void DeveInteragirComCheckbox() {
        dsl.clicaRadio("elementosForm:comidaFavorita:2");
        dsl.isRadioMarcado("elementosForm:comidaFavorita:2");

        /** Padrão sem reuso
         *
        //EXECUÇÃO
        //Interagindo com campo de tipo texto
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click(); // Faz o clique no Radio Button

        //-VERIFICAÇÃO
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected()); //Verifica se está selecionado

        //fechar browser ap&oacute;s os testes
        //driver.quit();

         */
    }
    @Test
    public void DeveInteragirComComboBox() {



        /** Padrão sem reuso

            //--------EXECUÇÃO--------

            //Buscar os elementos
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element); //Seleciono um elemento

            //combo.selectByIndex(5); //Seleciona o elemento 3
            combo.selectByValue("superior"); // Seleciona pelo valor
            //combo.selectByVisibleText("Superior"); // (IDEAL) Valida se valor do campo é mesmo que usuário visualiza


            //--------VERIFICAÇÃO--------
            Assert.assertEquals("Superior",combo.getFirstSelectedOption().getText());


            //driver.quit(); //fechar browser ap&oacute;s os testes

        */
    }

    @Test
    public void DeveVerificarValoresCombo() {

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

        //driver.quit();


    }// Fim da DeveVerificarValoresComboBox
    @Test
    public void DeveVerificarValoresComboMultiplo() {

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
        //driver.quit();

    }

    @Test
    public void deveInteragirComBotoes() {

        WebElement botao= driver.findElement(By.id("buttonSimple"));

        botao.click();
        Assert.assertEquals("Obrigado!",botao.getAttribute("value"));

        //driver.quit();



    }
    @Test
    @Ignore //Não execute assert
    public void deveInteragirComLinks() {

       driver.findElement(By.linkText("Voltar")).click();

       Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());

        //driver.quit();

    }

    @Test
    public void deveBuscarTextoNaPágina() {

        /**Opção tipo true para campo de texto não é ideal. Pois ela seleciona a primeira que aparecer*/
        //Assert.assertTrue(driver.findElement(By.tagName("body"))
            // .getText().contains("Campo de treinamentos"));


        /**Buscando pela Tag H3*/
        Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3"))
                .getText());

        /**Buscando pela class o span*/
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar"))
                .getText());

        //driver.quit();

    }


} //Fim da classe teste de campo de treinamento
