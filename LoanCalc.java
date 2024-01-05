public class LoanCalc {
    
    static double epsilon = 0.001;  // The computation tolerance (estimation error)
    static int iterationCounter;    // Monitors the efficiency of the calculation
    
    public static void main(String[] args) {        
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
        
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }
    
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
        double x = loan / n;
        while (endBalance(loan, rate, n, x) >= 0) {
            x += 0.01;
            iterationCounter++;
        }
        return x;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double h = loan + (loan * rate / 100) + 1; 
        double l = loan / n;
        double x = (h + l) / 2;  
        iterationCounter = 0; 
        while (h - l > epsilon) {
            if (endBalance(loan, rate, n, x) * endBalance(loan, rate, n, l) > 0) {
                l = x;
            } else {
                h = x;
            }
            x = (h + l) / 2;
            iterationCounter++;
        } 
        return x;
    }
    
    private static double endBalance(double loan, double rate, int n, double payment) {
        double sloan = loan * Math.pow(1 + rate / 100, n);
        double debt = sloan - n * payment;  
        return debt;
    }
}
