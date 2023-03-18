package br.com.Selenium_Grid_Curso;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {
	
	@Test
	public void testeDeAcessoGoogle() {
		
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

		//Acesso ao site
		driver.get("http://www.google.com");
		//System.out.println(driver.getTitle());


		/*--------Verificação--------*/
		Assert.assertEquals("Google",driver.getTitle());

		//fechar browser ap&oacute;s os testes
		driver.quit();
	}

}
