public final class Placa {
    private final String valor;

    public Placa(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("A placa não pode ser nula ou vazia.");
        }
        this.valor = valor;
    }

    public String valor() {
        return valor;
    }
}