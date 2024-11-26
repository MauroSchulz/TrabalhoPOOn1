package Atividades;

public class Notas {

    // Modelo
    static class NotasModel {
        private double[] notas;

        public NotasModel(double[] notas) {
            this.notas = notas;
        }

        public double[] getNotas() {
            return notas;
        }
    }

    // Controle
    static class NotasController {
        private NotasModel model;

        public NotasController(NotasModel model) {
            this.model = model;
        }

        public double calcularMedia() {
            double soma = 0;
            for (double nota : model.getNotas()) {
                soma += nota;
            }
            return soma / model.getNotas().length;
        }

        public double[] filtrarNotasMaioresQueMedia() {
            double media = calcularMedia();
            return java.util.Arrays.stream(model.getNotas())
                    .filter(nota -> nota > media)
                    .toArray();
        }
    }

    // Visão
    static class NotasView {
        public void exibirResultados(double media, double[] notasMaiores) {
            System.out.printf("Média das notas: %.2f%n", media);
            System.out.println("Notas maiores que a média:");
            for (double nota : notasMaiores) {
                System.out.println(nota);
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Inicializando dados
        double[] notas = {7.5, 8.0, 6.5, 9.0, 7.0, 8.5, 5.0, 10.0, 6.0, 7.8};
        NotasModel model = new NotasModel(notas);

        // Executando o controlador
        NotasController controller = new NotasController(model);
        double media = controller.calcularMedia();
        double[] notasMaiores = controller.filtrarNotasMaioresQueMedia();

        // Exibindo os resultados
        NotasView view = new NotasView();
        view.exibirResultados(media, notasMaiores);
    }
}