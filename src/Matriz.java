import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];
    }

    public void preencherManual() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                dados[i][j] = sc.nextInt();
            }
        }
    }

    public void preencherAutomatico() {
        Random rand = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = rand.nextInt(20) + 1;
            }
        }
    }

    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            dados[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void exibir() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(dados[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public int[][] getDados() {
        return dados;
    }
}
