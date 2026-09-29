import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final String codigo;
    private final int capacidadeMaxima;
    private final List<Matricula> matriculas;

    public Turma(String codigo, int capacidadeMaxima) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O código da turma é obrigatório.");
        }
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("A capacidade máxima deve ser maior que zero.");
        }
        this.codigo = codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.matriculas = new ArrayList<>();
    }

    public void matricular(Aluno aluno) {
        for (Matricula m : matriculas) {
            if (m.isDoAluno(aluno)) {
                throw new IllegalStateException("Aluno ja matriculado nesta turma.");
            }
        }
        if (matriculas.size() >= capacidadeMaxima) {
            throw new IllegalStateException("Turma cheia: " + codigo);
        }
        matriculas.add(new Matricula(aluno));
    }

    public void lancarNota(Aluno aluno, Nota nota) {
        for (Matricula m : matriculas) {
            if (m.isDoAluno(aluno)) {
                m.lancarNota(nota);
                return;
            }
        }
        throw new IllegalArgumentException("Matricula nao encontrada.");
    }

    public int getQuantidadeAprovados() {
        int aprovados = 0;
        for (Matricula m : matriculas) {
            if (m.isAprovado()) {
                aprovados++;
            }
        }
        return aprovados;
    }

    public void imprimirRelatorio() {
        System.out.println("Turma: " + codigo);
        for (Matricula m : matriculas) {
            String situacao = (m.getNota() == null) ? "sem nota" : m.getNota().toString();
            System.out.println("  " + m.getAluno().getNome() + " - nota: " + situacao);
        }
        System.out.println("Aprovados: " + getQuantidadeAprovados());
    }
}