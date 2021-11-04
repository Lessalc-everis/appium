package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObjectBase {
	
	private MobileElement botaoCadastro;
	private MobileElement usuarioCadastrado;
	private MobileElement senhaCadastrada;
	private MobileElement botaoLogar;
	private By usuarioSenhaInvalidaId;
	private MobileElement senhaUsuarioInvalidos;

	public LoginPageObject(AppiumDriver driver) {
		super(driver);
		usuarioSenhaInvalidaId = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
	}
	
	@Override
	public void buscarElementos() {
		botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		usuarioCadastrado = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
    	senhaCadastrada = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
    	botaoLogar = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
	}

	public CadastroPageObjetc irTelaDeCadastro() {
		botaoCadastro.click();
		return new CadastroPageObjetc(this.driver);
	}
	
	private void preencher(String usuario, String senha) {
		usuarioCadastrado.setValue(usuario);
		senhaCadastrada.setValue(senha);
	}

	public ListaProdutosPageObject logar(String usuario, String senha) {
		preencher(usuario, senha);
		botaoLogar.click();
		return new ListaProdutosPageObject(this.driver);
	}

	public String verificaUsuarioInvalido() {
		WebDriverWait espera = new WebDriverWait(driver, 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(usuarioSenhaInvalidaId));
		senhaUsuarioInvalidos = (MobileElement)driver.findElement(usuarioSenhaInvalidaId);
		return senhaUsuarioInvalidos.getText();
	}

	public String verificaSenhaInvalido() {
		WebDriverWait espera = new WebDriverWait(driver, 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(usuarioSenhaInvalidaId));
		senhaUsuarioInvalidos = (MobileElement)driver.findElement(usuarioSenhaInvalidaId);
		return senhaUsuarioInvalidos.getText();
	}

}
