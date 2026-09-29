public class Matricula {
    private final Aluno aluno;
    private Nota nota;

    public Matricula(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }
        this.aluno = aluno;
        this.nota = null;
    }

    public void lancarNota(Nota nota) {
        if (nota == null) {
            throw new IllegalArgumentException("A nota não pode ser nula.");
        }
        this.nota = nota;
    }

    public boolean isAprovado() {
        return this.nota != null && this.nota.isAprovativa();
    }

    public boolean isDoAluno(Aluno outroAluno) {
        return this.aluno.equals(outroAluno);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Nota getNota() {
        return nota;
    }
}