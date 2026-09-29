import java.util.HashMap;
import java.util.Map;

public class ControleAcademico {
    private final Map<String, Turma> turmas = new HashMap<>();

    public void criarTurma(String codigo, int capacidade) {
        if (turmas.containsKey(codigo)) {
            throw new IllegalArgumentException("Turma com este código já existe.");
        }
        turmas.put(codigo, new Turma(codigo, capacidade));
    }

    public void matricular(String codigoTurma, String nomeAluno) {
        Turma turma = buscarTurma(codigoTurma);
        if (turma != null) {
            try {
                turma.matricular(new Aluno(nomeAluno));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void lancarNota(String codigoTurma, String nomeAluno, double valorNota) {
        Turma turma = buscarTurma(codigoTurma);
        if (turma != null) {
            try {
                turma.lancarNota(new Aluno(nomeAluno), new Nota(valorNota));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void imprimirTurma(String codigoTurma) {
        Turma turma = buscarTurma(codigoTurma);
        if (turma != null) {
            turma.imprimirRelatorio();
        }
    }

    private Turma buscarTurma(String codigo) {
        Turma turma = turmas.get(codigo);
        if (turma == null) {
            System.out.println("Turma nao encontrada: " + codigo);
        }
        return turma;
    }
}