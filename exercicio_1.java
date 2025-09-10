public class exercicio_1 {

    public static long fiboRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            long a = fiboRec(n - 1);
            long b = fiboRec(n - 2);
            return a + b;
        }
    }

    public static long fibo(int n) {
        if (n <= 1) {
            return n;
        }
        
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }

    public static long memoizedFibo(int n) {
        long[] f = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }
    
    public static long lookupFibo(long[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }
        
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println("=== TESTE DOS ALGORITMOS DE FIBONACCI ===");
        
        int[] testValues1 = {4, 8, 16, 32};
        
        System.out.println("Testes para n = 4, 8, 16, 32:");
        System.out.println("=====================================");
        
        for (int n : testValues1) {
            System.out.println("\n--- n = " + n + " ---");
            System.out.println("FIBO-REC(" + n + ") = " + fiboRec(n));
            System.out.println("FIBO(" + n + ") = " + fibo(n));
            System.out.println("MEMOIZED-FIBO(" + n + ") = " + memoizedFibo(n));
        }
        
        int[] testValues2 = {128, 1000, 10000};
        
        System.out.println("\n\nTestes adicionais para n = 128, 1000, 10000:");
        System.out.println("===============================================");
        
        for (int n : testValues2) {
            System.out.println("\n--- n = " + n + " ---");
            System.out.println("FIBO(" + n + ") = " + fibo(n));
            System.out.println("MEMOIZED-FIBO(" + n + ") = " + memoizedFibo(n));
        }
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
