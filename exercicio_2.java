public class exercicio_2 {

    private static int iteracoes = 0;
    private static int instrucoes = 0;

    public static long fiboRec(int n) {
        instrucoes += 2; // if + return
        if (n <= 1) {
            return n;
        } else {
            instrucoes += 3; // 2 chamadas recursivas + soma
            iteracoes++;
            long a = fiboRec(n - 1);
            long b = fiboRec(n - 2);
            return a + b;
        }
    }

    public static long fibo(int n) {
        instrucoes += 2; // if + return
        if (n <= 1) {
            return n;
        }
        
        instrucoes += 3; // declaração array + 2 atribuições
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        
        instrucoes += 2; // for + condição
        for (int i = 2; i <= n; i++) {
            iteracoes++;
            instrucoes += 3; // acesso array + soma + atribuição
            f[i] = f[i-1] + f[i-2];
        }
        
        instrucoes += 1; // return
        return f[n];
    }

    public static long memoizedFibo(int n) {
        instrucoes += 2; // declaração array + for
        long[] f = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            iteracoes++;
            instrucoes += 2; // atribuição + incremento
            f[i] = -1;
        }
        instrucoes += 1; // return
        return lookupFibo(f, n);
    }
    
    public static long lookupFibo(long[] f, int n) {
        instrucoes += 2; // if + return
        if (f[n] >= 0) {
            return f[n];
        }
        
        instrucoes += 2; // if + return
        if (n <= 1) {
            instrucoes += 1; // atribuição
            f[n] = n;
        } else {
            instrucoes += 3; // 2 chamadas recursivas + atribuição
            iteracoes++;
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        
        instrucoes += 1; // return
        return f[n];
    }

    public static void resetContadores() {
        iteracoes = 0;
        instrucoes = 0;
    }

    public static void main(String[] args) {
        System.out.println("=== CONTABILIZAÇÃO DOS ALGORITMOS DE FIBONACCI ===\n");
        
        int[] testValues1 = {4, 8, 16, 32};
        int[] testValues2 = {128, 1000, 10000};
        
        System.out.println("TABELA DE RESULTADOS E CONTABILIZAÇÃO");
        System.out.println("=====================================");
        System.out.printf("%-15s | %-8s | %-12s | %-15s | %-15s%n", 
                        "Algoritmo", "n", "Resultado", "Iterações", "Instruções");
        System.out.println("-----------------|----------|--------------|-----------------|-----------------");
        
        for (int n : testValues1) {
            resetContadores();
            long resultado = fiboRec(n);
            System.out.printf("%-15s | %-8d | %-12d | %-15d | %-15d%n", 
                            "FIBO-REC", n, resultado, iteracoes, instrucoes);
            
            resetContadores();
            resultado = fibo(n);
            System.out.printf("%-15s | %-8d | %-12d | %-15d | %-15d%n", 
                            "FIBO", n, resultado, iteracoes, instrucoes);
            
            resetContadores();
            resultado = memoizedFibo(n);
            System.out.printf("%-15s | %-8d | %-12d | %-15d | %-15d%n", 
                            "MEMOIZED-FIBO", n, resultado, iteracoes, instrucoes);
            System.out.println("-----------------|----------|--------------|-----------------|-----------------");
        }
        
        System.out.println("\nTESTES ADICIONAIS (n = 128, 1000, 10000)");
        System.out.println("=========================================");
        System.out.printf("%-15s | %-8s | %-12s | %-15s | %-15s%n", 
                        "Algoritmo", "n", "Resultado", "Iterações", "Instruções");
        System.out.println("-----------------|----------|--------------|-----------------|-----------------");
        
        for (int n : testValues2) {
            resetContadores();
            long resultado = fibo(n);
            System.out.printf("%-15s | %-8d | %-12d | %-15d | %-15d%n", 
                            "FIBO", n, resultado, iteracoes, instrucoes);
            
            resetContadores();
            resultado = memoizedFibo(n);
            System.out.printf("%-15s | %-8d | %-12d | %-15d | %-15d%n", 
                            "MEMOIZED-FIBO", n, resultado, iteracoes, instrucoes);
            System.out.println("-----------------|----------|--------------|-----------------|-----------------");
        }
        
        System.out.println("\n=== ANÁLISE DE COMPLEXIDADE ===");
        System.out.println("FIBO-REC: O(2^n) - Exponencial (muito lento para n grandes)");
        System.out.println("FIBO: O(n) - Linear (eficiente)");
        System.out.println("MEMOIZED-FIBO: O(n) - Linear com overhead de recursão");
    }
}