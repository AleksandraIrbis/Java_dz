package sem2dz;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.println("Выберите операцию: ");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");

        int choice = scanner.nextInt();
        double result = 0;

        switch (choice) {
            case 1:
                result = num1 + num2;
                logOperation(num1, num2, "+", result);
                break;
            case 2:
                result = num1 - num2;
                logOperation(num1, num2, "-", result);
                break;
            case 3:
                result = num1 * num2;
                logOperation(num1, num2, "*", result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    logOperation(num1, num2, "/", result);
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Неверный выбор операции!");
                System.exit(0);
        }

        System.out.println("Результат: " + result);

        scanner.close();
    }


    public static void logOperation(double num1, double num2, String operator, double result) {
        try {
            FileWriter writer = new FileWriter("calc.txt", true);
            writer.write(num1 + " " + operator + " " + num2 + " = " + result + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог-файл.");
            e.printStackTrace();
        }
    }
}
