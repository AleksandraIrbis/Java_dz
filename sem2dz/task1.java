package sem2dz;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Исходный массив:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);

        scanner.close();
    }

   
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write("Итерация 0: ");
            printArrayToFile(array, writer);

            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        // Обмен элементов
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                if (swapped) {
                    writer.write("Итерация " + (i + 1) + ": ");
                    printArrayToFile(array, writer);
                } else {
                    break;
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог-файл.");
            e.printStackTrace();
        }
    }

    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    
    public static void printArrayToFile(int[] array, FileWriter writer) throws IOException {
        for (int i = 0; i < array.length; i++) {
            writer.write(array[i] + " ");
        }
        writer.write("\n");
    }
}