public class exercicio_3 {
	static int iteracoes = 0;
	static class Item {
		int peso;
		int valor;
		Item(int peso, int valor) {
			this.peso = peso;
			this.valor = valor;
		}
	}
	static int mochilaBruta(Item[] itens, int n, int capacidade) {
		iteracoes++;
		if (n == 0 || capacidade == 0) {
			return 0;
		}
		if (itens[n-1].peso > capacidade) {
			return mochilaBruta(itens, n-1, capacidade);
		} else {
			int inclui = itens[n-1].valor + mochilaBruta(itens, n-1, capacidade - itens[n-1].peso);
			int exclui = mochilaBruta(itens, n-1, capacidade);
			return Math.max(inclui, exclui);
		}
	}

	public static void main(String[] args) {
		// 3 itens: (peso, valor)
		Item[] itens = {
			new Item(2, 3),
			new Item(3, 4),
			new Item(4, 5)
		};
		int capacidade = 5;
		iteracoes = 0;
		int resultado = mochilaBruta(itens, itens.length, capacidade);
		System.out.println("Caso 1: capacidade = " + capacidade);
		System.out.println("Valor máximo: " + resultado);
		System.out.println("Iterações: " + iteracoes);

		Item[] itens2 = {
			new Item(1, 1),
			new Item(2, 6),
			new Item(3, 10),
			new Item(5, 16)
		};
		capacidade = 7;
		iteracoes = 0;
		resultado = mochilaBruta(itens2, itens2.length, capacidade);
		System.out.println("\nCaso 2: capacidade = " + capacidade);
		System.out.println("Valor máximo: " + resultado);
		System.out.println("Iterações: " + iteracoes);
	}
}
