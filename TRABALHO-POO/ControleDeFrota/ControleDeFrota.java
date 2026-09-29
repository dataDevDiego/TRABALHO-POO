import java.util.HashMap;
import java.util.Map;

public class ControleDeFrota {
    private final Map<String, Veiculo> frota = new HashMap<>();

    public void cadastrarVeiculo(String placaStr, String modelo, double kmAtual, double intervalo) {
        if (frota.containsKey(placaStr)) {
            throw new IllegalStateException("Veículo com a placa " + placaStr + " já está cadastrado.");
        }
        Placa placa = new Placa(placaStr);
        Veiculo v = new Veiculo(placa, modelo, new Quilometragem(kmAtual), new Quilometragem(intervalo));
        frota.put(placaStr, v);
    }

    public void atualizarQuilometragem(String placaStr, double novaKm) {
        Veiculo v = buscarVeiculo(placaStr);
        if (v != null) {
            try {
                v.atualizarQuilometragem(new Quilometragem(novaKm));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registrarManutencao(String placaStr, String data, String tipo, float custo) {
        Veiculo v = buscarVeiculo(placaStr);
        if (v != null) {
            try {
                v.registrarManutencao(
                    new DataManutencao(data), 
                    TipoManutencao.valueOf(tipo.toUpperCase()), 
                    new Dinheiro(custo)
                );
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean precisaManutencao(String placaStr) {
        Veiculo v = frota.get(placaStr);
        if (v != null) {
            return v.precisaManutencao();
        }
        return false;
    }

    public void imprimirRelatorio(String placaStr) {
        Veiculo v = buscarVeiculo(placaStr);
        if (v != null) {
            v.imprimirRelatorio();
        }
    }

    private Veiculo buscarVeiculo(String placaStr) {
        Veiculo v = frota.get(placaStr);
        if (v == null) {
            System.out.println("Veiculo nao encontrado: " + placaStr);
        }
        return v;
    }
}