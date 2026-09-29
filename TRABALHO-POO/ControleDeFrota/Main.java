public class Main {
    public static void main(String[] args) {

        ControleDeFrota controle = new ControleDeFrota();

        controle.cadastrarVeiculo("ABC1D23", "Fiorino 1.4", 45000, 10000);
        controle.cadastrarVeiculo("XYZ9K88", "Sprinter 2.2", 120000, 15000);

        controle.atualizarQuilometragem("ABC1D23", 48000);
        controle.registrarManutencao("ABC1D23", "10/01/2026", "PREVENTIVA", 850f);

        controle.atualizarQuilometragem("ABC1D23", 58500);
        controle.registrarManutencao("ABC1D23", "02/03/2026", "CORRETIVA", 1200f);

        controle.atualizarQuilometragem("XYZ9K88", 134000);

        controle.imprimirRelatorio("ABC1D23");
        System.out.println("----");
        controle.imprimirRelatorio("XYZ9K88");

        System.out.println("----");
        System.out.println("ABC1D23 precisa manutencao? " + controle.precisaManutencao("ABC1D23"));
        System.out.println("XYZ9K88 precisa manutencao? " + controle.precisaManutencao("XYZ9K88"));
    }
}