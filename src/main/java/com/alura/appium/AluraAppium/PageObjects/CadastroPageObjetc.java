package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;

public class CadastroPageObjetc extends PageObjectBase{

	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfirmaSenha;
	private MobileElement botaoCadastrar;
	private MobileElement retornoCadastro;
	private MobileElement usuarioCadastrado;
	private final By erroId;
	private final By campoNomeId;
	private final By campoSenhaId;
	private final By campoConfirmaSenhaId;
	private final By botaoCadastrarId;
	private By usuarioCadastradoId;

	public CadastroPageObjetc(AppiumDriver driver) {
		super(driver);
		erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		usuarioCadastradoId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
		campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
		campoConfirmaSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
			
	}
	
	@Override
	public void buscarElementos() {
		campoNome = (MobileElement)driver.findElement(campoNomeId);
    	campoSenha = (MobileElement)driver.findElement(campoSenhaId);
    	campoConfirmaSenha = (MobileElement)driver.findElement(campoConfirmaSenhaId);
    	botaoCadastrar = (MobileElement)driver.findElement(botaoCadastrarId);
	}
	
	private void preencherOFormulario(String usuario, String senha, String confirmaSenha){
		campoNome.setValue(usuario);
    	campoSenha.setValue(senha);
    	campoConfirmaSenha.setValue(confirmaSenha);
	}
	
	public LoginPageObject cadastrar(String usuario, String senha, String confirmaSenha) {
		preencherOFormulario(usuario, senha, confirmaSenha);
		botaoCadastrar.click();
		return new LoginPageObject(this.driver);
	}
	
	
	public String verificarMensagemDeErro() {
		WebDriverWait espera = new WebDriverWait(driver, 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(erroId));
		retornoCadastro = (MobileElement)driver.findElement(erroId);
		return retornoCadastro.getText();
	}
	
	
	public String verificaUsuarioJaCadastrado() {
		WebDriverWait espera = new WebDriverWait(driver, 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(usuarioCadastradoId));
		usuarioCadastrado = (MobileElement)driver.findElement(usuarioCadastradoId);
		return usuarioCadastrado.getText();
	}
	
	
	
	
	
}
