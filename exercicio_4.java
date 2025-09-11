public class exercicio_4 {
	static class Item {
		int peso;
		int valor;
		Item(int peso, int valor) {
			this.peso = peso;
			this.valor = valor;
		}
	}

	static int mochilaPD(Item[] itens, int capacidade) {

		int n = itens.length;
		int[][] maxTab = new int[n+1][capacidade+1];
		int iteracoes = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= capacidade; j++) {
				iteracoes++;
				if (itens[i-1].peso <= j) {
					maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i-1].valor + maxTab[i-1][j - itens[i-1].peso]);
				} else {
					maxTab[i][j] = maxTab[i-1][j];
				}
			}
		}
		System.out.println("Valor máximo: " + maxTab[n][capacidade]);
		System.out.println("Iterações: " + iteracoes);
		return maxTab[n][capacidade];
	}

	public static void main(String[] args) {
		// Caso de teste 1
		Item[] itens = {
			new Item(2, 3),
			new Item(3, 4),
			new Item(4, 5)
		};
		int capacidade = 5;
		System.out.println("Caso 1: capacidade = " + capacidade);
		mochilaPD(itens, capacidade);

		// Caso de teste 2
		Item[] itens2 = {
			new Item(1, 1),
			new Item(2, 6),
			new Item(3, 10),
			new Item(5, 16)
		};
		capacidade = 7;
		System.out.println("\nCaso 2: capacidade = " + capacidade);
		mochilaPD(itens2, capacidade);
	}
}
