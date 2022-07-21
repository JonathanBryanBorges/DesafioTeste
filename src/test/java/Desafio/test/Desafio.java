package Desafio.test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.restassured.http.ContentType;

public class Desafio {
	private WebDriver driver;

	public void primeiroMetodo() {
		driver.findElement(By.xpath("//h2[text()='Todos os cursos']"));
	}

	public boolean segundoMetodo() {
		System.setProperty("webdriver.chrome.driver", "E:/Projects/chromedriver.exe");
		driver.get("https://espaco.teste.com.br/login/");
		driver.manage().window().maximize(); 

		try {
			driver.findElement(By.xpath("//input[@name='email']"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean terceiroMetodo() {
		try {
			driver.findElement(By.xpath("//input[@name='password']"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void quartoMetodo() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");
		driver.findElement(By.id("login-btn")).click();
	}

	public void quintoMetedo() {
		baseURI = "https://hml.api.espaco.teste.com.br/signin";
		port = 8089;
		basePath = "/api";
		
		String token = given()
				.body("{\n" + 
						" \"email\": \"User1\", \n" +
						" \"password\": \"123\", \n" +
						"}")
				.contentType(ContentType.JSON)
			.when()
				.post("https://hml.api.espaco.teste.com.br/signin")
			.then()
				.extract()
					.path("data.token");
				
	}

}
