package subsistema2.cep;

public class CepApi implements ICepService {

	private static CepApi instancia = new CepApi();

	private CepApi() {
		super();
	}

	public static CepApi getInstancia() {
		return instancia;
	}
	
	@Override
	public String recuperarCidade(String cep) {
		// Poderia integrar com uma API real de consulta de CEP (ex: ViaCEP)
		return "Araraquara";
	}
	
	@Override
	public String recuperarEstado(String cep) {
		return "SP";
	}
}