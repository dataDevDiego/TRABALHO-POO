import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DataManutencao {
    private final LocalDate data;
    private final String dataOriginal;

    public DataManutencao(String dataStr) {
        try {
            this.data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (this.data.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data da manutenção não pode ser no futuro.");
            }
            this.dataOriginal = dataStr;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Utilize dd/MM/yyyy.");
        }
    }

    public String formatada() {
        return dataOriginal;
    }
}