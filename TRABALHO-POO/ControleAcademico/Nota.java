public class Nota {
    private final double valor;

    public Nota(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.valor = valor;
    }

    public boolean isAprovativa() {
        return this.valor >= 6.0;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}