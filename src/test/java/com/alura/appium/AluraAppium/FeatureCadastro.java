package com.alura.appium.AluraAppium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.alura.appium.AluraAppium.PageObjects.CadastroPageObjetc;
import com.alura.appium.AluraAppium.PageObjects.DetalheProdutoPageObject;
import com.alura.appium.AluraAppium.PageObjects.ListaProdutosPageObject;
import com.alura.appium.AluraAppium.PageObjects.LoginPageObject;
import com.alura.appium.AluraAppium.PageObjects.PagamentoPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class FeatureCadastro 
{

    @Test
    public void naoConsigoCadastrarUsuarioComSenhasQueNaoConferem() throws MalformedURLException
    {
    	AppiumDriver driver = AppiumDriverConfig.Intance().driver;

    	LoginPageObject loginPage = new LoginPageObject(driver);
    	loginPage.buscarElementos();
    	
    	CadastroPageObjetc cadastroPage = loginPage.irTelaDeCadastro();
    	cadastroPage.buscarElementos();
    	cadastroPage.cadastrar("Luciano", "123", "321");
    	
    	assertEquals("Senhas não conferem", cadastroPage.verificarMensagemDeErro());
    	driver.navigate().back();
    }
    
    @Test
    public void naoPossoCadastrarUsuarioQueJaFoiCadastrado() {
    	
    	AppiumDriver driver = AppiumDriverConfig.Intance().driver;
    	
    	LoginPageObject loginPage = new LoginPageObject(driver);
    	loginPage.buscarElementos();
    	
    	CadastroPageObjetc cadastroPage = loginPage.irTelaDeCadastro();
    	cadastroPage.buscarElementos();
    	
    	loginPage = cadastroPage.cadastrar("Luciano", "123", "123");
    	loginPage.buscarElementos();
    	
    	ListaProdutosPageObject listaProdutos = loginPage.logar("Luciano", "123");
    	listaProdutos.buscarElementos();
    	
    	loginPage = listaProdutos.deslogar();
    	
    	loginPage.buscarElementos();
    	
    	cadastroPage = loginPage.irTelaDeCadastro();
    	cadastroPage.buscarElementos();
    	cadastroPage.cadastrar("Luciano", "qualquer", "qualquer");
    	
    	assertEquals("Usuario já Cadastrado", cadastroPage.verificaUsuarioJaCadastrado());
    	driver.navigate().back();
    }
    
    @Test
    public void naoDeveRealizarLoginComSenhaOuUsuarioInvalido() {
    	
    	AppiumDriver driver = AppiumDriverConfig.Intance().driver;
    	LoginPageObject loginPage = new LoginPageObject(driver);
    	loginPage.buscarElementos();
    	
    	loginPage.logar("Fulano", "123");
    	assertEquals("Usuário ou senha inválidos", loginPage.verificaUsuarioInvalido());
    	
    	loginPage.logar("Luciano", "11111111");
    	assertEquals("Usuário ou senha inválidos", loginPage.verificaSenhaInvalido());
    	
    }
    
    @Test
    public void deveComprarUmProdutoEEssePagamentoAparecerNaTelaDePagamentos() {
    	AppiumDriver driver = AppiumDriverConfig.Intance().driver;
    	
    	LoginPageObject loginPage = new LoginPageObject(driver);
    	loginPage.buscarElementos();
    	
    	ListaProdutosPageObject listaProdutos = loginPage.logar("Luciano", "123");
    	listaProdutos.buscarElementos();
    	
    	DetalheProdutoPageObject detalheProdutos = listaProdutos.selecionarProduto();
    	detalheProdutos.buscarElementos();
    	
    	PagamentoPageObject pagamento = detalheProdutos.comprar();
    	pagamento.buscarElementos();
    	
    	listaProdutos = pagamento.comprarItem("12345123456", "05/2022", "555");
    	listaProdutos.buscarElementos();
    	
    	loginPage = listaProdutos.deslogar();
    	loginPage.buscarElementos();
    }
    
    
}
