    public class Main {
    public static void main(String[] args) {

        ControleAcademico academico = new ControleAcademico();

        academico.criarTurma("POO-2026A", 3);

        academico.matricular("POO-2026A", "Ana");
        academico.matricular("POO-2026A", "Bruno");
        academico.matricular("POO-2026A", "Ana"); // Rejeitado explicitamente pelo domínio

        academico.lancarNota("POO-2026A", "Ana", 8.5);
        academico.lancarNota("POO-2026A", "Bruno", 5.0);

        academico.matricular("POO-2026A", "Carla");
        academico.matricular("POO-2026A", "Diego"); // Rejeitado explicitamente pelo limite da turma

        academico.imprimirTurma("POO-2026A");
    }
}