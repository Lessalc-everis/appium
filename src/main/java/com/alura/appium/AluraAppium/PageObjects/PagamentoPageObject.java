package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagamentoPageObject extends PageObjectBase{
	
	private By numeroCartaoID;
	private By dataValidadeID;
	private By cvcID;
	private By botaoConfirmarPagamentoID;
	private MobileElement numeroCartao;
	private MobileElement dataValidade;
	private MobileElement cvc;
	private MobileElement botaoConfirmarPagamento;

	public PagamentoPageObject(AppiumDriver driver) {
		super(driver);
		numeroCartaoID = By.id("br.com.alura.aluraesporte:id/pagamento_numero_cartao");
		dataValidadeID = By.id("br.com.alura.aluraesporte:id/pagamento_data_validade");
		cvcID = By.id("br.com.alura.aluraesporte:id/pagamento_cvc");
		botaoConfirmarPagamentoID = By.id("br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento");
	}
	
	@Override
	public void buscarElementos() {
		numeroCartao = (MobileElement)driver.findElement(numeroCartaoID);
		numeroCartao = numeroCartao.findElementByClassName("android.widget.EditText");
		
		dataValidade = (MobileElement)driver.findElement(dataValidadeID);
		dataValidade = dataValidade.findElementByClassName("android.widget.EditText");
		
		cvc = (MobileElement)driver.findElement(cvcID);
		cvc = cvc.findElementByClassName("android.widget.EditText");
		
		botaoConfirmarPagamento = (MobileElement)driver.findElement(botaoConfirmarPagamentoID);
	}
	
	public ListaProdutosPageObject comprarItem(String cartao, String validade, String cvcnumber) {
		numeroCartao.setValue(cartao);
		dataValidade.setValue(validade);
		cvc.setValue(cvcnumber);
		botaoConfirmarPagamento.click();
		return new ListaProdutosPageObject(this.driver);
	}
	
	

}
