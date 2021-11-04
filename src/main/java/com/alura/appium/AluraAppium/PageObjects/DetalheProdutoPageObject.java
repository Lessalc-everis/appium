package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DetalheProdutoPageObject extends PageObjectBase{

	private By botaoComprarID;
	private MobileElement botaoComprar;

	public DetalheProdutoPageObject(AppiumDriver driver) {
		super(driver);
		botaoComprarID = By.id("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
	}
	
	@Override
	public void buscarElementos() {
		botaoComprar = (MobileElement)driver.findElement(botaoComprarID);
	}
	
	public PagamentoPageObject comprar() {
		botaoComprar.click();
		return new PagamentoPageObject(this.driver);
	}
			
	
}
