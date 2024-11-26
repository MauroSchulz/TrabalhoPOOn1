package Atividades;

import java.util.ArrayList;

public class BancoApp {

    // Modelo
    static class Conta {
        private int numeroConta;
        private String titular;

        public Conta(int numeroConta, String titular) {
            this.numeroConta = numeroConta;
            this.titular = titular;
        }

        public int getNumeroConta() {
            return numeroConta;
        }

        public String getTitular() {
            return titular;
        }
    }

    static class Banco {
        private String nomeDoBanco;
        private ArrayList<Conta> contas;

        public Banco(String nomeDoBanco) {
            this.nomeDoBanco = nomeDoBanco;
            this.contas = new ArrayList<>();
        }

        public void adicionarConta(Conta conta) {
            contas.add(conta);
        }

        public Conta recuperarConta(int numeroConta) {
            for (Conta conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    return conta;
                }
            }
            return null;
        }

        public ArrayList<Conta> getContas() {
            return contas;
        }
    }

    // Visão
    static class BancoView {
        public void exibirConta(Conta conta) {
            if (conta != null) {
                System.out.println("Conta encontrada: " + conta.getNumeroConta() + " - Titular: " + conta.getTitular());
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        public void exibirTodasContas(ArrayList<Conta> contas) {
            System.out.println("Lista de Contas:");
            for (Conta conta : contas) {
                System.out.println("Conta: " + conta.getNumeroConta() + ", Titular: " + conta.getTitular());
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Central");
        BancoView view = new BancoView();

        // Adicionando contas
        banco.adicionarConta(new Conta(101, "Ana"));
        banco.adicionarConta(new Conta(102, "Carlos"));
        banco.adicionarConta(new Conta(103, "Maria"));

        // Exibindo todas as contas
        view.exibirTodasContas(banco.getContas());

        // Recuperando uma conta específica
        Conta conta = banco.recuperarConta(102);
        view.exibirConta(conta);
    }
}
