public final class Quilometragem {
    private final double km;

    public Quilometragem(double km) {
        if (km < 0) {
            throw new IllegalArgumentException("A quilometragem não pode ser negativa.");
        }
        this.km = km;
    }

    public boolean isMenorQue(Quilometragem outra) {
        return this.km < outra.km;
    }

    public Quilometragem diferenca(Quilometragem outra) {
        return new Quilometragem(this.km - outra.km);
    }

    public boolean isMaiorOuIgual(Quilometragem outra) {
        return this.km >= outra.km;
    }

    public double valor() {
        return km;
    }
}