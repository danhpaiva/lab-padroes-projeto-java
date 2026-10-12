package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;
import subsistema1.crm.CrmService;
import subsistema1.crm.ICrmService;
import subsistema2.cep.CepApi;
import subsistema2.cep.ICepService;

public class Test {

	public static void main(String[] args) {
		
		// Singleton
		System.out.println("--- Testando Singleton ---");
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		// Strategy
		System.out.println("\n--- Testando Strategy ---");
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento normal = new ComportamentoNormal();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		robo.mover();
		
		// Facade (Com Injeção de Dependências)
		System.out.println("\n--- Testando Facade ---");
		ICepService cepService = CepApi.getInstancia();
		ICrmService crmService = CrmService.getInstancia();
		
		Facade facade = new Facade(cepService, crmService);
		facade.migrarCliente("Venilton", "14801788");
		
		// Teste opcional de validação de parâmetros que adicionamos na Facade:
		try {
			facade.migrarCliente("João", "123"); // CEP inválido propositalmente
		} catch (IllegalArgumentException e) {
			System.out.println("Validação funcionou com sucesso: " + e.getMessage());
		}
	}

}