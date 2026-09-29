public final class Dinheiro {
    private final double quantia;

    public Dinheiro(double quantia) {
        if (quantia < 0) {
            throw new IllegalArgumentException("O custo da manutenção não pode ser negativo.");
        }
        this.quantia = quantia;
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.quantia + outro.quantia);
    }

    public double quantia() {
        return quantia;
    }
}