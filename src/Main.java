import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Linhas: ");
        int linhas = sc.nextInt();
        System.out.print("Colunas: ");
        int colunas = sc.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        System.out.print("Preenchimento (1-Manual 2-Aleatório): ");
        if (sc.nextInt() == 1) matriz.preencherManual();
        else matriz.preencherAutomatico();

        System.out.println("Matriz inicial:");
        matriz.exibir();

        System.out.print("Remover elemento? (s/n): ");
        if (sc.next().equalsIgnoreCase("s")) {
            System.out.print("Linha: ");
            int l = sc.nextInt();
            System.out.print("Coluna: ");
            int c = sc.nextInt();
            matriz.removerElemento(l, c);
        }

        System.out.println("Matriz atualizada:");
        matriz.exibir();

        System.out.print("Escolha algoritmo (1-Bubble 2-Merge): ");
        int algoritmo = sc.nextInt();

        System.out.print("Ordenar (1-Linhas 2-Colunas 3-Toda matriz): ");
        int tipo = sc.nextInt();

        switch (tipo) {
            case 1 -> Ordenacao.ordenarPorLinhas(matriz, algoritmo);
            case 2 -> Ordenacao.ordenarPorColunas(matriz, algoritmo);
            case 3 -> Ordenacao.ordenarMatrizCompleta(matriz, algoritmo);
        }

        System.out.println("Matriz ordenada:");
        matriz.exibir();
    }
}