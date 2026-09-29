public class Manutencao {
    private final DataManutencao data;
    private final TipoManutencao tipo;
    private final Dinheiro custo;
    private final Quilometragem kmNoMomento;

    public Manutencao(DataManutencao data, TipoManutencao tipo, Dinheiro custo, Quilometragem kmNoMomento) {
        this.data = data;
        this.tipo = tipo;
        this.custo = custo;
        this.kmNoMomento = kmNoMomento;
    }

    public boolean isPreventiva() {
        return this.tipo == TipoManutencao.PREVENTIVA;
    }

    public Dinheiro getCusto() {
        return custo;
    }

    public void imprimirLinhaHistorico() {
        System.out.println("  " + data.formatada() + " - " + tipo + " - R$ " + custo.quantia());
    }
}