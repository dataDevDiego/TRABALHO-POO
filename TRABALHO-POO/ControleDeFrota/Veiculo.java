import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private final Placa placa;
    private final String modelo;
    private Quilometragem atual;
    private Quilometragem ultimaPreventiva;
    private final Quilometragem intervaloManutencao;
    private final List<Manutencao> historico; // Coleção de 1ª classe interna

    public Veiculo(Placa placa, String modelo, Quilometragem inicial, Quilometragem intervalo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("Modelo é obrigatório.");
        }
        this.placa = placa;
        this.modelo = modelo;
        this.atual = inicial;
        this.ultimaPreventiva = inicial;
        this.intervaloManutencao = intervalo;
        this.historico = new ArrayList<>();
    }

    public void atualizarQuilometragem(Quilometragem novaKm) {
        if (novaKm.isMenorQue(this.atual)) {
            throw new IllegalArgumentException("A quilometragem de um veículo nunca pode retroceder.");
        }
        this.atual = novaKm;
    }

    public void registrarManutencao(DataManutencao data, TipoManutencao tipo, Dinheiro custo) {
        Manutencao manutencao = new Manutencao(data, tipo, custo, this.atual);
        this.historico.add(manutencao);
        
        if (manutencao.isPreventiva()) {
            this.ultimaPreventiva = this.atual;
        }
    }

    public boolean precisaManutencao() {
        Quilometragem rodadosDesdePreventiva = this.atual.diferenca(this.ultimaPreventiva);
        return rodadosDesdePreventiva.isMaiorOuIgual(this.intervaloManutencao);
    }

    public Dinheiro calcularCustoTotal() {
        Dinheiro total = new Dinheiro(0);
        for (Manutencao m : historico) {
            total = total.somar(m.getCusto());
        }
        return total;
    }

    public void imprimirRelatorio() {
        System.out.println("Placa: " + placa.valor());
        System.out.println("Modelo: " + modelo);
        System.out.println("KM atual: " + atual.valor());
        System.out.println("Precisa manutencao? " + (precisaManutencao() ? "SIM" : "NAO"));
        System.out.println("Custo total de manutencao: R$ " + calcularCustoTotal().quantia());
        System.out.println("Historico:");
        for (Manutencao m : historico) {
            m.imprimirLinhaHistorico();
        }
    }
}