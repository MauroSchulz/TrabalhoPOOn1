package Atividades;

import java.util.ArrayList;

public class Numeros {

    // Modelo
    static class NumerosModel {
        private ArrayList<Integer> numeros;

        public NumerosModel() {
            this.numeros = new ArrayList<>();
        }

        public ArrayList<Integer> getNumeros() {
            return numeros;
        }

        public void adicionarNumero(int numero) {
            numeros.add(numero);
        }
    }

    // Controle
    static class NumerosController {
        private NumerosModel model;

        public NumerosController(NumerosModel model) {
            this.model = model;
        }

        public void preencherNumeros() {
            for (int i = 1; i <= 30; i++) {
                model.adicionarNumero(i);
            }
        }
    }

    // Visão
    static class NumerosView {
        public void exibirNumeros(ArrayList<Integer> numeros) {
            System.out.println("Números inseridos no ArrayList:");
            for (int numero : numeros) {
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Inicializando o modelo
        NumerosModel model = new NumerosModel();

        // Preenchendo os números via controlador
        NumerosController controller = new NumerosController(model);
        controller.preencherNumeros();

        // Exibindo os números
        NumerosView view = new NumerosView();
        view.exibirNumeros(model.getNumeros());
    }
}
