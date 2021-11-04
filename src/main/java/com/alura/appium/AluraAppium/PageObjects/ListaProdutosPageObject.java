package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ListaProdutosPageObject extends PageObjectBase {

	private MobileElement botaoPagamento;
	private By botaoPagamentoID;
	private By botaoDeslogarID;
	private MobileElement botaoDeslogar;
	private By produtoBolaDeFutebolID;
	private MobileElement produtoBolaDeFutebol;

	public ListaProdutosPageObject(AppiumDriver driver) {
		super(driver);
		botaoPagamentoID = By.id("br.com.alura.aluraesporte:id/listaPagamentos");
		botaoDeslogarID = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
		produtoBolaDeFutebolID = By.id("br.com.alura.aluraesporte:id/item_produto_nome");
		
	}

	@Override
	public void buscarElementos() {
		// TODO Auto-generated method stub
		botaoPagamento = (MobileElement)driver.findElement(botaoPagamentoID);
		botaoDeslogar = (MobileElement)driver.findElement(botaoDeslogarID);
		produtoBolaDeFutebol = (MobileElement)driver.findElement(produtoBolaDeFutebolID);
	}

	public LoginPageObject deslogar() {
		// TODO Auto-generated method stub
		botaoDeslogar.click();
		return new LoginPageObject(this.driver);
	}

	public DetalheProdutoPageObject selecionarProduto() {
		// TODO Auto-generated method stub
		produtoBolaDeFutebol.click();
		return new DetalheProdutoPageObject(this.driver);
	}
	
	
	
	
}
