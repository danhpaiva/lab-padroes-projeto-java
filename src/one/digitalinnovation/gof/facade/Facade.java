package one.digitalinnovation.gof.facade;

import subsistema1.crm.ICrmService;
import subsistema2.cep.ICepService;

/**
 * Implementação aprimorada do padrão Facade utilizando Injeção de Dependências
 * para maior testabilidade e desacoplamento.
 */
public class Facade {

	private final ICepService cepService;
	private final ICrmService crmService;

	public Facade(ICepService cepService, ICrmService crmService) {
		this.cepService = cepService;
		this.crmService = crmService;
	}

	public void migrarCliente(String nome, String cep) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
		}
		if (cep == null || !cep.matches("\\d{8}")) {
			throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos numéricos.");
		}

		String cidade = cepService.recuperarCidade(cep);
		String estado = cepService.recuperarEstado(cep);
		
		crmService.gravarCliente(nome, cep, cidade, estado);
	}
}