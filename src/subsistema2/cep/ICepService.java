package subsistema2.cep;

public interface ICepService {
    String recuperarCidade(String cep);
    String recuperarEstado(String cep);
}
