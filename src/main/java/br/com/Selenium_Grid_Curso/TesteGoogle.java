package br.com.Selenium_Grid_Curso;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void testeDeAcessoGoogle() {
		
		//Caso não tenha configurado nas variáveis de ambiente, terá de colocar o caminho
		//System.setProperty("webdriver.gecko.driver", "/xampp/htdocs/CURSOS_WELLINGTON/CURSOS_UDEMY/Drivers/geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver(); //instanciar o driver
		
		driver.get("http://www.google.com.br");
		
		System.out.println(driver.getTitle());
		
		
	}

}
