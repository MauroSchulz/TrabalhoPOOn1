package Atividades;

public class DivisaoApp {

    // Exceção personalizada
    static class DivisaoPorZeroException extends Exception {
        public DivisaoPorZeroException(String message) {
            super(message);
        }
    }

    // Modelo
    static class Divisao {
        public double calcularDivisao(double a, double b) throws DivisaoPorZeroException {
            if (b == 0) {
                throw new DivisaoPorZeroException("Divisão por zero não é permitida!");
            }
            return a / b;
        }
    }

    // Controle
    static class DivisaoController {
        private Divisao divisao;

        public DivisaoController() {
            this.divisao = new Divisao();
        }

        public double dividir(double a, double b) {
            try {
                return divisao.calcularDivisao(a, b);
            } catch (DivisaoPorZeroException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }
    }

    // Visão
    static class DivisaoView {
        public void exibirResultado(double resultado) {
            System.out.println("Resultado da divisão: " + resultado);
        }
    }

    // Método principal
    public static void main(String[] args) {
        DivisaoController controller = new DivisaoController();
        DivisaoView view = new DivisaoView();

        // Testando divisões
        double resultado1 = controller.dividir(10, 2);
        view.exibirResultado(resultado1);

        double resultado2 = controller.dividir(10, 0);
        view.exibirResultado(resultado2);
    }
}
