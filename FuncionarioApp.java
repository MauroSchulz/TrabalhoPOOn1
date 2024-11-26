package Atividades;

import java.util.HashMap;

public class FuncionarioApp {

    // Modelo
    static class Funcionario {
        private int id;
        private String nome;

        public Funcionario(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
    }

    // Controle
    static class FuncionarioController {
        private HashMap<Integer, Funcionario> funcionarios;

        public FuncionarioController() {
            this.funcionarios = new HashMap<>();
        }

        public void adicionarFuncionario(Funcionario funcionario) {
            funcionarios.put(funcionario.getId(), funcionario);
        }

        public Funcionario buscarFuncionario(int id) {
            return funcionarios.get(id);
        }

        public HashMap<Integer, Funcionario> listarFuncionarios() {
            return funcionarios;
        }
    }

    // Visão
    static class FuncionarioView {
        public void exibirFuncionario(Funcionario funcionario) {
            if (funcionario != null) {
                System.out.println("Funcionário encontrado: " + funcionario.getNome());
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        }

        public void exibirTodos(HashMap<Integer, Funcionario> funcionarios) {
            System.out.println("Lista de Funcionários:");
            funcionarios.forEach((id, func) -> 
                System.out.println("ID: " + id + ", Nome: " + func.getNome())
            );
        }
    }

    // Método principal
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        FuncionarioView view = new FuncionarioView();

        // Adicionando funcionários
        controller.adicionarFuncionario(new Funcionario(1, "Ana"));
        controller.adicionarFuncionario(new Funcionario(2, "Carlos"));
        controller.adicionarFuncionario(new Funcionario(3, "Maria"));

        // Exibindo todos
        view.exibirTodos(controller.listarFuncionarios());

        // Buscando um funcionário específico
        Funcionario funcionario = controller.buscarFuncionario(2);
        view.exibirFuncionario(funcionario);
    }
}

