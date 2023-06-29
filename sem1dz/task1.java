import java.util.Scanner;

public class task1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("n-ое треугольное число: " + triangularNumber);

        long factorial = calculateFactorial(n);
        System.out.println("Факториал числа n: " + factorial);

        scanner.close();
    }

    public static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
