package subsistema1.crm;

import java.util.logging.Logger;

public class CrmService implements ICrmService {

	private static final Logger LOGGER = Logger.getLogger(CrmService.class.getName());

	private CrmService() {
		super();
	}

	private static class Holder {
		private static final CrmService INSTANCE = new CrmService();
	}

	public static CrmService getInstancia() {
		return Holder.INSTANCE;
	}
	
	@Override
	public void gravarCliente(String nome, String cep, String cidade, String estado) {
		LOGGER.info(() -> String.format("Cliente salvo no sistema de CRM:%nNome: %s%nCEP: %s%nCidade: %s%nEstado: %s", 
				nome, cep, cidade, estado));
	}
}