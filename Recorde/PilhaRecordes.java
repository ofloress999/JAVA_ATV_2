package Recorde;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Stack;

public class PilhaRecordes {
    private Stack<Recorde> pilha;
    private int capacidade;

    public PilhaRecordes(int capacidade) {
        this.pilha = new Stack<>();
        this.capacidade = capacidade;
    }

    public void pushRecorde(Recorde novoRecorde) {
        if (pilha.isEmpty() || novoRecorde.getTempo() < pilha.peek().getTempo()) {
            pilha.push(novoRecorde);
        }
    }

    public Recorde topo() {
        if (pilha.isEmpty()) {
            return null;
        }
        return pilha.peek();
    }

    public void popRecorde() {
        if (!pilha.isEmpty()) {
            pilha.pop();
        }
    }

    public void listarRecordes() {
        for (Recorde recorde : pilha) {
            System.out.println(recorde);
        }
    }

    public void redimensionarPilha() {
        if (pilha.size() >= capacidade) {
            Stack<Recorde> novaPilha = new Stack<>();
            novaPilha.addAll(pilha);
            pilha = novaPilha;
            capacidade *= 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tamanho inicial da pilha:");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        PilhaRecordes pilhaRecordes = new PilhaRecordes(tamanho);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar recorde");
            System.out.println("2 - Consultar topo");
            System.out.println("3 - Remover recorde do topo");
            System.out.println("4 - Listar recordes");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do atleta:");
                    String nome = scanner.nextLine();

                    System.out.println("Data do recorde (dd/MM/yyyy):");
                    String dataStr = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    System.out.println("Tempo do recorde:");
                    double tempo = scanner.nextDouble();
                    scanner.nextLine();

                    Recorde novoRecorde = new Recorde(data, tempo, nome);
                    pilhaRecordes.redimensionarPilha();
                    pilhaRecordes.pushRecorde(novoRecorde);
                    break;

                case 2:
                    Recorde topo = pilhaRecordes.topo();
                    if (topo != null) {
                        System.out.println(topo);
                    }
                    break;

                case 3:
                    pilhaRecordes.popRecorde();
                    break;

                case 4:
                    pilhaRecordes.listarRecordes();
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
