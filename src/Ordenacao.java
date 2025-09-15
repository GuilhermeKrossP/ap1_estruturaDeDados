public class Ordenacao {
    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercalar(vetor, inicio, meio, fim);
        }
    }

    private static void intercalar(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++) esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++) direita[j] = vetor[meio + 1 + j];

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) vetor[k++] = esquerda[i++];
            else vetor[k++] = direita[j++];
        }
        while (i < n1) vetor[k++] = esquerda[i++];
        while (j < n2) vetor[k++] = direita[j++];
    }

    public static void ordenarPorLinhas(Matriz m, int algoritmo) {
        for (int i = 0; i < m.getLinhas(); i++) {
            if (algoritmo == 1) bubbleSort(m.getDados()[i]);
            else mergeSort(m.getDados()[i], 0, m.getColunas() - 1);
        }
    }

    public static void ordenarPorColunas(Matriz m, int algoritmo) {
        int linhas = m.getLinhas();
        int colunas = m.getColunas();
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) coluna[i] = m.getDados()[i][j];

            if (algoritmo == 1) bubbleSort(coluna);
            else mergeSort(coluna, 0, linhas - 1);

            for (int i = 0; i < linhas; i++) m.getDados()[i][j] = coluna[i];
        }
    }

    public static void ordenarMatrizCompleta(Matriz m, int algoritmo) {
        int linhas = m.getLinhas();
        int colunas = m.getColunas();
        int[] vetor = new int[linhas * colunas];
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = m.getDados()[i][j];
            }
        }

        if (algoritmo == 1) bubbleSort(vetor);
        else mergeSort(vetor, 0, vetor.length - 1);

        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                m.getDados()[i][j] = vetor[index++];
            }
        }
    }
}